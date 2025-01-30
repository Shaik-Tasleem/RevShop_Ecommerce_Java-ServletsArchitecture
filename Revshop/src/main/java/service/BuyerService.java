package service;

import java.util.List;

import dao.BuyerDao;
import dto.BuyerDto;
import dto.OrderDetails;
import entity.BuyerDetails;
import entity.SellerDetails;

public class BuyerService {
	private BuyerDao buyerdao;
	public BuyerService()
	{
		buyerdao=new BuyerDao();
	}
	
	public void registerBuyer(BuyerDetails buyer) {
		 
		buyerdao.addBuyer(buyer);
		
		System.out.println("Welcome to Revature Shop "+buyer.getBuyer_name());
	}

	public BuyerDto loginBuyer(String email, String password) {
		BuyerDetails buyer=buyerdao.getBuyerinfoByemail(email);
		
		if(buyer==null|| !buyer.getBuyer_password().equalsIgnoreCase(password))
		{
			System.out.println("email or password is incorrect!kindly give valid email or password");
			return null;
			
		}
		return new BuyerDto(buyer.getBuyer_name(),buyer.getEmail(),buyer.getBuyer_phonenumber(),buyer.getBuyer_address());
		
		
	}

	public boolean updateProfile(BuyerDetails buyer,String email) {
		return buyerdao.updatebyemail(buyer,email);
		
	}

	public void deleteAccount(long mobile_number) {
		buyerdao.deleteAccountUsingMobilenumber(mobile_number);
		
		
	}

	public int getbuyerId(String email,String password) {
		
		
		
			return buyerdao.getidbyemail(email,password);
		
		
	}

	public List<OrderDetails> getOrderDetails(int buyerId) {
		
		return buyerdao.getMyOrder(buyerId);
	}

	
	

}
