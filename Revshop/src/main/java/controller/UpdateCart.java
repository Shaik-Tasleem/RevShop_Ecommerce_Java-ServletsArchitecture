package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CartService;

import java.io.IOException;

/**
 * Servlet implementation class UpdateCart
 */
@WebServlet("/updateCart")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCart() {
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
	    int pid=Integer.parseInt(request.getParameter("productId"));
	    int bid=Integer.parseInt(request.getParameter("buyerId"));
	    int quantity=Integer.parseInt(request.getParameter("quantity"));
	    CartService service=new CartService();
//	    service.updateCartquantity(pid,bid);
	    service.updateCart(pid, bid,quantity);
	    response.setContentType("text/plain");
        response.getWriter().write("Cart updated successfully");
//	    request.getRequestDispatcher("/updateCart").forward(request, response);
//		doGet(request, response);
	}

}