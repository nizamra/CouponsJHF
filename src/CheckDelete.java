import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import utils.DBConnection;

public class CheckDelete extends Thread {
	private DBConnection dbCon = null;
	private Connection con1;

	public CheckDelete() {
		dbCon = DBConnection.createInstance();
	}

	public void fetchConn() throws InterruptedException {
		con1 = dbCon.getConnection();
	}

	@Override
	public void run() {
		Timer timer = new Timer();
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String todayDate = f.format(today);
		TimerTask task = new TimerTask() {
			public void run() {
				PreparedStatement pStm = null;
				try {
					String sqll = "DELETE FROM coupons WHERE endDate<"+ todayDate;
					pStm = con1.prepareStatement(sqll);
					System.out.println(pStm.executeQuery(sqll));
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
				
				System.out.println("Deleter task Done! :)");
			}
		};
		
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 2022);
		date.set(Calendar.MONTH, Calendar.JANUARY);
		date.set(Calendar.DAY_OF_MONTH, 25);
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		
		timer.scheduleAtFixedRate(task, date.getTime(), 1000);
//		timer.cancel();
	}
}
