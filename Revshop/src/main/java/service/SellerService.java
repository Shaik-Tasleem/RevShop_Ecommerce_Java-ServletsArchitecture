package service;

import java.util.List;

import controller.SellerOrders;
import dao.SellerDao;
import dto.BuyerDto;
import dto.SellerDto;
import dto.SellerOrdersDetails;
import entity.BuyerDetails;
import entity.SellerDetails;

public class SellerService {
    SellerDao sellerdao;

    public SellerService() {
        sellerdao = new SellerDao();
    }

    public void sellerRegistration(SellerDetails seller) {
        sellerdao.addSeller(seller);
        System.out.println("Welcome to Revature shop, " + seller.getSeller_name() + "!");
    }

    public int getSellerid(String email, String password) {
        return sellerdao.getSellerid(email, password);
    }

	public SellerDto loginSeller(String email, String password) {
SellerDetails seller=sellerdao.getSellerinfoByemail(email);
		
		if(seller==null|| !seller.getSeller_password().equalsIgnoreCase(password))
		{
			System.out.println("email or password is incorrect!kindly give valid email or password");
			return null;
			
			
		}
		return new SellerDto(seller.getSeller_name(),seller.getSeller_email(),seller.getSeller_phonenumber(),seller.getSeller_business_name());
		
		
	}
	public boolean upDateProfile(SellerDetails seller,String email)
	{
		return sellerdao.updateProfile(seller,email);
	}

	public List<SellerOrdersDetails> getMyOrders(int sellerid) {
		return sellerdao.getAllmyorders(sellerid);
	}
}
