package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CartService;
import service.ProductService;

import java.io.IOException;
import java.util.List;

import dto.ProductDto;
import entity.Cart;
import exception.ProductsAreUnavailable;

/**
 * Servlet implementation class RemoveCartItems
 */
@WebServlet("/removecart")
public class RemoveCartItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCartItems() {
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
		String id1=request.getParameter("productId");
		int pid=Integer.parseInt(id1);
		CartService c=new CartService();
		c.removeProduct(pid);
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("buyerid");
        int buyerid=id;
        
        
        CartService cservice=new CartService();
	      
	       List<ProductDto> products;
			try {
			     
				products =cservice.getAllproducts(buyerid);
				request.setAttribute("cartitems", products);
				
		        request.getRequestDispatcher("Mycart.jsp").forward(request, response);
		        
			} catch (ProductsAreUnavailable e) {
				
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}

}
