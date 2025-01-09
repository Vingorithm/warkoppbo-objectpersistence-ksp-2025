/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import connection.DbConnection;
import dao.ProductDao;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.PurchaseItemDto;
import dao.TransactionDao;
import dao.TransactionDetailDao;
import model.Product;
import model.Transaction;
import model.TransactionDetail;

/**
 *
 * @author Kevin Philips Tanamas
 */

public class TransactionService {
    private final TransactionDao transactionDao = new TransactionDao();
    private final TransactionDetailDao transactionDetailDao = new TransactionDetailDao();
    private final ProductDao productDao = new ProductDao();

    // Method untuk memproses pembelian produk
    public String productPurchase(List<PurchaseItemDto> purchasedItems) {
        try {
            // Membuat ID transaksi unik dan timestamp transaksi
            UUID transactionId = UUID.randomUUID();
            Timestamp transactionDatetime = new Timestamp(System.currentTimeMillis());
            
            // Membuat koneksi ke database dan menonaktifkan auto-commit
            DbConnection dbConnection = new DbConnection();
            dbConnection.makeConnection();
            DbConnection.CON.setAutoCommit(false);

            // Menghitung total transaksi
            BigDecimal total = countTotalTransaction(purchasedItems);
            System.out.println("Total Transaksi: " + total);

            // Membuat objek transaksi baru
            Transaction transaction = new Transaction();
            transaction.setTransactionId(transactionId.toString());
            transaction.setTransactionDate(transactionDatetime);
            transaction.setTotal(total);
            transaction.setBuyer("buyer-dummy");
            transaction.setCashier("cashier-dummy");
            
            // Menyimpan transaksi ke dalam database
            transactionDao.create(DbConnection.CON, transaction);

            // Menyimpan detail transaksi dan produk yang dibeli
            List<TransactionDetail> transactionDetails = new ArrayList<>();
            List<Product> products = new ArrayList<>();
            purchasedItems.forEach(item -> {
                // Membuat ID untuk detail transaksi dan mengisi informasi detail transaksi
                UUID transactionDetailId = UUID.randomUUID();
                TransactionDetail transactionDetail = new TransactionDetail();
                transactionDetail.setProductId(item.getProduct().getId());
                transactionDetail.setQuantityPurchased(item.getQuantityPurchased());
                transactionDetail.setSubTotal(countSubTotalTransaction(item));
                transactionDetail.setTransactionId(transactionId.toString());
                transactionDetail.setTransactionDetailId(transactionDetailId.toString());
                transactionDetails.add(transactionDetail);

                // Memperbarui stok produk
                Product product = item.getProduct();
                product.setStock(product.getStock() - item.getQuantityPurchased());
                products.add(product);
            });

            // Menyimpan detail transaksi dan memperbarui stok produk
            transactionDetailDao.batchCreate(DbConnection.CON, transactionDetails);
            productDao.batchUpdate(DbConnection.CON, products);

            // Melakukan commit transaksi
            DbConnection.CON.commit();
            DbConnection.CON.close();
            
            // Mengembalikan total transaksi sebagai string
            return String.valueOf(total);
        } catch (SQLException ex) {
            ex.printStackTrace(); // Menampilkan trace pengecualian untuk debugging
            try {
                if (DbConnection.CON != null) {
                    DbConnection.CON.rollback(); // Membatalkan transaksi jika terjadi error
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Menampilkan trace pengecualian jika rollback gagal
            }
            return null; // Mengembalikan null jika terjadi error
        }
    }

    // Method untuk menghitung total transaksi
    public BigDecimal countTotalTransaction(List<PurchaseItemDto> purchasedItems) {
        purchasedItems.forEach(System.out::println);
        return purchasedItems.stream()
                .map(this::countSubTotalTransaction) // Menghitung subtotal untuk setiap item
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Menjumlahkan seluruh subtotal
    }

    // Method untuk menghitung subtotal untuk tiap item
    public BigDecimal countSubTotalTransaction(PurchaseItemDto purchasedItem) {
        BigDecimal price = purchasedItem.getProduct().getPrice(); // Harga produk
        BigDecimal quantity = new BigDecimal(purchasedItem.getQuantityPurchased()); // Jumlah produk yang dibeli
        return price.multiply(quantity); // Menghitung subtotal
    }
}

