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
    public List<Product> getProducts_JSON() {
        List<Product> listOfProducts = ProductDAO.getAllProducts();
        return listOfProducts;
    }
 
    // URI:
    // /contextPath/servletPath/products/{id}
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML })
    public Product getProduct(@PathParam("id") String id) {
        return ProductDAO.getProduct(id);
    }
 
    // URI:
    // /contextPath/servletPath/products
    @POST
    @Produces({MediaType.APPLICATION_XML })
    public Product addProduct(Product prod) {
        return ProductDAO.addProduct(prod);
    }
 
    // URI:
    // /contextPath/servletPath/products
    @PUT
    @Produces({MediaType.APPLICATION_XML })
    public Product updateProduct(Product prod) {
        return ProductDAO.updateProduct(prod);
    }
 
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML })
    public void deleteProduct(@PathParam("id") String id) {
    	ProductDAO.deleteProduct(id);
    }
 
}