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
import java.util.ArrayList;
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
                statement.setInt(1, transactionDetail.getTransactionDetailId());
                statement.setInt(2, transactionDetail.getTransactionId());
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
    
//    public void create(Connection connection, List<TransactionDetail> transactionDetails) throws SQLException {
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//
//            for (TransactionDetail detail : transactionDetails) {
//                String sql = "INSERT INTO transaction_detail " +
//                        "(detail_id, transaction_id, product_id, quantity_purchased, sub_total) VALUES (" +
//                        "'" + detail.getTransactionDetailId() + "', " +
//                        "'" + detail.getTransactionId() + "', " +
//                        detail.getProductId() + ", " +
//                        detail.getQuantityPurchased() + ", " +
//                        detail.getSubTotal() + ")";
//
//                statement.executeUpdate(sql);
//            }
//        } finally {
//            if (statement != null) {
//                statement.close();
//            }
//        }
//    }
    
    public void create(Connection connection, List<TransactionDetail> transactionDetails) throws SQLException {
        Statement statement = null;
        List<Integer> generatedIds = new ArrayList<>();
        try {
            statement = connection.createStatement();

            for (TransactionDetail transactionDetail : transactionDetails) {
                String sql = "INSERT INTO transaction_detail (transaction_id, product_id, quantity_purchased, sub_total) VALUES (" +
                             transactionDetail.getTransactionId() + ", " +
                             transactionDetail.getProductId() + ", " +
                             transactionDetail.getQuantityPurchased() + ", " +
                             transactionDetail.getSubTotal() +
                             ")";

                statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

                // Ambil id yang baru dibuat setelah tiap insert
                try (var generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedIds.add(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating transaction detail failed, no ID obtained.");
                    }
                }
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
