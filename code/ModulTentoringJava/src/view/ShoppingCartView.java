/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.PurchaseItemDto;

public class ShoppingCartView extends AbstractTableModel {
    private List<PurchaseItemDto> items; // Daftar item yang akan ditampilkan dalam tabel

    // Constructor untuk menginisialisasi daftar item
    public ShoppingCartView(List<PurchaseItemDto> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size(); // Mengembalikan jumlah baris berdasarkan ukuran daftar item
    }

    @Override
    public int getColumnCount() {
        return 3; // Jumlah kolom tetap, yaitu 3 (ID, Nama, Jumlah)
    }

    @Override
    public String getColumnName(int column) {
        // Menentukan nama kolom berdasarkan indeks kolom
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Jumlah";
            default:
                return null; // Jika indeks kolom tidak valid
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Mengambil data dari item berdasarkan baris dan kolom
        switch (columnIndex) {
            case 0:
                return items.get(rowIndex).getProduct().getId(); // ID produk
            case 1:
                return items.get(rowIndex).getProduct().getName(); // Nama produk
            case 2:
                return items.get(rowIndex).getQuantityPurchased(); // Jumlah yang dibeli
            default:
                return null; // Jika indeks kolom tidak valid
        }
    }
}
