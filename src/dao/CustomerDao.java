package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import beans.Customer;
import utils.DBConnection;

public class CustomerDao {
	private DBConnection dbCon = null;
	private Connection con1;

	public CustomerDao() {
		dbCon = DBConnection.createInstance();
	}

	public void fetchConn() throws InterruptedException {
		con1 = dbCon.getConnection();
	}

	public void getCustomers() {
		Statement stm = null;
		try {
			stm = con1.createStatement();
			String query = "select * from customers";
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				System.out.print(res.getInt("id") + "\t" + res.getString("fName") + "\t" + res.getString("lName") + "\t"
						+ res.getString("email"));
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

	public Customer getCustomerDetailsById(int id) {
		Customer emp = null;
		Statement stm = null;
		try {
			stm = con1.createStatement();
			ResultSet res = stm.executeQuery("select * from customers where id=" + id);
			while (res.next()) {
				emp = new Customer(res.getInt("id"), res.getString("fName"), res.getString("lName"),
						res.getString("email"));
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

	public void updateCustomersNameById(Integer id, String newName) {
		Statement stm = null;
		try {
			stm = con1.createStatement();
			String query = "UPDATE customers SET name=" + newName + "WHERE id=" + id + ";";
			stm.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				stm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Customer insertCustomer(Customer emp) {
		PreparedStatement pStm = null;
		try {
			String sqll = "insert into customers values (" + emp.getId() + "," + emp.getfName() + "," + emp.getlName()
					+ "," + emp.getEmail() + "," + emp.getPassword()+")";
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
