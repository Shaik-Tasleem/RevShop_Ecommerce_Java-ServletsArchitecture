package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ProductService;

import java.io.IOException;
import java.util.List;

import dto.ProductDto;
import exception.ProductsAreUnavailable;

/**
 * Servlet implementation class RemoveProduct
 */
@WebServlet("/RemoveProduct")
public class RemoveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveProduct() {
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
		String productid=request.getParameter("productId");
		int pid=Integer.parseInt(productid);
		ProductService service=new ProductService();
		service.removeProduct(pid);
		HttpSession session=request.getSession();
		int sid=(int) session.getAttribute("sellerId");
		ProductService pservice=new ProductService();
		try {
		List<ProductDto> products=pservice.getProductDetails(sid);
		System.out.println(products);
		request.setAttribute("SellerProducts", products);
		request.getRequestDispatcher("selleprofile.jsp").forward(request, response);
		}
		catch(ProductsAreUnavailable e){
			request.getRequestDispatcher("selleprofile.jsp").forward(request, response);
			e.printStackTrace();
			
		}
//		response.sendRedirect("selleprofile.jsp");
	}

}
