package dto;

public class BuyerDto {
	private String b_name;
	private String b_email;
	private long b_number;
	private String b_address;
	public BuyerDto() {
		super();
	}
	public BuyerDto(String b_name, String b_email, long b_number, String b_address) {
		super();
		this.b_name = b_name;
		this.b_email = b_email;
		this.b_number = b_number;
		this.b_address = b_address;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String b_email) {
		this.b_email = b_email;
	}
	public long getB_number() {
		return b_number;
	}
	public void setB_number(long b_number) {
		this.b_number = b_number;
	}
	public String getB_address() {
		return b_address;
	}
	public void setB_address(String b_address) {
		this.b_address = b_address;
	}
	@Override
	public String toString() {
		return "BuyerDto [b_name=" + b_name + ", b_email=" + b_email + ", b_number=" + b_number + ", b_address="
				+ b_address + "]";
	}
	

}
