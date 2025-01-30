package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.OrderDetails;
import entity.BuyerDetails;
import exception.UserNotFoundException;
import util.DatabaseConnection;

public class BuyerDao {
    private Connection connection;
    static Scanner sc=new Scanner(System.in);
	public BuyerDao() {
		
		connection=DatabaseConnection.getInstance().getConnection(); 
		
	}
    public void addBuyer(BuyerDetails buyer)
    {
    	String query="insert into BuyerDetails(buyer_name, buyer_phonenumber, buyer_email, buyer_password, buyer_address) values (?,?,?,?,?)";
    	try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, buyer.getBuyer_name());
			ps.setLong(2, buyer.getBuyer_phonenumber());
			ps.setString(3, buyer.getEmail());
			ps.setString(4, buyer.getBuyer_password());
			ps.setString(5, buyer.getBuyer_address());
			int rows=ps.executeUpdate();
			System.out.println(rows);
			if(rows>=1)
			{
				System.out.println("data inserted Successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
	public BuyerDetails getBuyerinfoByemail(String email)  {
		String query = "SELECT buyer_name, buyer_phonenumber, buyer_email, buyer_password, buyer_address FROM BuyerDetails WHERE buyer_email=?";

		BuyerDetails buyer=null;
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				
				buyer=new BuyerDetails();
				System.out.println(rs.getString("buyer_name"));
				buyer.setBuyer_name(rs.getString("buyer_name"));
				buyer.setEmail(rs.getString("buyer_email"));
				buyer.setBuyer_phonenumber(rs.getLong("buyer_phonenumber"));
				buyer.setBuyer_address(rs.getString("buyer_address"));
				buyer.setBuyer_password(rs.getString("buyer_password"));
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
			e.printStackTrace();
		}
		return buyer;
		
		
	}
	public boolean updatebyemail(BuyerDetails buyer,String email) {
	    String query = "UPDATE buyerDetails SET buyer_name = ?, buyer_phonenumber = ?, buyer_email = ?, buyer_password = ?, buyer_address = ? WHERE buyer_email = ?";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(query);
	        
	     
	        stmt.setString(1, buyer.getBuyer_name());
	        
	        
	        stmt.setLong(2, buyer.getBuyer_phonenumber());

	        
	        
	        stmt.setString(3, buyer.getEmail());
	        
	        
	       
	        stmt.setString(4, buyer.getBuyer_password());
	          
	        
	       
	        stmt.setString(5, buyer.getBuyer_address());
	        
	        stmt.setString(6, email);

	        
	        
	        int rows = stmt.executeUpdate();
	       

	        if (rows >= 1) {
	        	
	            System.out.println("Profile Updated Successfully!");
	            return true;
	        } return false;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	public void deleteAccountUsingMobilenumber(long mobile_number) {
		String query="delete from BuyerDetails where Buyer_Phonenumber=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setLong(1, mobile_number);
			int rows=ps.executeUpdate();
			if(rows>=1)
			{
				System.out.println("Account deleted Successfully!");
			}
			
		} catch (SQLException e) {
			System.out.println("Enter Valid Mobile Number");
		}
		
	}
	public int getidbyemail(String email,String password) {
		String query="select buyer_id from BuyerDetails where buyer_email=? and buyer_password=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
	
		    ResultSet rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	System.out.println(rs.getInt(1));
		    	return rs.getInt(1);
		    }
		    return 0;
		    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	public List<OrderDetails> getMyOrder(int buyerId) {
		List<OrderDetails> list=new ArrayList();
		String query="SELECT o.shipping_address,o.total_amount AS order_total_amount, c.dateadded, c.quantity AS order_quantity,p.product_name,p.product_price, p.product_image, p.product_description FROM Orders o JOIN  Cart c ON o.buyer_id = c.buyer_id JOIN Product_details p ON c.product_id = p.product_id WHERE  o.buyer_id = ?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, buyerId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String productName = rs.getString("product_name");
                double productPrice = rs.getDouble("product_price");
                String productImage = rs.getString("product_image");
                String productDescription = rs.getString("product_description");
                double totalAmount = rs.getDouble("order_total_amount");
                LocalDate orderDate = rs.getDate("dateadded").toLocalDate();
                int quantity = rs.getInt("order_quantity");
                String address = rs.getString("shipping_address");
                OrderDetails orderDetails = new OrderDetails(productName, productPrice, productImage, productDescription,
                        totalAmount, orderDate, quantity, address);
                list.add(orderDetails);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return list;
	}

}
