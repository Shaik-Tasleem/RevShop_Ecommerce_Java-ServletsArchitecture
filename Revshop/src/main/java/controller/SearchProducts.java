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
 * Servlet implementation class SearchProducts
 */
@WebServlet("/search")
public class SearchProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hii");
		String name=request.getParameter("pname");
		System.out.println(name);
		ProductService service=new ProductService();
		try {
			List<ProductDto> products=service.getProductsbyletter(name);
			request.setAttribute("products",products);
			System.out.println(products);
			request.getRequestDispatcher("displaysearchproducts.jsp").forward(request, response);
			
			
		} catch (ProductsAreUnavailable e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			 request.setAttribute("products", null);
		        request.getRequestDispatcher("displaysearchproducts.jsp").forward(request, response);
		}
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
