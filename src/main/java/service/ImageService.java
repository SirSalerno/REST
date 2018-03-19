package service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ImageDAO;
import model.Image;

@Path("images")
public class ImageService {

	// URI:
	// /contextPath/servletPath/images
	@GET
	@Produces({MediaType.APPLICATION_XML })
	public List<Image> getImages_XML() {
		List<Image> listOfImages = ImageDAO.getInstance().findAll();
		return listOfImages;
	}

	// URI:
	// /contextPath/servletPath/images/{id}
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML })
	public Image getImage(@PathParam("id") String id) {
		return ImageDAO.getInstance().getById(id);
	}

	// URI:
	// /contextPath/servletPath/images
	@POST
	@Produces({MediaType.APPLICATION_XML })
	public Image addImage(Image img) {
		return ImageDAO.getInstance().persist(img);
	}

	// URI:
	// /contextPath/servletPath/images
	@PUT
	@Produces({MediaType.APPLICATION_XML })
	public Image updateImage(Image img) {
		return ImageDAO.getInstance().merge(img);
	}

	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML })
	public void deleteImage(@PathParam("id") String id) {
		ImageDAO.getInstance().removeById(id);;
	}

}