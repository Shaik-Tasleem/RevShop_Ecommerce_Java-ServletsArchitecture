package service;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import dao.OrderDao;
import entity.Orders;

public class OrderService {
	private OrderDao dao;
	public OrderService()
	{
		dao=new OrderDao();
	}
    public boolean addOrder(Orders order)
    {
    	return dao.addOrder(order);
    
    }
}
