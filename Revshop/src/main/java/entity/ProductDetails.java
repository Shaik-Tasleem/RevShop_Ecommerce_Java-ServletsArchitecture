package entity;

public class ProductDetails {
	private String product_name;
	private double product_price;
	private String product_image;
	private String product_description;
	private int seller_id;
	private int threshold;
	private int quantity;
	private double discount_price;
	private int category_id;
	
	public ProductDetails() {
		super();
	}

	public ProductDetails(String product_name, double product_price, String product_image, String product_description,
			int seller_id, int threshold, int quantity, double discount_price, int category_id) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_image = product_image;
		this.product_description = product_description;
		this.seller_id = seller_id;
		this.threshold = threshold;
		this.quantity = quantity;
		this.discount_price = discount_price;
		this.category_id = category_id;
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

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscount_price() {
		return discount_price;
	}

	public void setDiscount_price(double discount_price) {
		this.discount_price = discount_price;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "ProductDetails [product_name=" + product_name + ", product_price=" + product_price + ", product_image="
				+ product_image + ", product_description=" + product_description + ", seller_id=" + seller_id
				+ ", threshold=" + threshold + ", quantity=" + quantity + ", discount_price=" + discount_price
				+ ", category_id=" + category_id + "]";
	}
    

	

}
