package entity;

public class SellerDetails {
	
	private String seller_name;
	private String seller_email;
	private String seller_password;
	private String seller_phonenumber;
	private String seller_business_name;
	public SellerDetails()
	{
		
	}
	public SellerDetails(String seller_name, String seller_email, String seller_password,
			String seller_phonenumber, String seller_business_name) {
		super();
		
		this.seller_name = seller_name;
		this.seller_email = seller_email;
		this.seller_password = seller_password;
		this.seller_phonenumber = seller_phonenumber;
		this.seller_business_name = seller_business_name;
	}
	
	
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public String getSeller_email() {
		return seller_email;
	}
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	public String getSeller_password() {
		return seller_password;
	}
	public void setSeller_password(String seller_password) {
		this.seller_password = seller_password;
	}
	public String getSeller_phonenumber() {
		return seller_phonenumber;
	}
	public void setSeller_phonenumber(String seller_phonenumber) {
		this.seller_phonenumber = seller_phonenumber;
	}
	public String getSeller_business_name() {
		return seller_business_name;
	}
	public void setSeller_business_name(String seller_business_name) {
		this.seller_business_name = seller_business_name;
	}
	@Override
	public String toString() {
		return "SellerDetails [seller_name=" + seller_name + ", seller_email=" + seller_email + ", seller_password="
				+ seller_password + ", seller_phonenumber=" + seller_phonenumber + ", seller_business_name="
				+ seller_business_name + "]";
	}
	
	

}
