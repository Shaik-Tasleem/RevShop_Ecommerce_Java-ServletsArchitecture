package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CartService;

import java.io.IOException;
import java.util.List;

import dto.ProductDto;
import entity.Cart;
import exception.ProductsAreUnavailable;

/**
 * Servlet implementation class ViewMyProducts
 */
@WebServlet("/myitems")
 public class ViewMyProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMyProducts() {
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
		HttpSession session=request.getSession();
		Integer buyerId=(Integer) session.getAttribute("buyerid");
		System.out.println(buyerId+"my cart buyerid");
		if(buyerId==null)
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		Cart cart=(Cart) session.getAttribute("cart");
		CartService cservice=new CartService();
	      
	       List<ProductDto> products;
			try {
			     
				products =cservice.getAllproducts(buyerId);
				request.setAttribute("cartitems", products);
				
		        request.getRequestDispatcher("Mycart.jsp").forward(request, response);
		        
			} catch (ProductsAreUnavailable e) {
				
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		doGet(request, response);
	}

}
