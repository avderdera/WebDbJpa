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
	private ProductDao userDao;
	private static int currBarcode = 0;
	private static String Dupl;
	
	public void init() {
		userDao = new ProductDao();
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
				insertUser(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			 System.out.println("userHI");

			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Product product = userDao.getUser(currBarcode);
		System.out.println(Dupl);
		request.setAttribute("Error", Dupl);
		request.setAttribute("Product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("productAtr.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("productForm.jsp");
		dispatcher.forward(request, response);
	}


	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int barcode = Integer.parseInt(request.getParameter("barcode"));
		currBarcode = barcode;
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String description = request.getParameter("description");
		Product newUser = new Product(barcode, name, color, description);
		userDao.saveUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int barcode = Integer.parseInt(request.getParameter("barcode"));
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String description = request.getParameter("description");
		Product user = new Product(barcode, name, color, description);
		userDao.updateUser(user);
		response.sendRedirect("list");
	}
	public void duplSet(String input) {
		Dupl = input;
	}


}
