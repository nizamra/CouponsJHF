package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Coupon;
import utils.DBConnection;

public class CouponDao {
	private DBConnection dbCon = null;
	private Connection con1;

	public CouponDao() throws InterruptedException {
		dbCon = DBConnection.createInstance();
		con1 = dbCon.getConnection();
	}

	public void getCoupons() {
		Statement stm = null;
		try {
			stm = con1.createStatement();
			String query = "select * from coupons";
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				System.out.print(res.getInt("id") + "\t" + res.getInt("companyId") + "\t" + res.getInt("categoryId")
						+ "\t" + res.getString("title") + "\t" + res.getString("description") + "\t"
						+ res.getInt("amount") + "\t" + res.getDate("startDate") + "\t" + res.getDate("endDate") + "\t"
						+ res.getDouble("price") + "\t" + res.getString("image"));
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

	public Coupon getCouponDetailsById(int id) {
		Coupon emp = null;
		PreparedStatement stm = null;
		try {
			stm = con1.prepareStatement("select * from coupons where id=" + id);
			ResultSet res = stm.executeQuery("select * from coupons where id=" + id);
			while (res.next()) {
				emp = new Coupon(res.getInt("id"), res.getInt("companyId"), res.getInt("categoryId"),
						res.getString("title"), res.getString("description"), res.getInt("amount"),
						res.getDate("startDate"), res.getDate("endDate"), res.getDouble("price"),
						res.getString("image"));
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

	public Coupon insertCoupon(Coupon emp) {
		PreparedStatement pStm = null;
		try {
			String sqll = "insert into coupons values (" + emp.getId() + "," + emp.getCompanyId() + ","
					+ emp.getCategoryId() + "," + emp.getTitle() + "," + emp.getDescription() + "," + emp.getAmount()
					+ "," + emp.getStartDate() + "," + emp.getEndDate() + "," + emp.getPrice() + "," + emp.getImage()
					+ ")";
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
