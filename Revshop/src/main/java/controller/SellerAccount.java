package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.SellerService;

import java.io.IOException;

import dto.SellerDto;

/**
 * Servlet implementation class SellerAccount
 */
@WebServlet("/SellerProfile")
public class SellerAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerAccount() {
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

        // Retrieve the email from the session
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
        System.out.println(email+"sellers"+password+"passwords");

        if (email == null || password == null) {
            // Redirect to login page if email or password is null
            response.sendRedirect("login.jsp");
            return;
        }

        SellerService service = new SellerService();
        SellerDto sellerdto = service.loginSeller(email, password);
        if (sellerdto != null) {
            // Pass seller details to JSP
            request.setAttribute("SellerDetails", sellerdto);
            // Forward to the seller profile page
            request.getRequestDispatcher("SellerAccount.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Seller details could not be retrieved.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
		doGet(request, response);
	}

}
