/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import model.Transaction;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.Product;

/**
 *
 * @author Kevin Philips Tanamas
 */
public class TransactionDao {
    // Method untuk membuat transaksi baru
    public void batchCreate(Connection connection, Transaction transaction) throws SQLException {
        PreparedStatement statement = null;
        try {
            // Menyiapkan statement untuk eksekusi query INSERT
            String sql = "INSERT INTO transaction (id, date, total, cashier, buyer) values (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            
            // Menyusun parameter yang akan disisipkan ke dalam query
            statement.setString(1, transaction.getTransactionId()); // Mengatur ID transaksi
            statement.setTimestamp(2, transaction.getTransactionDate()); // Mengatur tanggal transaksi
            statement.setBigDecimal(3, transaction.getTotal()); // Mengatur total transaksi
            statement.setString(4, transaction.getCashier()); // Mengatur nama kasir
            statement.setString(5, transaction.getBuyer()); // Mengatur nama pembeli
            
            // Menjalankan query INSERT untuk menyimpan data transaksi
            statement.executeUpdate();
        } finally {
            // Menutup statement setelah eksekusi
            if (statement != null) {
                statement.close();
            }
        }
    }
    
    public void create(Connection connection, Transaction transaction) throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String sql = "INSERT INTO transaction (id, date, total, cashier, buyer) VALUES (" +
                    "'" + transaction.getTransactionId() + "', " +
                    "'" + transaction.getTransactionDate() + "', " +
                    transaction.getTotal() + ", " +
                    "'" + transaction.getCashier() + "', " +
                    "'" + transaction.getBuyer() + "')";

            statement.executeUpdate(sql);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}

