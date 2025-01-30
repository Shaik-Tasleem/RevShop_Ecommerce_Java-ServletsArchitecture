package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductService;

import java.io.IOException;
import java.util.List;

import dto.ProductDto;
import exception.ProductsAreUnavailable;

/**
 * Servlet implementation class ContinueShopping
 */
@WebServlet("/continueShopping")
public class ContinueShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContinueShopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService productService = new ProductService();
	      
	       List<ProductDto> products;
			try {
			     
				products = productService.getProductsByCategory();
				request.setAttribute("products", products);
		        request.getRequestDispatcher("displayProducts.jsp").forward(request, response);
			} catch (ProductsAreUnavailable e) {
				
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
