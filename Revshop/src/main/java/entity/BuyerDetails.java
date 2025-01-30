package entity;

public class BuyerDetails {
//	private int buyer_id ;
	private String buyer_name;
	private long buyer_phonenumber ;
	private String email;
	private String buyer_password;
	private String buyer_address;
	public BuyerDetails()
	{
//		System.out.println("default constructor");
	}
	public BuyerDetails(String buyer_name, long buyer_phonenumber, String email, String buyer_password,
			String buyer_address) {
		super();
//		this.buyer_id = buyer_id;
		this.buyer_name = buyer_name;
		this.buyer_phonenumber = buyer_phonenumber;
		this.email = email;
		this.buyer_password = buyer_password;
		this.buyer_address = buyer_address;
	}
//	public int getBuyer_id() {
//		return buyer_id;
//	}
//	public void setBuyer_id(int buyer_id) {
//		this.buyer_id = buyer_id;
//	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public long getBuyer_phonenumber() {
		return buyer_phonenumber;
	}
	public void setBuyer_phonenumber(long buyer_phonenumber) {
		this.buyer_phonenumber = buyer_phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBuyer_password() {
		return buyer_password;
	}
	public void setBuyer_password(String buyer_password) {
		this.buyer_password = buyer_password;
	}
	public String getBuyer_address() {
		return buyer_address;
	}
	public void setBuyer_address(String buyer_address) {
		this.buyer_address = buyer_address;
	}
	@Override
	public String toString() {
		return "BuyerDetails [buyer_name=" + buyer_name + ", buyer_phonenumber=" + buyer_phonenumber + ", email="
				+ email + ", buyer_password=" + buyer_password + ", buyer_address=" + buyer_address + "]";
	}
	
	
}
