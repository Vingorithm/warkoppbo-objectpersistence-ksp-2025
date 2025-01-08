/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.TransactionDetail;
/**
 *
 * @author Kevin Philips Tanamas
 */
public class TransactionDetailDao {
    // Query untuk menyisipkan data ke tabel transaction_detail
    private static final String INSERT_TRANSACTION_DETAIL = 
        "INSERT INTO transaction_detail (detail_id, transaction_id, product_id, quantity_purchased, sub_total) " +
        "VALUES (?, ?, ?, ?, ?)";

    public void batchCreate(Connection connection, List<TransactionDetail> transactionDetails) throws SQLException {
        PreparedStatement statement = null;
        try {
            // Menyiapkan statement dengan query INSERT
            statement = connection.prepareStatement(INSERT_TRANSACTION_DETAIL);

            for (TransactionDetail transactionDetail : transactionDetails) {
                // Mengisi parameter pada query
                statement.setString(1, transactionDetail.getTransactionDetailId());
                statement.setString(2, transactionDetail.getTransactionId());
                statement.setInt(3, transactionDetail.getProductId());
                statement.setInt(4, transactionDetail.getQuantityPurchased());
                statement.setBigDecimal(5, transactionDetail.getSubTotal());
                statement.addBatch();
            }

            // Menjalankan batch insert
            statement.executeBatch();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
