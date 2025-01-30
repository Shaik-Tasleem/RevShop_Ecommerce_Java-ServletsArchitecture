package entity;

public class WishListDetails {
	private int buyerid;
	private int productid;
	public WishListDetails(int buyerid, int productid) {
		super();
		this.buyerid = buyerid;
		this.productid = productid;
	}
	public WishListDetails() {
		super();
	}
	public int getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	

}
