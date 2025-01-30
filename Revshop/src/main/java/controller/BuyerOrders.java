package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.BuyerService;
import dto.OrderDetails;

import java.io.IOException;
import java.util.List;

@WebServlet("/myorders")
public class BuyerOrders extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BuyerOrders() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session=request.getSession();
        int buyerid =  (int) session.getAttribute("buyerid"); 
        

        
        BuyerService service = new BuyerService();
        List<OrderDetails> orderDetails = service.getOrderDetails(buyerid);

        
        request.setAttribute("orderDetails", orderDetails);

        
        request.getRequestDispatcher("/myorders.jsp").forward(request, response);
    	
        doGet(request, response);
    }
}
