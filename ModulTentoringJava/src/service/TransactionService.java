package service;

import connection.DbConnection;
import dao.ProductDao;
import dao.TransactionDao;
import dao.TransactionDetailDao;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.PurchaseItemDto;
import model.Product;
import model.Transaction;
import model.TransactionDetail;

public class TransactionService {
    private final TransactionDao transactionDao = new TransactionDao();
    private final TransactionDetailDao transactionDetailDao = new TransactionDetailDao();
    private final ProductDao productDao = new ProductDao();

    public String productPurchase(List<PurchaseItemDto> purchasedItems) {
        try {
            UUID transactionId = UUID.randomUUID(); // Ini buat bikin ID otomatis
            Timestamp transactionDatetime = new Timestamp(System.currentTimeMillis());
            
            DbConnection dbConnection = new DbConnection();
            dbConnection.makeConnection();
            DbConnection.CON.setAutoCommit(false);

            BigDecimal total = hitungTotalTransaksi(purchasedItems);
            System.out.println("Total Transaksi: " + total);

            Transaction transaction = new Transaction();
            transaction.setTransactionId(transactionId.toString());
            transaction.setTransactionDate(transactionDatetime);
            transaction.setTotal(total);
            transaction.setBuyer("buyer-dummy");
            transaction.setCashier("cashier-dummy");
            transactionDao.create(DbConnection.CON, transaction);

            List<TransactionDetail> transactionDetails = new ArrayList<>();
            List<Product> products = new ArrayList<>();

            for (PurchaseItemDto item : purchasedItems) {
                UUID transactionDetailId = UUID.randomUUID();

                TransactionDetail transactionDetail = new TransactionDetail();
                transactionDetail.setTransactionDetailId(transactionDetailId.toString());
                transactionDetail.setTransactionId(transactionId.toString());
                transactionDetail.setProductId(item.getProduct().getId());
                transactionDetail.setQuantityPurchased(item.getQuantityPurchased());
                transactionDetail.setSubTotal(hitungSubTotalTransaksi(item));
                transactionDetails.add(transactionDetail);

                Product product = item.getProduct();
                product.setStock(product.getStock() - item.getQuantityPurchased());
                products.add(product);
            }

            transactionDetailDao.create(DbConnection.CON, transactionDetails);
            productDao.batchUpdate(DbConnection.CON, products);

            DbConnection.CON.commit();
            DbConnection.CON.close();
            return String.valueOf(total);
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                if (DbConnection.CON != null) {
                    DbConnection.CON.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public BigDecimal hitungTotalTransaksi(List<PurchaseItemDto> purchasedItems) {
        BigDecimal total = BigDecimal.ZERO;
        for (PurchaseItemDto item : purchasedItems) {
            total = total.add(hitungSubTotalTransaksi(item));
        }
        return total;
    }

    public BigDecimal hitungSubTotalTransaksi(PurchaseItemDto purchasedItem) {
        BigDecimal price = purchasedItem.getProduct().getPrice();
        BigDecimal quantity = new BigDecimal(purchasedItem.getQuantityPurchased());
        return price.multiply(quantity);
    }
}
