package dto;

public class ProductDto {
	private int product_id;
    private String productName;
    private double productPrice;
    private String productImage;
    private String productDescription;
    private int threshold;
    private int quantity;
    private double discountPrice;
    private int categoryId;

    // Constructor
    

	public ProductDto(int product_id, String productName, double productPrice, String productImage,
			String productDescription, int threshold, int quantity, double discountPrice, int categoryId) {
		super();
		this.product_id = product_id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productDescription = productDescription;
		this.threshold = threshold;
		this.quantity = quantity;
		this.discountPrice = discountPrice;
		this.categoryId = categoryId;
	}
	

	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductImage() {
		return productImage;
	}


	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
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


	public double getDiscountPrice() {
		return discountPrice;
	}


	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	@Override
	public String toString() {
		return "ProductDto [product_id=" + product_id + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productImage=" + productImage + ", productDescription=" + productDescription
				+ ", threshold=" + threshold + ", quantity=" + quantity + ", discountPrice=" + discountPrice
				+ ", categoryId=" + categoryId + "]";
	}



	
}
