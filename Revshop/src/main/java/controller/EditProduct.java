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
import entity.ProductDetails;
import exception.ProductsAreUnavailable;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/editProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
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
		int productId = Integer.parseInt(request.getParameter("productId"));

        ProductService productService = new ProductService();
        List<ProductDto> product;
		try {
			product = productService.getProductDetailsbyId(productId);
			 request.setAttribute("product", product);
			 request.setAttribute("product_id", productId);
		        request.getRequestDispatcher("/editProduct.jsp").forward(request, response);
		} catch (ProductsAreUnavailable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       
		doGet(request, response);
	}

}
