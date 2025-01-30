package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.SellerService;
import dto.SellerDto;

import java.io.IOException;

/**
 * Servlet implementation class SellerProfile
 */
@WebServlet("/sellerprofile")
public class SellerProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SellerProfile() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Retrieve the email from the session
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");

        if (email == null || password == null) {
            // Redirect to login page if email or password is null
            response.sendRedirect("login.jsp");
            return;
        }

        SellerService service = new SellerService();
        SellerDto sellerdto = service.loginSeller(email, password);
        
        if (sellerdto != null) {
            request.setAttribute("SellerDetails", sellerdto);
            response.sendRedirect("selleprofile.jsp");
        } else {
            request.setAttribute("errorMessage", "Seller details could not be retrieved.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
