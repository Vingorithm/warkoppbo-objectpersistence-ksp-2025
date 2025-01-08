/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaction {
    private String transactionId; // ID unik transaksi
    private Timestamp transactionDate; // Tanggal dan waktu transaksi
    private BigDecimal total; // Total nilai transaksi
    private String cashier; // Nama kasir yang menangani transaksi
    private String buyer; // Nama pembeli

    // Constructor default
    public Transaction() {
    }

    // Constructor dengan parameter
    public Transaction(String transactionId, Timestamp transactionDate, BigDecimal total) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.total = total;
        this.cashier = "cashier-dummy"; // Nilai default untuk kasir
        this.buyer = "buyer-dummy"; // Nilai default untuk pembeli
    }

    // Getter dan Setter untuk transactionId
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    // Getter dan Setter untuk transactionDate
    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    // Getter dan Setter untuk total
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    // Getter dan Setter untuk cashier
    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    // Getter dan Setter untuk buyer
    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
}
