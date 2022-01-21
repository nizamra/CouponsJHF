package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import beans.Company;
import utils.DBConnection;

public class CompanyDao {
	private DBConnection dbCon = null;
	private Connection con1;

	public CompanyDao() {
		dbCon = DBConnection.createInstance();
	}

	public void fetchConn() throws InterruptedException {
		con1 = dbCon.getConnection();
	}

	public void getCompanys() {
		Statement stm = null;
		try {
			stm = con1.createStatement();
			String query = "select * from companies";
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				System.out.print(res.getInt("id") + "\t" + res.getString("name") + "\t" + res.getString("email"));
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

	public Company getCompanyDetailsById(int id) {
		Company emp = null;
		Statement stm = null;
		try {
			stm = con1.createStatement();
			ResultSet res = stm.executeQuery("select * from companies where id=" + id);
			while (res.next()) {
				emp = new Company(res.getInt("id"), res.getString("name"), res.getString("email"));
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

	public void updateCompanysNameById(Integer id, String newName) {
		Statement stm = null;
		try {
			stm = con1.createStatement();
			String query = "UPDATE companies SET name=" + newName + "WHERE id=" + id + ";";
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

	public Company updateCompanysDetails() {
		PreparedStatement pStm = null;
		Company newEmp = null;
		try {
			String sqll = "Update companies set name= ?, email= ?, password = ? where id=110";
			pStm = con1.prepareStatement(sqll);

			pStm.setString(1, "Intel");
			pStm.setString(2, "intel@intelmail.com");
			pStm.setString(3, "Int3ger!s7");

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
		return newEmp;
	}

	public Company insertCompany(Company emp) {
		PreparedStatement pStm = null;
		try {
			String sqll = "insert into companies values (" + emp.getId() + "," + emp.getName() + "," + emp.getEmail() + "," + emp.getPassword()+")";
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
