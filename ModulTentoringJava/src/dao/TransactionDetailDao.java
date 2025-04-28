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
import java.sql.Statement;
/**
 *
 * @author Kevin Philips Tanamas
 */
public class TransactionDetailDao {
    
    public void batchCreate(Connection connection, List<TransactionDetail> transactionDetails) throws SQLException {
        PreparedStatement statement = null;
        try {
            String sql = "INSERT INTO transaction_detail (detail_id, transaction_id, product_id, quantity_purchased, sub_total) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);

            for (TransactionDetail transactionDetail : transactionDetails) {
                statement.setString(1, transactionDetail.getTransactionDetailId());
                statement.setString(2, transactionDetail.getTransactionId());
                statement.setInt(3, transactionDetail.getProductId());
                statement.setInt(4, transactionDetail.getQuantityPurchased());
                statement.setBigDecimal(5, transactionDetail.getSubTotal());
                statement.addBatch();
            }

            statement.executeBatch();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
    
    public void create(Connection connection, List<TransactionDetail> transactionDetails) throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            for (TransactionDetail detail : transactionDetails) {
                String sql = "INSERT INTO transaction_detail " +
                        "(detail_id, transaction_id, product_id, quantity_purchased, sub_total) VALUES (" +
                        "'" + detail.getTransactionDetailId() + "', " +
                        "'" + detail.getTransactionId() + "', " +
                        detail.getProductId() + ", " +
                        detail.getQuantityPurchased() + ", " +
                        detail.getSubTotal() + ")";

                statement.executeUpdate(sql);
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
