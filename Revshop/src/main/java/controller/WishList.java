package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.WishListService;

import java.io.IOException;
import java.util.List;

import dto.ProductDto;
import entity.Cart;
import entity.WishListDetails;
import exception.ProductsAreUnavailable;

/**
 * Servlet implementation class WishList
 */
@WebServlet("/addtoWishlist")
public class WishList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @param pid 
     * @param buyerid 
     * @see HttpServlet#HttpServlet()
     */
    
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
		String productid=request.getParameter("productid");
		int pid=Integer.parseInt(productid);
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("buyerid");
		 int buyerid=id;
		 WishListService service=new WishListService();
		 if(!service.alreadyAddedToWish(buyerid,pid))
	        {
	        	WishListDetails wish=new WishListDetails(buyerid,pid);
	        	
	        	
				
	            request.setAttribute("buyerId",buyerid);
	            service.addtoWish(wish);
	        }
		 else
		 {
			 System.out.println("Already exists");
		 }
		 List<ProductDto> products;
			try {
			     
				products =service.getAllproducts(buyerid);
				request.setAttribute("wishitems", products);

				request.getRequestDispatcher("MyWishList.jsp").forward(request, response);
		        
			} catch (ProductsAreUnavailable e) {
				
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
//		response.sendRedirect("Mycart.jsp");
		doGet(request, response);
	            
	       
	}

}
