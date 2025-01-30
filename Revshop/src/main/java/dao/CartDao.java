package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import dto.ProductDto;
import entity.Cart;
import exception.ProductsAreUnavailable;
import util.DatabaseConnection;

public class CartDao {
	private Connection connection;
    static Scanner sc=new Scanner(System.in);
	public CartDao() {
		
		connection=DatabaseConnection.getInstance().getConnection(); 
		
	}
	public void addtoCart(Cart cart) {
		String insert="insert into cart(buyer_id,product_id,quantity) values(?,?,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(insert);
			ps.setInt(1,cart.getBuyer_id());
			ps.setInt(2,cart.getProduct_id());
			ps.setInt(3,cart.getQuantity());
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				System.out.println("Product added to cart successfully!");
			}
			else
			{
				System.out.println("Product not added");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public List<ProductDto> getProductsFromCart(int buyerid) throws ProductsAreUnavailable {
		List<ProductDto> list=new ArrayList<>();
		String query="select p.* from cart c join product_details p on c.product_id=p.product_id where buyer_id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, buyerid);
			ResultSet rs=ps.executeQuery();
			
				while (rs.next()) {
	            	int productid=rs.getInt("product_id");
	                String productName = rs.getString("product_name");
	                double productPrice = rs.getDouble("product_price");
	                String productImage = rs.getString("product_image");
	                String productDescription = rs.getString("product_description");
	                int threshold = rs.getInt("threshold");
	                int quantity = rs.getInt("quantity");
	                double discountPrice = rs.getDouble("discount_price");
	                int categoryIdFromDb = rs.getInt("category_id");
	                ProductDto product = new ProductDto(productid,productName, productPrice, productImage, 
	                        productDescription, threshold, quantity, 
	                        discountPrice, categoryIdFromDb);
	               list.add(product);
			} 
	            if(list==null)
	            {
	            	throw new ProductsAreUnavailable();
	            }
	            }
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		
		// TODO Auto-generated method stub
		
	}
	public boolean checkCart(int buyerid, int pid) {
		int q=1;
		String query="update cart set quantity=quantity+? where buyer_id=? and product_id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, q);
			ps.setInt(2, buyerid);
			ps.setInt(3, pid);
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return false;
	}
	public void removeFromCart(int id) {
		String query="delete from cart where product_id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				System.out.println("removed successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void updatequantity(int pid, int bid, int quantity) {
		// TODO Auto-generated method stub
		
		String query="update cart set quantity=? where buyer_id=? and product_id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, quantity);
			ps.setInt(2, bid);
			ps.setInt(3, pid);
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				System.out.println("updated");
			}
			
		} catch (SQLException e) {
			System.out.println("not updated");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public double getTotalPrice(int buyerId) {
	    String query="select sum(p.product_price*c.quantity) as total from product_details p Join cart c where c.buyer_id=?";
	    try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, buyerId);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next())
			 {
				 return rs.getDouble("total");
			 }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		return 0;
		
	}

	
}
