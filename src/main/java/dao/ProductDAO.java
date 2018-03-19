package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Product;

public class ProductDAO {

	private static ProductDAO instance;
	protected EntityManager entityManager;

	public static ProductDAO getInstance() {
		if (instance == null) {
			instance = new ProductDAO();
		}

		return instance;
	}

	private ProductDAO() {
		entityManager = getEntityManager();
		Product emp1 = new Product("1", "Product1", "sample product", null);
		persist(emp1);
		Product emp2 = new Product("2", "Product2", "sample sub-product", "1");
		persist(emp2);
		Product emp3 = new Product("3", "Product3", "sample product", null);
		persist(emp3);
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("derby");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Product getById(String id) {
		return entityManager.find(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		return entityManager.createQuery("FROM " + Product.class.getName()).getResultList();
	}

	public Product persist(Product Product) {
		try {
			if (getById(Product.getProdID()) == null) {
				entityManager.getTransaction().begin();
				entityManager.persist(Product);
				entityManager.getTransaction().commit();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return getById(Product.getProdID());
	}

	public Product merge(Product Product) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(Product);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return getById(Product.getProdID());
	}

	public void remove(Product Product) {
		try {
			entityManager.getTransaction().begin();
			Product = entityManager.find(Product.class, Product.getProdID());
			entityManager.remove(Product);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(String id) {
		try {
			Product Product = getById(id);
			remove(Product);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}