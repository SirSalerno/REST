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

import dao.ProductDAO;
import model.Product;

@Path("products")
public class ProductService {

	// URI:
	// /contextPath/servletPath/product
	@GET
	@Produces({MediaType.APPLICATION_XML })
	public List<Product> getProducts_XML() {
		List<Product> listOfProducts = ProductDAO.getInstance().findAll();
		return listOfProducts;
	}

	// URI:
	// /contextPath/servletPath/products/{id}
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML })
	public Product getProduct(@PathParam("id") String id) {
		return ProductDAO.getInstance().getById(id);
	}

	// URI:
	// /contextPath/servletPath/products
	@POST
	@Produces({MediaType.APPLICATION_XML })
	public Product addProduct(Product img) {
		return ProductDAO.getInstance().persist(img);
	}

	// URI:
	// /contextPath/servletPath/products
	@PUT
	@Produces({MediaType.APPLICATION_XML })
	public Product updateProduct(Product img) {
		return ProductDAO.getInstance().merge(img);
	}

	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML })
	public void deleteProduct(@PathParam("id") String id) {
		ProductDAO.getInstance().removeById(id);;
	}

}