package controller;

import dao.ProductDao;
import java.util.List;
import model.Product;

public class ProductController {
    private final ProductDao productDao = new ProductDao();
    
    public void create(Product product){
        productDao.create(product);
    }
    
    public List<Product> read(String searchKey){
        System.out.println("Fetched products: " + productDao.toString());
        return productDao.read(searchKey);
    }
    
    public void update(int id, Product product){
        productDao.update(id, product);
    }
    
    public void delete(int id){
        productDao.delete(id);
    }
    
    public Product search(String nama){
        return productDao.search(nama);
    }
}
