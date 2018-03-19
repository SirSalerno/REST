package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Image;

public class ImageDAO {

	private static ImageDAO instance;
	protected EntityManager entityManager;

	public static ImageDAO getInstance() {
		if (instance == null) {
			instance = new ImageDAO();
		}

		return instance;
	}

	private ImageDAO() {
		entityManager = getEntityManager();
		Image img1 = new Image("1", "gif", "1");
		persist(img1);
		Image img2 = new Image("2", "png", "2");
		persist(img2);
		Image img3 = new Image("3", "jpg", "3");
		persist(img3);
		Image img4 = new Image("4", "jpg", "4");
		persist(img4);
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("derby");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Image getById(String id) {
		return entityManager.find(Image.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Image> findAll() {
		return entityManager.createQuery("FROM " + Image.class.getName()).getResultList();
	}

	public Image persist(Image Image) {
		try {
			if (getById(Image.getImgID()) == null) {
				entityManager.getTransaction().begin();
				entityManager.persist(Image);
				entityManager.getTransaction().commit();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return getById(Image.getImgID());
	}

	public Image merge(Image Image) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(Image);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return getById(Image.getImgID());
	}

	public void remove(Image Image) {
		try {
			entityManager.getTransaction().begin();
			Image = entityManager.find(Image.class, Image.getImgID());
			entityManager.remove(Image);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(String id) {
		try {
			Image Image = getById(id);
			remove(Image);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}