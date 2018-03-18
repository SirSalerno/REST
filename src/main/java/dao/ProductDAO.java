package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Product;

public class ProductDAO {

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("derby");

	static {
		initEmps();
	}

	private static void initEmps() {
		Product emp1 = new Product("1", "Product1", "sample product", null);
		addProduct(emp1);
		Product emp2 = new Product("2", "Product2", "sample sub-product", "1");
		addProduct(emp2);
		Product emp3 = new Product("3", "Product3", "sample product", null);
		addProduct(emp3);

	}

	public static Product getProduct(String id) {
		return getEntityManager().find(Product.class, id);
	}

	public static Product addProduct(Product prod) {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(prod);
			getEntityManager().getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}
		return getProduct(prod.getProdID());
	}

	public static Product updateProduct(Product prod) {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(prod);
			getEntityManager().getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}
		return getProduct(prod.getProdID());
	}

	public static void deleteProduct(String id) {
		try {
			getEntityManager().getTransaction().begin();
			Product prod = getEntityManager().find(Product.class, id);
			getEntityManager().remove(prod);
			getEntityManager().getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			getEntityManager().getTransaction().rollback();
		}
	}

	public static List<Product> getAllProducts() {
		return getEntityManager().createQuery("FROM " + Product.class.getName()).getResultList();
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	List<Product> list;

}
