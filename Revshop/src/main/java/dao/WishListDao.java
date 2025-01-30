package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.ProductDto;
import entity.WishListDetails;
import exception.ProductsAreUnavailable;
import util.DatabaseConnection;

public class WishListDao {
	private Connection connection;
    static Scanner sc=new Scanner(System.in);
	public WishListDao() {
		
		connection=DatabaseConnection.getInstance().getConnection(); 
		
	}
	public void addtowish(WishListDetails wish) {
		// TODO Auto-generated method stub
		String query="insert into favorites(product_id, buyer_id) values(?,?)";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			
			ps.setInt(1,wish.getProductid());
			ps.setInt(2,wish.getBuyerid());
			
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				System.out.println("Product added to wish successfully!");
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
	public boolean checkWish(int buyerid, int pid) {
		String query="update favorites set product_id=? where buyer_id=? and product_id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, pid);
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
		return false;
		
	}
	public List<ProductDto> getProductsFromCart(int buyerid) throws ProductsAreUnavailable {
		List<ProductDto> list=new ArrayList<>();
		String query="select p.* from favorites f join product_details p on f.product_id=p.product_id where buyer_id=?";
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
	}
	public void removeFromWish(int pid) {
		// TODO Auto-generated method stub
		String query="delete from favorites where product_id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, pid);
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

}
