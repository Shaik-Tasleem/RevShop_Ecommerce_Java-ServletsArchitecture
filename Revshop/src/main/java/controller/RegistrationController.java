package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BuyerService;
import service.SellerService;

import java.io.IOException;

import entity.BuyerDetails;
import entity.SellerDetails;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String mobilenumber =request.getParameter("mobilenumber");
	        String role = request.getParameter("role");

	   
	        if (role.equals("buyer")) {
	        	try {
	        		
	                long number = Long.parseLong(mobilenumber);
	                String buyerAddress = request.getParameter("buyeraddress");
	             
	               
	                BuyerDetails buyer=new BuyerDetails(username,number,email,password,buyerAddress);
	                BuyerService service=new BuyerService();
	                service.registerBuyer(buyer);
                 response.sendRedirect("login.jsp");
                 
	                
	                
	            } catch (NumberFormatException e) {
	               
	                System.out.println("Invalid mobile number format.");
	               
//	                response.sendRedirect("registration.jsp?error=InvalidMobileNumber");
	                return;
	            }

	        } else if (role.equals("seller")) {
	            String businessName = request.getParameter("businessname");
	            
	          
	            SellerDetails seller=new SellerDetails(username,email,password,mobilenumber,businessName);
	            SellerService service=new SellerService();
	            service.sellerRegistration(seller);
	            response.sendRedirect("login.jsp");
	        }
         
		doGet(request, response);
		doGet(request, response);
	}

}
