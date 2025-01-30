package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BuyerService;
import service.ProductService;
import service.SellerService;

import java.io.IOException;
import java.util.List;

import dto.BuyerDto;
import dto.ProductDto;
import dto.SellerDto;
import exception.ProductsAreUnavailable;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		ProductService productService = new ProductService();
	      
	       List<ProductDto> products;
			try {
			     
				products = productService.getProductsByCategory();
				request.setAttribute("products", products);
		        request.getRequestDispatcher("displayProducts.jsp").forward(request, response);
			} catch (ProductsAreUnavailable e) {
				
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    String role = request.getParameter("role");

	    if (role.equals("buyer")) {
	        BuyerService service = new BuyerService();
	        BuyerDto buyerdto = service.loginBuyer(email, password);

	        if (buyerdto != null) {
	            request.getSession().setAttribute("email", buyerdto.getB_email());
	            int buyerId = service.getbuyerId(email, password);
	            request.getSession().setAttribute("buyerid", buyerId);
	            request.getSession().setAttribute("password", password);

	            System.out.println(buyerdto);
	            doGet(request, response); // Forward to product display page

	        } else {
	            // Set an error message and forward back to login page
	            request.setAttribute("errorMessage", "Incorrect email or password.");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
	    } else if (role.equals("seller")) {
	        SellerService service = new SellerService();
	        SellerDto sellerdto = service.loginSeller(email, password);

	        if (sellerdto != null) {
	            request.getSession().setAttribute("email", email);
	            request.getSession().setAttribute("password", password);
	            int sellerId = service.getSellerid(email, password);
	            request.getSession().setAttribute("sellerId", sellerId);

	            ProductService pservice = new ProductService();
	            try {
	                System.out.println(sellerId + " sellers");
	                List<ProductDto> products = pservice.getProductDetails(sellerId);
	                System.out.println(products);
	                request.setAttribute("SellerProducts", products);
	                request.getRequestDispatcher("selleprofile.jsp").forward(request, response);
	            } catch (ProductsAreUnavailable e) {
	                request.setAttribute("errorMessage", "Unable to retrieve products. Please try again later.");
	                request.getRequestDispatcher("selleprofile.jsp").forward(request, response);
	                e.printStackTrace();
	            }

	            System.out.println(sellerdto);
	        } else {
	            // Set an error message and forward back to login page
	            request.setAttribute("errorMessage", "Incorrect email or password.");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
	    } else {
	        // Handle case where the role is not recognized
	        request.setAttribute("errorMessage", "Invalid role specified.");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	}

	

}
