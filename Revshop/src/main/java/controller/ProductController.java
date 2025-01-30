package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ProductService;

import java.io.IOException;

import entity.ProductDetails;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
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
		try {
			String pname=request.getParameter("productname");
			String price=request.getParameter("price");
			String image=request.getParameter("image");
			String description=request.getParameter("description");
			String threshold = request.getParameter("threshold");
	        String quantity = request.getParameter("quantity");
	        String discountPrice = request.getParameter("discount_price");
	        String categoryId = request.getParameter("category_id");

	        
	        HttpSession session = request.getSession();
	        Integer sellerId = (Integer) session.getAttribute("sellerId");

	        if (sellerId == null || sellerId == 0) {
	            response.getWriter().println("Invalid login. Please log in as a seller.");
	            return;
	        }

	        
	        ProductDetails product = new ProductDetails();
	        product.setProduct_name(pname);
	        product.setProduct_price(Double.parseDouble(price));
	        product.setProduct_image(image);
	        product.setProduct_description(description);
	        product.setThreshold(Integer.parseInt(threshold));
	        product.setQuantity(Integer.parseInt(quantity));
	        product.setDiscount_price(Double.parseDouble(discountPrice));
	        product.setCategory_id(Integer.parseInt(categoryId));
	        product.setSeller_id(sellerId);  
	         System.out.println(sellerId);
	     
	        ProductService pservice = new ProductService();
	        if(pservice.addProduct(product))
	        {
            request.setAttribute("message", "Product Added Successfully!");
	        request.getRequestDispatcher("addproduct.jsp").forward(request, response);
	        }
	        else
	        {
	        	request.setAttribute("message", "Product not added Successfully!");
		        request.getRequestDispatcher("addproduct.jsp").forward(request, response);
	        	
	        }
	        response.getWriter().println("Product added successfully by seller with ID: " + sellerId);

	    } catch (NumberFormatException e) {
	        response.getWriter().println("Error: Please ensure all numeric fields are entered correctly.");
	    } catch (Exception e) {
	        response.getWriter().println("Error adding product: " + e.getMessage());
	    }
			
			doGet(request, response);
		
	}

}
