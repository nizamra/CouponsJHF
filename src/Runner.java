
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;

import beans.Category;
import beans.Company;
import beans.Coupon;
import beans.Customer;
import dao.CategoryDao;
import dao.CompanyDao;
import dao.CouponDao;
import dao.CustomerDao;

public class Runner {
	public static void main(String[] args){

//		CheckDelete checker = new CheckDelete();
//		checker.start();
//
//		CompanyDao compD = new CompanyDao();
//		compD.insertCompany(new Company(110, "PaloAlto", "paloalto@paloaltomail.com", "Pal3st5!ne"));
//		compD.insertCompany(new Company(111, "Microsoft", "microsoft@microsoftmail.com", "M!croS0ft5"));
//		compD.insertCompany(new Company(112, "Cisco", "Cisco@Ciscomail.com", "Cis!Co44comp"));
//		compD.insertCompany(new Company(113, "Hewlett-Packard", "Hewlett@Packardmail.com", "HowT5o0Do0"));
//		compD.insertCompany(new Company(114, "Appel", "apple@applemail.com", "Apll3s&O0rang3s"));
//		compD.getCompanys();
//		compD.updateCompanysNameById(114, "Apple");
//		System.out.println(compD.getCompanyDetailsById(114));
//		compD.getCompanys();
//
//		CustomerDao custD = new CustomerDao();
//		custD.insertCustomer(new Customer(110, "Hossam", "Jallad", "hjallad@gmail.com", "hossamjallad"));
//		custD.insertCustomer(new Customer(111, "Ahmad", "Natsheh", "hjanatshehallad@gmail.com", "ahmadnatsheh"));
//		custD.insertCustomer(new Customer(112, "Salam", "Tahboub", "stahboub@gmail.com", "salamtahboub"));
//		custD.insertCustomer(new Customer(113, "Yasmeen", "Samaheen", "ysamaheen@gmail.com", "yasmeensamaheen"));
//		custD.insertCustomer(new Customer(114, "Hala", "Majali", "hmajaki@gmail.com", "halamajali"));
//		custD.getCustomers();
//		custD.updateCustomersNameById(114, "Amal");
//		System.out.println(custD.getCustomerDetailsById(114));
//		custD.getCustomers();
//
//		CategoryDao catD = new CategoryDao();
//		catD.insertCategory(new Category(1, "Air Travel"));
//		catD.insertCategory(new Category(2, "Restaurants"));
//		catD.insertCategory(new Category(3, "Grocery"));
//		catD.insertCategory(new Category(4, "Hotels"));
//		catD.getCategorys();
//
//		String pattern = "yyyy-MM-dd";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date dateStart = Date.valueOf(LocalDate.of(2022, 1, 1));
		Date dateEnd = Date.valueOf(LocalDate.of(2022, 12, 1));
		CouponDao copD = null;
		try {
			copD = new CouponDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
		copD.insertCoupon(new Coupon(110, 112, 4, "AlKarmel Hotel", "Two nights at the hotel Presidential suite", 750,
				dateStart , dateEnd, 649.99, "image1"));
//		copD.insertCoupon(new Coupon(111, 112, 2, "Abu Shanab", "A family dinner at Abu Shanab restaurant", 750,
//				dateStart, dateEnd, 349.99, "image35"));
//		copD.insertCoupon(new Coupon(112, 112, 3, "Marmash Grocery", "A coupon for one time only", 750, dateStart,
//				dateEnd, 200.00, "image23"));
		copD.getCouponDetailsById(110);
	}
}
