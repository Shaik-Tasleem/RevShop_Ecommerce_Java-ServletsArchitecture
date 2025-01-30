package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.SellerService;

import java.io.IOException;

import entity.SellerDetails;

/**
 * Servlet implementation class UpdateSellerProfile
 */
@WebServlet("/UpdateSellerProfile")
public class UpdateSellerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSellerProfile() {
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
	    String old_email = (String) session.getAttribute("email");
	    
	    String name = request.getParameter("s_name");
	    String number = request.getParameter("s_number");
	    String newemail = request.getParameter("s_email");
	    String password = request.getParameter("s_password");
	    String address = request.getParameter("s_address");

	    SellerDetails seller = new SellerDetails(name, newemail, password, number, address);
	    SellerService service = new SellerService();

	    if (service.upDateProfile(seller, old_email)) {
	        // Set success message
	        request.setAttribute("message", "Profile updated successfully");
	    } else {
	        // Set failure message
	        request.setAttribute("message", "Profile update failed");
	    }

	    // Forward back to the JSP
	    request.getRequestDispatcher("/SellerAccount.jsp").forward(request, response);
	}

}
