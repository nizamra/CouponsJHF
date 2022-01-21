package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DBConnection {

	Connection con = null;

	String url = "jdbc:mysql://localhost:3306/phase1";
	String user = "root";
	String password = "SysOps@99";

	private static Set<Connection> connections = new HashSet<Connection>(10);
	private static DBConnection instance = null;

	private DBConnection() {
		int i = 10;
		try {
			while (i > 0) {
				Connection conn = createConnection();
				connections.add(conn);
				i--;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public synchronized Connection getConnection() throws InterruptedException {
		Connection con = null;
		if (connections.isEmpty()) {
			wait();
		} else {
			Iterator<Connection> it = connections.iterator();
			con = it.next();
			connections.remove(con);
		}
		return con;
	}

	public static DBConnection createInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	private Connection createConnection() {
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return con;
	}

	public void closeConnection() throws SQLException {
		Iterator<Connection> it = connections.iterator();
		while (it.next() != null) {
			it.next().close();
		}
	}
}
