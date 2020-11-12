package webServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import archetype.Product;
import daoUnit.ProductDao;


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Nterntera Antel-Vissarion
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

			throw new ServletException(ex);
		}
	}

	private void showProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Product product = productDao.getProduct(currBarcode);
		// set to appear the message of existing  duplicate if thats the case
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
		//store the barcode locally to use it id the barcode doesen't already exits
		currBarcode = barcode;
		// fill with null to check first if the barcode exists
		String name = null;
		String color = null;
		String description = null;
		Product newProduct = new Product(barcode, name, color, description);
		productDao.saveProduct(newProduct);
		// if dubl is true(barcode already exist) skip the productForm else continue normally
		if(dubl) {
			dubl = false;
			response.sendRedirect("list");
		}else {
		response.sendRedirect("productForm.jsp");
		}
	}
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		// use the barcode that you just checked and isn't already on the database
		// to fill the rest of the attributes
		int barcode = currBarcode;
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String description = request.getParameter("description");
		Product product = new Product(barcode, name, color, description);
		productDao.updateProduct(product);
		response.sendRedirect("list");
	}

	// functions to access local static variables
	public void duplSet(String input) {
		Dupl = input;
	}
	public void dublSet(boolean temp) {
		dubl = temp;
	}


}
