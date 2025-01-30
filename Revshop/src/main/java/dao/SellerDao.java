package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.SellerOrders;
import dto.SellerOrdersDetails;
import entity.BuyerDetails;
import entity.SellerDetails;
import exception.UserNotFoundException;
import util.DatabaseConnection;

public class SellerDao {
    private Connection connection;

    public SellerDao() {
        connection = DatabaseConnection.getInstance().getConnection(); 
    }

    public void addSeller(SellerDetails seller) {
        String query = "INSERT INTO SellerDetails (seller_name, seller_email, seller_password, seller_phonenumber, seller_business_name) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, seller.getSeller_name());
            ps.setString(2, seller.getSeller_email());
            ps.setString(3, seller.getSeller_password());
            ps.setString(4, seller.getSeller_phonenumber());
            ps.setString(5, seller.getSeller_business_name());
            int rows = ps.executeUpdate();
            if (rows >= 1) {
                System.out.println("Seller Registered Successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getSellerid(String email, String password) {
        String query = "SELECT seller_id FROM SellerDetails WHERE seller_email = ? AND seller_password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

	public SellerDetails getSellerinfoByemail(String email) {
		String query = "SELECT seller_name, seller_email, seller_password, seller_phonenumber, seller_business_name FROM SellerDetails WHERE seller_email=?";

		SellerDetails seller=null;
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				
				seller=new SellerDetails();
			    seller.setSeller_name(rs.getString(1));
			    seller.setSeller_email(rs.getString(2));
			    seller.setSeller_password(rs.getString(3));
			    seller.setSeller_phonenumber(rs.getString(4));
			    seller.setSeller_business_name(rs.getString(5));
			    
			}
			else
			{
				throw new UserNotFoundException();
			}
		}
		catch(UserNotFoundException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return seller;
	}
	public boolean updateProfile(SellerDetails seller,String email)
	{
		String query="update sellerdetails set seller_name=?,seller_email=?,seller_password=?,seller_phonenumber=?,seller_business_name=? where seller_email=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, seller.getSeller_name());
			ps.setString(2,seller.getSeller_email());
			ps.setString(3, seller.getSeller_password());
			ps.setString(4, seller.getSeller_phonenumber());
			ps.setString(5, seller.getSeller_business_name());
			ps.setString(6, email);
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

	public List<SellerOrdersDetails> getAllmyorders(int sellerid) {
		// TODO Auto-generated method stub
		 String query = "SELECT o.order_id, o.buyer_id, o.shipping_address, o.status, "
		            + "o.total_amount, o.order_date, c.cart_id, c.product_id, "
		            + "c.quantity AS cart_quantity, c.dateadded, p.product_name, "
		            + "p.product_price, p.product_image, p.product_description "
		            + "FROM orders o "
		            + "JOIN cart c ON o.buyer_id = c.buyer_id "
		            + "JOIN product_details p ON c.product_id = p.product_id "
		            + "WHERE p.seller_id = ?";
		    
		    List<SellerOrdersDetails> list = new ArrayList();
		    
		    try {
		        // Prepare the statement
		        PreparedStatement ps = connection.prepareStatement(query);
		        ps.setInt(1, sellerid);
		        
		        // Execute the query
		        ResultSet rs = ps.executeQuery();
		        
		        // Process the result set
		        while (rs.next()) {
		        	int orderId = rs.getInt("order_id");                 // Order ID
		            int buyerId = rs.getInt("buyer_id");                 // Buyer ID
		            String shippingAddress = rs.getString("shipping_address");  // Shipping Address
		            String status = rs.getString("status");              // Status
		            double totalAmount = rs.getDouble("total_amount");   // Total Amount
		            Date orderDate = rs.getDate("order_date");           // Order Date
		            
		            int cartId = rs.getInt("cart_id");                   // Cart ID
		            int productId = rs.getInt("product_id");             // Product ID
		            int cartQuantity = rs.getInt("cart_quantity");       // Cart Quantity
		            Date dateAdded = rs.getDate("dateadded");            // Date Added
		            
		            String productName = rs.getString("product_name");   // Product Name
		            double productPrice = rs.getDouble("product_price"); // Product Price
		            String productImage = rs.getString("product_image"); // Product Image
		            String productDescription = rs.getString("product_description"); // Product Description

		           SellerOrdersDetails seller=new SellerOrdersDetails(orderId, buyerId, shippingAddress, status, totalAmount, orderDate, cartId, productId, cartQuantity, dateAdded, productName, productPrice, productImage, productDescription);
		           list.add(seller);
		            
		        }	        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		    return list;
		
	}

	


}
