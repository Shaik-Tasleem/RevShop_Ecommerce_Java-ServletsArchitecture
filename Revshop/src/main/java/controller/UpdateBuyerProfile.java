package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BuyerService;
import entity.BuyerDetails;

import java.io.IOException;
import java.io.PrintWriter;

import dto.BuyerDto;

/**
 * Servlet implementation class UpdateBuyerProfile
 */
@WebServlet("/updateProfile")
public class UpdateBuyerProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateBuyerProfile() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the response content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String oldemail = request.getParameter("email");
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        Long phone = Long.parseLong(number);
        String newemail = request.getParameter("new_email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");

        // Update BuyerDetails
        BuyerDetails buyer = new BuyerDetails(name, phone, newemail, password, address);
        BuyerService service = new BuyerService();
        boolean updated = service.updateProfile(buyer, oldemail);
       
        // HTML response for success or failure
        out.println("<html>");
        out.println("<head><title>Profile Update Status</title></head>");
        out.println("<body>");
        out.println("<div style='text-align:center; margin-top:50px;'>");

        if (updated) {
            out.println("<h1 style='color:green;'>Profile updated successfully!</h1>");
        } else {
            out.println("<h1 style='color:red;'>Failed to update profile.</h1>");
        }

        out.println("<a href='login.jsp'>Go back to Profile</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
