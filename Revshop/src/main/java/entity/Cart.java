package entity;

public class Cart {
	private int buyer_id;
	private int product_id;
	private int quantity;
	
	public Cart(int buyer_id, int product_id, int quantity) {
		super();
		this.buyer_id = buyer_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}
	public int getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [buyer_id=" + buyer_id + ", product_id=" + product_id + ", quantity=" + quantity + "]";
	}
	

}
