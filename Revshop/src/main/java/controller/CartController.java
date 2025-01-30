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
 * Servlet implementation class CartController
 */
@WebServlet("/addcart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
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
		// TODO Auto-generated method stub
		CartService service=new CartService();
		String productid=request.getParameter("productid");
		int pid=Integer.parseInt(productid);
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("buyerid");
        int buyerid=id;
        int quantity=1;
        
        if(!service.alreadyAddedToCart(buyerid,pid))
        {
        	Cart cart=new Cart(buyerid,pid,quantity);
			request.setAttribute("quantity",cart.getQuantity()) ;
            request.setAttribute("buyerId",buyerid);
            service.addProduct(cart);
            
            
        }
        else
        {
        	request.setAttribute("quantity", 1);
        	System.out.println("already exists");
        }
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
//		response.sendRedirect("Mycart.jsp");
		doGet(request, response);
	}

}