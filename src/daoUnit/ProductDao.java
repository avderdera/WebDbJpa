package daoUnit;

import org.hibernate.Session;
import org.hibernate.Transaction;

import archetype.Product;
import hibernateUnit.HibernateUtil;
import webServlet.ProductServlet;

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
			// save the product object
			session.save(product);
			// commit transaction
			transaction.commit();
			// erase the duplicate notification
			temp.duplSet("");
			// turn off the notification
			temp.dublSet(false);
		} catch (Exception e) {
			
			 // set notification message
			 temp.duplSet("!!! This product already exists !!!");
			 // turn on notification message
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
			// save the product object
			session.update(product);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			 
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
			// get an product object
			user = session.get(Product.class, barcode);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}

}
