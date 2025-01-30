package dto;

import java.time.LocalDate;

public class OrderDetails {
	private String product_name;
	private double product_price;
	private String product_image;
	private String product_description;
	private double totalamount;
	private LocalDate orderdate;
	private int quantity;
	private String address;
	public OrderDetails() {
		super();
	}
	public OrderDetails(String product_name, double product_price, String product_image, String product_description,
			double totalamount, LocalDate orderdate, int quantity, String address) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_image = product_image;
		this.product_description = product_description;
		this.totalamount = totalamount;
		this.orderdate = orderdate;
		this.quantity = quantity;
		this.address = address;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	public LocalDate getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrderDetails [product_name=" + product_name + ", product_price=" + product_price + ", product_image="
				+ product_image + ", product_description=" + product_description + ", totalamount=" + totalamount
				+ ", orderdate=" + orderdate + ", quantity=" + quantity + ", address=" + address + "]";
	}
	
	

	 

}
