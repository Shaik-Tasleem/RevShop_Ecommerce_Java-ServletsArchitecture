package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;

import dto.ProductDto;
import entity.ProductDetails;
import exception.ProductsAreUnavailable;
import util.DatabaseConnection;

public class ProductDao {
    private Connection connection;
    static Scanner sc = new Scanner(System.in);

    public ProductDao() {
        // Establishing connection with the database
        connection = DatabaseConnection.getInstance().getConnection();
    }

    public boolean addProduct(ProductDetails product) {
        // SQL query to insert product details into the ProductDetails table
        String insertProductSQL = "INSERT INTO Product_Details (product_name, product_price, product_image, product_description, seller_id, threshold, quantity, discount_price, category_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertProductSQL)) {
            // Setting the values for the SQL query based on the ProductDetails object
            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setDouble(2, product.getProduct_price());
            preparedStatement.setString(3, product.getProduct_image());
            preparedStatement.setString(4, product.getProduct_description());
            preparedStatement.setInt(5, product.getSeller_id());
            preparedStatement.setInt(6, product.getThreshold());
            preparedStatement.setInt(7, product.getQuantity());
            preparedStatement.setDouble(8, product.getDiscount_price());
            preparedStatement.setInt(9, product.getCategory_id());

            // Executing the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Return true if the product was successfully added
            return rowsAffected > 0;
            

        } catch (SQLException e) {
            // Handling SQL exception and printing stack trace
            e.printStackTrace();
            return false;
        }
    }

    public List<ProductDto> getProductDetails(int sellerid) throws ProductsAreUnavailable {
        List<ProductDto> list = new ArrayList<>();
        String query = "SELECT product_id, product_name, product_price, product_image, product_description, threshold, quantity, discount_price, category_id " +
                       "FROM Product_Details WHERE seller_id = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, sellerid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int productid = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                double productPrice = rs.getDouble("product_price");
                String productImage = rs.getString("product_image");
                String productDescription = rs.getString("product_description");
                int threshold = rs.getInt("threshold");
                int quantity = rs.getInt("quantity");
                double discountPrice = rs.getDouble("discount_price");
                int categoryIdFromDb = rs.getInt("category_id"); // corrected column retrieval

                ProductDto product = new ProductDto(productid, productName, productPrice, productImage, 
                        productDescription, threshold, quantity, discountPrice, categoryIdFromDb);
                list.add(product);
            }
            
            if (list.isEmpty()) {
                throw new ProductsAreUnavailable();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


	public List<ProductDto> getProducts() throws ProductsAreUnavailable {
		List<ProductDto> list=new ArrayList<>();
		String query = "select * from product_details";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			
            ResultSet rs = ps.executeQuery();

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

	public List<ProductDto> getProductsByletter(String name) throws ProductsAreUnavailable {
		List<ProductDto> list=new ArrayList<>();
		String query="select * from product_details where product_name like ?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, name+"%");
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void removeProduct(int pid) {
		String query="delete from product_details where product_id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, pid);
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				System.out.println("product removed succesfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public boolean updateProduct(ProductDetails p, int productId) {
		String update="update product_details set product_name=?, product_price=?, product_image=?, product_description=?,  threshold=?, quantity=?, discount_price=?, category_id=? where product_id=?";
		try {
			PreparedStatement ps=connection.prepareStatement(update);
			ps.setString(1, p.getProduct_name());
			ps.setDouble(2, p.getProduct_price());
			ps.setString(3, p.getProduct_image());
			ps.setString(4, p.getProduct_description());
			ps.setInt(5, p.getThreshold());
			ps.setInt(6, p.getQuantity());
			ps.setDouble(7, p.getDiscount_price());
			ps.setInt(8, p.getCategory_id());
			ps.setInt(9, productId);
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
	public List<ProductDto> getProductDetailsUsingPid(int pid) throws ProductsAreUnavailable {
        List<ProductDto> list = new ArrayList<>();
        String query = "SELECT product_id, product_name, product_price, product_image, product_description, threshold, quantity, discount_price, category_id " +
                       "FROM Product_Details WHERE product_id = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int productid = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                double productPrice = rs.getDouble("product_price");
                String productImage = rs.getString("product_image");
                String productDescription = rs.getString("product_description");
                int threshold = rs.getInt("threshold");
                int quantity = rs.getInt("quantity");
                double discountPrice = rs.getDouble("discount_price");
                int categoryIdFromDb = rs.getInt("category_id"); // corrected column retrieval

                ProductDto product = new ProductDto(productid, productName, productPrice, productImage, 
                        productDescription, threshold, quantity, discountPrice, categoryIdFromDb);
                list.add(product);
            }
            
            if (list.isEmpty()) {
                throw new ProductsAreUnavailable();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
