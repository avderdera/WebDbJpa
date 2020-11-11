package net.javaguides.productmanagement.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.productmanagement.utl.HibernateUtil;
import net.javaguides.productmanagement.web.ProductServlet;
import net.javaguides.productmanagement.model.Product;

/**
 * CRUD database operations
 * @author Nterntera Antel-Vissarion
 *
 */
public class ProductDao {
	ProductServlet temp = new ProductServlet();
	
	/**
	 * Save Product
	 * @param product
	 */
	public void saveProduct(Product product) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(product);
			// commit transaction
			transaction.commit();
			temp.duplSet("");
			temp.dublSet(false);
		} catch (Exception e) {
			 System.out.println("productDao");
			
			 temp.duplSet("!!! This product already exists !!!");
			 temp.dublSet(true);
			  
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update Product
	 * @param product
	 */
	public void updateProduct(Product product) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(product);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			 System.out.println("productDao2");
			 
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get Product By barcode
	 * @param barcode
	 * @return
	 */
	public Product getProduct(int barcode) {

		Transaction transaction = null;
		Product user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = session.get(Product.class, barcode);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			 System.out.println("productDao3");

			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}

}
