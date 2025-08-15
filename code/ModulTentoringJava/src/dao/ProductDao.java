package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductDao {
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;

    public void create(Product product){
        con = dbCon.makeConnection();
        
        String sql = 
                "INSERT INTO `product`(`name`, `type`, `price`, `stock`) VALUES "
                + "('" + product.getName()+ "', '" + product.getType() + "', '"+ product.getPrice() + "', '" + product.getStock() +"')";
        
        System.out.println("Adding Product...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Product");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Product...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Product> read(String searchKey){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM product";
        System.out.println("Fetching Data...");
        
        List<Product> product = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    product.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getBigDecimal("price"),
                        rs.getInt("stock")));
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching Data Product...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return product;
    }
    
    public void update(int id, Product product){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `product` SET "
                + "`name`='" + product.getName() + "',"
                + "`type`='" + product.getType() + "',"
                + "`price`='" + product.getPrice() + "', "
                + "`stock`='" + product.getStock() + "' "
                + "WHERE `product_id`='" + id + "'";
        System.out.println("Updating Product...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Product " + id);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Product...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void delete(int id){
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `product` WHERE `product_id` = " + id + "";
        System.out.println("Deleting Product...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted " + result + " Product "+ id);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Deleting Product...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public Product search(String nama){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM product WHERE name='"+nama+"'";
        System.out.println("Searching product...");
        Product product = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
                while(rs.next())
                    product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getBigDecimal("price"),
                        rs.getInt("stock"));
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching Data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return product;
    }
    
    public void batchUpdate(Connection connection, List<Product> products) throws SQLException {
        PreparedStatement statement = null;
        try {
            // Menyiapkan query SQL untuk melakukan batch update
            statement = connection.prepareStatement(
                    "UPDATE product SET name = ?, type = ?, price = ?, stock = ? WHERE product_id = ?"
            );

            // Iterasi untuk setiap produk dalam daftar
            for (Product product : products) {
                // Mengisi parameter pada query
                statement.setString(1, product.getName());  // Mengisi nama produk
                statement.setString(2, product.getType());  // Mengisi tipe produk
                statement.setBigDecimal(3, product.getPrice());  // Mengisi harga produk
                statement.setInt(4, product.getStock());  // Mengisi stok produk
                statement.setInt(5, product.getId());  // Mengisi ID produk

                // Menambahkan ke batch
                statement.addBatch();
            }

            // Menjalankan semua perintah dalam batch
            statement.executeBatch();
        } finally {
            // Menutup statement untuk menghindari kebocoran sumber daya
            if (statement != null) {
                statement.close();
            }
        }
    }
}
