/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import model.Transaction;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Kevin Philips Tanamas
 */
public class TransactionDao {
    // SQL query untuk menyisipkan data transaksi
    private static final String INSERT_TRANSACTION_ALL = "INSERT INTO transaction (id, date, total, cashier, buyer) values (?, ?, ?, ?, ?)";

    // Method untuk membuat transaksi baru
    public void create(Connection connection, Transaction transaction) throws SQLException {
        PreparedStatement statement = null;
        try {
            // Menyiapkan statement untuk eksekusi query INSERT
            statement = connection.prepareStatement(INSERT_TRANSACTION_ALL);
            
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
}

