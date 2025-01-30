package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.SellerService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import dto.SellerOrdersDetails;

/**
 * Servlet implementation class SellerOrders
 */
@WebServlet("/sellerorders")
public class SellerOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @param productDescription 
     * @param productImage 
     * @param productPrice 
     * @param productName 
     * @param dateAdded 
     * @param cartQuantity 
     * @param productId 
     * @param cartId 
     * @param orderDate 
     * @param totalAmount 
     * @param status 
     * @param shippingAddress 
     * @param buyerId 
     * @param orderId 
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
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
        int sellerid =  (int) session.getAttribute("sellerId"); // Assumes buyerid is passed as a request parameter
        SellerService service=new SellerService();
        
        List<SellerOrdersDetails> orders=service.getMyOrders(sellerid);
        request.setAttribute("orders", orders);

        // Forward the request to the JSP page for displaying the orders
         request.getRequestDispatcher("sellerOrders.jsp").forward(request, response);
		doGet(request, response);
	}

}
