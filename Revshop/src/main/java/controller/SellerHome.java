package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ProductService;
import service.SellerService;

import java.io.IOException;
import java.util.List;

import dto.ProductDto;
import exception.ProductsAreUnavailable;

/**
 * Servlet implementation class SellerHome
 */
@WebServlet("/sellerhome")
public class SellerHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerHome() {
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
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		String password=(String)session.getAttribute("password");
		SellerService service=new SellerService();
		int sellerId = service.getSellerid(email, password);
        request.getSession().setAttribute("sellerId", sellerId);

        ProductService pservice = new ProductService();
        try {
            System.out.println(sellerId + " sellers");
            List<ProductDto> products = pservice.getProductDetails(sellerId);
            System.out.println(products);
            request.setAttribute("SellerProducts", products);
            request.getRequestDispatcher("selleprofile.jsp").forward(request, response);
        } catch (ProductsAreUnavailable e) {
            request.setAttribute("errorMessage", "Unable to retrieve products. Please try again later.");
            request.getRequestDispatcher("selleprofile.jsp").forward(request, response);
            e.printStackTrace();
        }

		
		doGet(request, response);
	}

}
