package dto;

public class SellerDto {
	private String s_name;
	private String s_email;
	private String s_number;
	private String s_address;
	public SellerDto() {
		super();
	}
	public SellerDto(String s_name, String s_email, String s_number, String s_address) {
		super();
		this.s_name = s_name;
		this.s_email = s_email;
		this.s_number = s_number;
		this.s_address = s_address;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public String getS_number() {
		return s_number;
	}
	public void setS_number(String s_number) {
		this.s_number = s_number;
	}
	public String getS_address() {
		return s_address;
	}
	public void setS_address(String s_address) {
		this.s_address = s_address;
	}
	@Override
	public String toString() {
		return "SellerDto [s_name=" + s_name + ", s_email=" + s_email + ", s_number=" + s_number + ", s_address="
				+ s_address + "]";
	}
	

}
