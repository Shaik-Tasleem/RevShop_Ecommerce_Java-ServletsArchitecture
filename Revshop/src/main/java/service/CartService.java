package service;

import java.util.List;

import dao.CartDao;
import dto.ProductDto;
import entity.Cart;
import exception.ProductsAreUnavailable;

public class CartService {
	private CartDao cdao;
	
	public CartService() {
		
		cdao = new CartDao();
	}
	
	public void addProduct(Cart cart) {
		cdao.addtoCart(cart);
		
	}
	public List<ProductDto> getAllproducts(int buyerid) throws ProductsAreUnavailable
	{
		return cdao.getProductsFromCart(buyerid);
	}

	public boolean alreadyAddedToCart(int buyerid, int pid) {
		
		return cdao.checkCart(buyerid,pid);
	}

	public void removeProduct(int id) {
		cdao.removeFromCart(id);
		
	}
	public void updateCart(int pid,int bid,int quantity)
	{
		cdao.updatequantity(pid,bid,quantity);
	}

	public double getTotalPrice(int buyerId) {
		return cdao.getTotalPrice(buyerId);
		
	}

	
	
	

}
