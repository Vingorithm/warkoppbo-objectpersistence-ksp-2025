/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

public class TransactionDetail {
    private Integer transactionDetailId;
    private Integer transactionId;
    private Integer productId;
    private Integer quantityPurchased;
    private BigDecimal subTotal;

    public TransactionDetail() {
    }
    
    public TransactionDetail(Integer transactionDetailId, Integer transactionId, Integer productId, 
                              Integer quantityPurchased, BigDecimal subTotal) {
        this.transactionDetailId = transactionDetailId;
        this.transactionId = transactionId;
        this.productId = productId;
        this.quantityPurchased = quantityPurchased;
        this.subTotal = subTotal;
    }

    // Getter dan Setter untuk transactionDetailId
    public Integer getTransactionDetailId() {
        return transactionDetailId;
    }

    public void setTransactionDetailId(Integer transactionDetailId) {
        this.transactionDetailId = transactionDetailId;
    }

    // Getter dan Setter untuk transactionId
    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    // Getter dan Setter untuk productId
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    // Getter dan Setter untuk quantityPurchased
    public Integer getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(Integer quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    // Getter dan Setter untuk subTotal
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
}

