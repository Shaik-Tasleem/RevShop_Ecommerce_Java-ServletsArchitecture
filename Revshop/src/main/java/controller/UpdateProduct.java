package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductService;

import java.io.IOException;

import entity.ProductDetails;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
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
	    int productId = Integer.parseInt(request.getParameter("productId"));
	    
	    String productName = request.getParameter("productName");
      double productPrice = Double.parseDouble(request.getParameter("productPrice"));
     
      int quantity = Integer.parseInt(request.getParameter("quantity"));
      String productDescription = request.getParameter("productDescription");
      double discountPrice = Double.parseDouble(request.getParameter("discountPrice"));
      int threshold = Integer.parseInt(request.getParameter("threshold"));
      int categoryId = Integer.parseInt(request.getParameter("categoryId"));
      String image=request.getParameter("productImage");
         System.out.println(categoryId);
	    ProductDetails p = new ProductDetails();
	    p.setProduct_name(productName);
	    p.setDiscount_price(discountPrice);
	    p.setProduct_description(productDescription);
	    p.setProduct_image(image);
	    p.setProduct_price(productPrice);
	    p.setQuantity(quantity);
	    p.setCategory_id(categoryId);
	    p.setThreshold(threshold);

	    ProductService service = new ProductService();
	    if (service.updateProduct(p, productId)) {
	    	System.out.println("updated");
	        request.setAttribute("message", "Product updated successfully");
	    } else {
	    	System.out.println("not updated");
	        request.setAttribute("message", "Failed to update product");
	    }
	    
	    request.getRequestDispatcher("/editProduct.jsp").forward(request, response);
	}

	

}
