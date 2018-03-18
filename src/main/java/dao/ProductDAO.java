package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import model.Product;
 
public class ProductDAO {
 
    private static final Map<String, Product> prodMap = new HashMap<String, Product>();
 
    static {
        initEmps();
    }
 
    private static void initEmps() {
    	Product emp1 = new Product("1", "Product1", "sample product",null);
    	Product emp2 = new Product("2", "Product2", "sample sub-product","1");
    	Product emp3 = new Product("3", "Product3", "sample product",null);
 
        prodMap.put(emp1.getProdID(), emp1);
        prodMap.put(emp2.getProdID(), emp2);
        prodMap.put(emp3.getProdID(), emp3);
    }
 
    public static Product getProduct(String id) {
        return prodMap.get(id);
    }
 
    public static Product addProduct(Product prod) {
        prodMap.put(prod.getProdID(), prod);
        return prod;
    }
 
    public static Product updateProduct(Product prod) {
        prodMap.put(prod.getProdID(), prod);
        return prod;
    }
 
    public static void deleteProduct(String id) {
        prodMap.remove(id);
    }
 
    public static List<Product> getAllProducts() {
        Collection<Product> c = prodMap.values();
        List<Product> list = new ArrayList<Product>();
        list.addAll(c);
        return list;
    }
     
    List<Product> list;
 
}
