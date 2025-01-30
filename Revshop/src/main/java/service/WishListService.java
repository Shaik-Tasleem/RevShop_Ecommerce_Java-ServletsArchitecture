package service;

import java.util.List;

import dao.CartDao;
import dao.WishListDao;
import dto.ProductDto;
import entity.WishListDetails;
import exception.ProductsAreUnavailable;

public class WishListService {
private WishListDao cdao;
	
	public WishListService() {
		
		cdao = new WishListDao();
	}

	public void addtoWish(WishListDetails wish) {
		
		cdao.addtowish(wish);
	}

	public boolean alreadyAddedToWish(int buyerid, int pid) {
		return cdao.checkWish(buyerid,pid);
	}

	public List<ProductDto> getAllproducts(int buyerid) throws ProductsAreUnavailable {
		
		return cdao.getProductsFromCart(buyerid);
	}

	public void removeProduct(int pid) {
		// TODO Auto-generated method stub
		cdao.removeFromWish(pid);
	}
	

}
