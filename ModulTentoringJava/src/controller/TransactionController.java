/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.PurchaseItemDto;
import service.TransactionService;

/**
 *
 * @author Kevin Philips Tanamas
 */
public class TransactionController {
    private final TransactionService transactionService = new TransactionService();
    private String buyer;
    
    public String create(List<PurchaseItemDto> items, String buyer){
        this.buyer = buyer;
        return transactionService.productPurchase(items, buyer);
    }
}
