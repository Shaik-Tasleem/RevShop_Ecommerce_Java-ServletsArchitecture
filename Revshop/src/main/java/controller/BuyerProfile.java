package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BuyerService;

import java.io.IOException;

import dto.BuyerDto;

/**
 * Servlet implementation class BuyerProfile
 */
@WebServlet("/profile")
public class BuyerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerProfile() {
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
		HttpSession session = request.getSession();

	    // Retrieve the email and password from the request parameters
	    String email = (String) session.getAttribute("email");
	    System.out.println(email+"my email1");
	    String password = (String)session.getAttribute("password");

	    // Check if email or password is null
	    if (email == null || password == null) {
	        // Set an error message and forward back to login page
	        request.setAttribute("errorMessage", "Email or password cannot be null.");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	        return;
	    }

	    
	    BuyerService service = new BuyerService();
	    BuyerDto buyerdto = service.loginBuyer(email, password);
	    request.setAttribute("buyerDetails", buyerdto);
	    request.getRequestDispatcher("profile.jsp").forward(request,response);
	    System.out.println(buyerdto);
	    doGet(request,response);

	}

}
