package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Image;

public class ImageDAO {

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("derby");

	static {
		initImgs();
	}

	private static void initImgs() {
		Image img1 = new Image("1", "gif", "1");
		addImage(img1);
		Image img2 = new Image("2", "png", "2");
		addImage(img2);
		Image img3 = new Image("3", "jpg", "3");
		addImage(img3);
		Image img4 = new Image("4", "jpg", "4");
		addImage(img4);
	}

	public static Image getImage(String id) {
		return getEntityManager().find(Image.class, id);
	}

	public static Image addImage(Image img) {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			getEntityManager().persist(img);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx!= null)
				if (tx.isActive())
					getEntityManager().getTransaction().rollback();
		}
		return getImage(img.getImgID());
	}

	public static Image updateImage(Image img) {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			getEntityManager().merge(img);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx!= null)
				if (tx.isActive())
					getEntityManager().getTransaction().rollback();
		}
		return getImage(img.getImgID());
	}

	public static void deleteImage(String id) {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			Image img = getEntityManager().find(Image.class, id);
			getEntityManager().remove(img);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx!= null)
				if (tx.isActive())
					getEntityManager().getTransaction().rollback();
		}
	}

	public static List<Image> getAllImages() {
		return getEntityManager().createQuery("FROM " + Image.class.getName()).getResultList();
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	List<Image> list;

}
