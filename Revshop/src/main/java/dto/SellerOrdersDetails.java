package dto;

import java.util.Date;

public class SellerOrdersDetails {
    
    // Order details
    private int orderId;
    private int buyerId;
    private String shippingAddress;
    private String status;
    private double totalAmount;
    private Date orderDate;

    // Cart details
    private int cartId;
    private int productId;
    private int cartQuantity;
    private Date dateAdded;

    // Product details
    private String productName;
    private double productPrice;
    private String productImage;
    private String productDescription;

    // Constructors
    public SellerOrdersDetails() {}

    public SellerOrdersDetails(int orderId, int buyerId, String shippingAddress, String status, 
                        double totalAmount, Date orderDate, int cartId, int productId, 
                        int cartQuantity, Date dateAdded, String productName, 
                        double productPrice, String productImage, String productDescription) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.shippingAddress = shippingAddress;
        this.status = status;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.cartId = cartId;
        this.productId = productId;
        this.cartQuantity = cartQuantity;
        this.dateAdded = dateAdded;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescription = productDescription;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
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

    // Optional toString() for debugging or logging purposes
    @Override
    public String toString() {
        return "SellerOrders{" +
                "orderId=" + orderId +
                ", buyerId=" + buyerId +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                ", orderDate=" + orderDate +
                ", cartId=" + cartId +
                ", productId=" + productId +
                ", cartQuantity=" + cartQuantity +
                ", dateAdded=" + dateAdded +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productImage='" + productImage + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
