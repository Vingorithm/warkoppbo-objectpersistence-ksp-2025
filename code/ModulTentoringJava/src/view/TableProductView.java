package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Product;

public class TableProductView extends AbstractTableModel {
    private List<Product> products;
    
    public TableProductView(List<Product> products){
        this.products = products;
    }
    
    public List<Product> getProducts(){
        return products;
    }
    
    public void setProducts(List<Product> products){
        this.products = products;
    }
    
    @Override
    public int getRowCount(){
        return products.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return products.get(rowIndex).getId();
            case 1 :
                return products.get(rowIndex).getName();
            case 2 : 
                return products.get(rowIndex).getType();
            case 3 :
                return products.get(rowIndex).getPrice();
            case 4 :
                return products.get(rowIndex).getStock();
            default : 
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1 :
                return "Nama";
            case 2 : 
                return "Tipe";
            case 3 :
                return "Harga";
            case 4 :
                return "Stok";
            default : 
                return null;
        }
    }
}
