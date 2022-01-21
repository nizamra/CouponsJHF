package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Category;
import utils.DBConnection;

public class CategoryDao {
	private DBConnection dbCon = null;
	private Connection con1;

	public CategoryDao() {
		dbCon = DBConnection.createInstance();
	}

	public void fetchConn() throws InterruptedException {
		con1 = dbCon.getConnection();
	}

	public void getCategorys() {
		Statement stm = null;
		try {
			stm = con1.createStatement();
			String query = "select * from categries";
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				System.out.print(res.getInt("id") + "\t" + res.getString("name"));
				System.out.println("--------------------------------");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				stm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Category getCategoryDetailsById(int id) {
		Category emp = null;
		Statement stm = null;
		try {
			stm = con1.createStatement();
			ResultSet res = stm.executeQuery("select * from categries where id=" + id);
			while (res.next()) {
				emp = new Category(res.getInt("id"), res.getString("name"));
				System.out.println("--------------------------------");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				stm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	public Category insertCategory(Category emp) {
		PreparedStatement pStm = null;
		try {
			String sqll = "insert into categries values (" + emp.getId() + "," + emp.getName() + ")";
			pStm = con1.prepareStatement(sqll);
			System.out.println(pStm.executeUpdate(sqll));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pStm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return emp;
	}
}
