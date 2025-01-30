package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CartService;
import service.WishListService;

import java.io.IOException;
import java.util.List;

import dto.ProductDto;
import exception.ProductsAreUnavailable;

/**
 * Servlet implementation class RemoveFromWIsh
 */
@WebServlet("/removewish")
public class RemoveFromWIsh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromWIsh() {
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
		WishListService c=new WishListService();
		c.removeProduct(pid);
		HttpSession session = request.getSession();
		
		Integer id = (Integer) session.getAttribute("buyerid");
        int buyerid=id;
        WishListService service=new WishListService();
	      
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
//	response.sendRedirect("Mycart.jsp");
	doGet(request, response);
	}
  
}
