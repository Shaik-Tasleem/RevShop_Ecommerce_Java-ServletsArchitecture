package entity;

public class Orders {
private int buyerid;
private String address;
private String status;
private double totalprice;
public Orders() {
	super();
}
public Orders(int buyerid, String address, String status, double totalprice) {
	super();
	this.buyerid = buyerid;
	this.address = address;
	this.status = status;
	this.totalprice = totalprice;
}
public int getBuyerid() {
	return buyerid;
}
public void setBuyerid(int buyerid) {
	this.buyerid = buyerid;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public double getTotalprice() {
	return totalprice;
}
public void setTotalprice(double totalprice) {
	this.totalprice = totalprice;
}
@Override
public String toString() {
	return "Order [buyerid=" + buyerid + ", address=" + address + ", status=" + status + ", totalprice=" + totalprice
			+ "]";
}



}
