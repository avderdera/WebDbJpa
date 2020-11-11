package net.javaguides.productmanagement.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.productmanagement.dao.ProductDao;
import net.javaguides.productmanagement.model.Product;


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;
	private static int currBarcode = 0;
	private static String Dupl;
	private static boolean dubl;
	
	public void init() {
		productDao = new ProductDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertProduct(request, response);
				break;
			case "/update":
				updateProduct(request, response);
				break;
			default:
				showProduct(request, response);
				break;
			}
		} catch (SQLException ex) {
			 System.out.println("productHI");

			throw new ServletException(ex);
		}
	}

	private void showProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Product product = productDao.getProduct(currBarcode);
		System.out.println(Dupl);
		request.setAttribute("Error", Dupl);
		request.setAttribute("Product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("productAtr.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
		dispatcher.forward(request, response);
	}
	private void insertProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int barcode = Integer.parseInt(request.getParameter("barcode"));
		currBarcode = barcode;
		String name = null;
		String color = null;
		String description = null;
		Product newProduct = new Product(barcode, name, color, description);
		productDao.saveProduct(newProduct);
		if(dubl) {
			dubl = false;
			response.sendRedirect("list");
		}else {
		response.sendRedirect("productForm.jsp");
		}
		}
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		int barcode = currBarcode;
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String description = request.getParameter("description");
		Product product = new Product(barcode, name, color, description);
		productDao.updateProduct(product);
		response.sendRedirect("list");
	}


	public void duplSet(String input) {
		Dupl = input;
	}
	public void dublSet(boolean temp) {
		
		dubl = temp;
	}


}
