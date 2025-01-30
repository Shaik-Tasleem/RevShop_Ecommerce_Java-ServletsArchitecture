package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import entity.Orders;
import util.DatabaseConnection;

public class OrderDao {
	private Connection connection;
    
	public OrderDao() {
		
		connection=DatabaseConnection.getInstance().getConnection(); 
		
	}
	public boolean addOrder(Orders order) {
	    String insert="insert into orders(buyer_id, shipping_address, status, total_amount) values(?,?,?,?)";
	    try {
			PreparedStatement ps=connection.prepareStatement(insert);
			ps.setInt(1, order.getBuyerid());
			ps.setString(2, order.getAddress());
			ps.setString(3, order.getStatus());
			ps.setDouble(4, order.getTotalprice());
			int rs=ps.executeUpdate();
			if(rs>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
