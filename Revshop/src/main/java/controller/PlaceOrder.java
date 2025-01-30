package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.OrderService;
import entity.Orders;

import java.io.IOException;

@WebServlet("/orderConfirmation")
public class PlaceOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PlaceOrder() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to JSP page
        request.getRequestDispatcher("/placeOrder.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buyerId = request.getParameter("buyerId");
        int buyerid = Integer.parseInt(buyerId);
        String shippingAddress = request.getParameter("deliveryAddress");
        String status = "Pending"; // Status is always "Pending" when the order is placed
        String totalAmountStr = request.getParameter("totalPrice");
        double totalAmount = Double.parseDouble(totalAmountStr);

        Orders order = new Orders(buyerid, shippingAddress, status, totalAmount);
        OrderService service = new OrderService();
        
        // Message to be displayed
        String message;
        if (service.addOrder(order)) {
            message = "Your order has been placed successfully!";
        } else {
            message = "Failed to place the order. Please try again.";
        }

        // Set message in request scope
        request.setAttribute("message", message);

        // Forward to JSP page with message
        request.getRequestDispatcher("/placeOrder.jsp").forward(request, response);
    }
}
