package net.javaguides.usermanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.usermanagement.model.Product;
import net.javaguides.usermanagement.utl.HibernateUtil;
import net.javaguides.usermanagement.web.ProductServlet;

/**
 * CRUD database operations
 * @author Ramesh Fadatare
 *
 */
public class ProductDao {
	ProductServlet temp = new ProductServlet();
	
	/**
	 * Save User
	 * @param user
	 */
	public void saveUser(Product user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(user);
			// commit transaction
			transaction.commit();
			temp.duplSet("");
		} catch (Exception e) {
			 System.out.println("userDao");
			
			 temp.duplSet("!!! This product already exists !!!");
			  
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update User
	 * @param user
	 */
	public void updateUser(Product user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			 System.out.println("userDao2");
			 
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete User
	 * @param id
	 */
	public void deleteUser(int barcode) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Product user = session.get(Product.class, barcode);
			if (user != null) {
				session.delete(user);
				System.out.println("user is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			 System.out.println("userDao3");

			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get User By ID
	 * @param id
	 * @return
	 */
	public Product getUser(int barcode) {

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
			 System.out.println("userDao4");

			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * Get all Users
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getAllUser() {

		Transaction transaction = null;
		List<Product> listOfUser = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			System.out.println("transaction ok");
			listOfUser = session.createQuery("from User").getResultList();
			System.out.println("listOfUsers ok");
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			 System.out.println("userDao5");

			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfUser;
	}
}
