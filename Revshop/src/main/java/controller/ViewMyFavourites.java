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
import entity.WishListDetails;
import exception.ProductsAreUnavailable;

/**
 * Servlet implementation class ViewMyFavourites
 */
@WebServlet("/mywishlist")
public class ViewMyFavourites extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMyFavourites() {
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
//		String productid=request.getParameter("productid");
//		int pid=Integer.parseInt(productid);
//		HttpSession session = request.getSession();
//		Integer id = (Integer) session.getAttribute("buyerid");
//		 int buyerid=id;
		 WishListService service=new WishListService();
		
		 List<ProductDto> products;
			try {
			     
				products =service.getAllproducts(buyerId);
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
		doGet(request, response);// TODO Auto-generated method stub
		
	}

}
