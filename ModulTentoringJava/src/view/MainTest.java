package view;


import controller.ProductController; 
import controller.TransactionController; 
import java.math.BigDecimal; 
import java.util.List; 
import model.Product; 
import model.PurchaseItemDto; 

public class MainTest {

    public static final ProductController productController = new ProductController(); 
    public static final TransactionController transactionController = new TransactionController(); 
    public static void main(String[] args) { 
//        testCreate(); // create data dummy 
//        testUpdate(); // update data dummy stok = 15 
//        testRead(); // read all data 
//        testDelete(); // delete all data 
        //testTransaction(); 
    }
    
    private static void testCreate(){ 
        List<Product> products = List.of(  
        new Product("Nasi Goreng Ayam", "Makanan", new 
        BigDecimal("15000") , 10),  
        new Product("Mie Ayam Bakso", "Makanan", new 
        BigDecimal("15000"), 12), 
        new Product("Es teh", "Minuman", new BigDecimal("3000"), 13), 
        new Product("Jus Jeruk", "Minuman", new BigDecimal("6000"), 
        14), 
        new Product("Nasi Ayam sambal matah", "Makanan", new 
        BigDecimal("25000"), 10), 
        new Product("Indomie Goreng + Telur", "Makanan", new 
        BigDecimal("12000"), 10) 
        );         
        products.forEach(productController::create); 
        } 
        private static void testRead(){ 
        List<Product> products = productController.read(""); 
        products.forEach(System.out::println); 
        } 
        private static void testUpdate(){ 
        List<Product> products = productController.read(""); 
        products.forEach(product->{ 
        product.setStock(15); 
        productController.update(product.getId(), product); 
        }); 
        } 
        private static void testDelete(){ 
        List<Product> products = productController.read(""); 
        products.forEach(product->{ 
        product.setStock(15); 

 productController.delete(product.getId()); 
        }); 
        } 
         
//        private static void testTransaction(){ 
//             
//            Product products = productController.read("").get(0); 
//            Product products2 = productController.read("").get(1); 
//            List<PurchaseItemDto> purchasedItems = List.of( 
//                    new PurchaseItemDto(products, 10), 
//                    new PurchaseItemDto(products2, 13) 
//            ); 
//             
//            
//transactionController.doProductPurchaseTransaction(purchasedItems); 
//        } 

    
}
