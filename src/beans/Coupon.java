package beans;

import java.sql.Date;

public class Coupon {
	int id;
	int companyId;
	int categoryId;
	String title;
	String description;
	int amount;
	Date startDate;
	Date endDate;
	double price;
	String image;

	public Coupon(int id, int companyId, int categoryId, String title, String description, int amount, Date startDate,
			Date endDate, double price, String image) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.categoryId = categoryId;
		this.title = title;
		this.description = description;
		this.amount = amount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.image = image;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", companyId=" + companyId + ", categoryId=" + categoryId + ", title=" + title
				+ ", description=" + description + ", amount=" + amount + ", startDate=" + startDate + ", endDate="
				+ endDate + ", price=" + price + ", image=" + image + "]";
	}

}
