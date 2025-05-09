package view;
import controller.ProductController;
import model.Product;
import exception.EmptyInputException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class ProductView extends javax.swing.JFrame {
    private final ProductController productController = new ProductController();
    private boolean isAddAction = true;
    List<Product> products;
    
    public ProductView() {
        initComponents();
        setComponent(false);
        setDropDown();
        showProduct();
    }
    
    public void setComponent(boolean value){
        idProdukInput.setEnabled(false);
        namaProdukInput.setEnabled(value);
        stokProdukInput.setEnabled(value);
        hargaProdukInput.setEnabled(value);
        tipeProdukInput.setEnabled(value);
        cancelButton.setEnabled(value);
        confirmButton.setEnabled(value);
    }
    
    public void setEditDeleteButton(boolean value){
        editButton.setEnabled(value);
        deleteButton.setEnabled(value);
    }
    
    public void clearText(){
        idProdukInput.setText("");
        namaProdukInput.setText("");
        stokProdukInput.setText("");
        hargaProdukInput.setText("");
        tipeProdukInput.setSelectedIndex(0);
    }
    
    public void setDropDown(){
        tipeProdukInput.addItem("Makanan");
        tipeProdukInput.addItem("Minuman");
    }
    
    public TableProductView mapToTableProduct(String query){
        products = productController.read(query);
        TableProductView tableProductView = new TableProductView(products);
        return tableProductView;
    }

    public void showProduct(){
        productTable.setModel(mapToTableProduct(""));
    }
    
    private void validateInput() throws EmptyInputException{ 
        boolean invalidName = namaProdukInput.getText().isBlank() ; 
        boolean invalidPrice = hargaProdukInput.getText().isBlank(); 
        boolean invalidStock = stokProdukInput.getText().isBlank();  
            if(invalidName ||  invalidPrice || invalidStock){ 
                throw new EmptyInputException(); 
            } 
    }
    
    private void doSearchProduk(){
        if(searchInput.getText().isEmpty())
            return;
        
                Product p = productController.search(searchInput.getText());
            if(p == null){
                JOptionPane.showMessageDialog(rootPane, "NOT FOUND !!!");
                return;
            }
            setEditDeleteButton(true);
            clearText();
            
            idProdukInput.setText(String.valueOf(p.getId()));
            namaProdukInput.setText(p.getName());
            stokProdukInput.setText(String.valueOf(p.getStock()));
            hargaProdukInput.setText(String.valueOf(p.getPrice()));
            if(p.getType().equals("Makanan")){
                tipeProdukInput.setSelectedIndex(0);
            }else{
                tipeProdukInput.setSelectedIndex(1);
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cashierButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tablePanel = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        buttonPanel = new javax.swing.JPanel();
        createButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        inputPanel = new javax.swing.JPanel();
        namaProdukInput = new javax.swing.JTextField();
        idProdukInput = new javax.swing.JTextField();
        hargaProdukInput = new javax.swing.JTextField();
        tipeProdukInput = new javax.swing.JComboBox<>();
        stokProdukInput = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();
        idProdukLabel = new javax.swing.JLabel();
        namaProdukLabel = new javax.swing.JLabel();
        hargaProdukLabel = new javax.swing.JLabel();
        tipeProdukLabel = new javax.swing.JLabel();
        stokProdukLabel = new javax.swing.JLabel();
        searchInputPanel = new javax.swing.JPanel();
        searchInput = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 800));
        setResizable(false);

        background.setBackground(new java.awt.Color(204, 204, 204));

        header.setBackground(new java.awt.Color(255, 153, 51));
        header.setPreferredSize(new java.awt.Dimension(1000, 100));

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Warkop PBO");

        cashierButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cashierButton.setText("Cashier");
        cashierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashierButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cashierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cashierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 700));

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        tablePanel.setViewportView(productTable);

        buttonPanel.setBackground(new java.awt.Color(204, 204, 204));

        createButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editButton.setText("Update");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        inputPanel.setBackground(new java.awt.Color(204, 204, 204));

        namaProdukInput.setBackground(new java.awt.Color(255, 255, 255));

        idProdukInput.setBackground(new java.awt.Color(255, 255, 255));

        hargaProdukInput.setBackground(new java.awt.Color(255, 255, 255));

        tipeProdukInput.setBackground(new java.awt.Color(255, 255, 255));

        stokProdukInput.setBackground(new java.awt.Color(255, 255, 255));

        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        idProdukLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        idProdukLabel.setForeground(new java.awt.Color(0, 0, 0));
        idProdukLabel.setText("Id Produk");

        namaProdukLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        namaProdukLabel.setForeground(new java.awt.Color(0, 0, 0));
        namaProdukLabel.setText("Nama Produk");

        hargaProdukLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hargaProdukLabel.setForeground(new java.awt.Color(0, 0, 0));
        hargaProdukLabel.setText("Harga Produk");

        tipeProdukLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tipeProdukLabel.setForeground(new java.awt.Color(0, 0, 0));
        tipeProdukLabel.setText("Tipe");

        stokProdukLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        stokProdukLabel.setForeground(new java.awt.Color(0, 0, 0));
        stokProdukLabel.setText("Stok Produk");

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idProdukLabel)
                    .addComponent(namaProdukLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaProdukLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipeProdukLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokProdukLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addGap(29, 29, 29)
                        .addComponent(confirmButton))
                    .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(idProdukInput, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                        .addComponent(hargaProdukInput, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                        .addComponent(namaProdukInput)
                        .addComponent(tipeProdukInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stokProdukInput, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idProdukInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idProdukLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaProdukInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaProdukLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaProdukInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaProdukLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipeProdukInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipeProdukLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stokProdukInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokProdukLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        searchInputPanel.setBackground(new java.awt.Color(204, 204, 204));

        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchInputPanelLayout = new javax.swing.GroupLayout(searchInputPanel);
        searchInputPanel.setLayout(searchInputPanelLayout);
        searchInputPanelLayout.setHorizontalGroup(
            searchInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchInputPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        searchInputPanelLayout.setVerticalGroup(
            searchInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchInputPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(searchInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(147, 147, 147)
                        .addComponent(searchInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addComponent(tablePanel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        isAddAction = Boolean.TRUE;
        setComponent(true);
        clearText();
        searchInput.setText("");
    }//GEN-LAST:event_createButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        isAddAction = Boolean.FALSE;
        setComponent(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Apakah Anda Yakin Ingin Menghapus Data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(getAnswer == 0){
            try{
                int id = Integer.parseInt(idProdukInput.getText());
                productController.delete(id);
                clearText();
                showProduct();
                setComponent(false);
                setEditDeleteButton(false);
            }catch(Exception e){
                System.out.println("Error : " + e.getMessage());
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        setEditDeleteButton(true);
        setComponent(false);
        int clickedRow = productTable.getSelectedRow();
        TableModel tableModel = productTable.getModel();
        idProdukInput.setText(tableModel.getValueAt(clickedRow, 0).toString());
        namaProdukInput.setText(tableModel.getValueAt(clickedRow, 1).toString());
        hargaProdukInput.setText(tableModel.getValueAt(clickedRow, 3).toString());
        stokProdukInput.setText(tableModel.getValueAt(clickedRow, 4).toString());
        
        String valueColumnType = tableModel.getValueAt(clickedRow, 2).toString();
        if(Objects.equals(valueColumnType, "Makanan")){
            tipeProdukInput.setSelectedIndex(0);
        }else{
            tipeProdukInput.setSelectedIndex(1);
        }
    }//GEN-LAST:event_productTableMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setComponent(false);
        clearText();
        setEditDeleteButton(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        try{
            validateInput();
            if(isAddAction){
                Product product = new Product();
                product.setName(namaProdukInput.getText());
                product.setPrice(new BigDecimal(hargaProdukInput.getText()));
                product.setStock(Integer.valueOf(stokProdukInput.getText()));
                
                if(tipeProdukInput.getSelectedIndex() == 0){
                    product.setType("Makanan");
                }else{
                    product.setType("Minuman");
                }
                productController.create(product);
                showProduct();
            }else{
                Product product = new Product();
                product.setName(namaProdukInput.getText());
                product.setPrice(new BigDecimal(hargaProdukInput.getText()));
                product.setStock(Integer.valueOf(stokProdukInput.getText()));
                
                if(tipeProdukInput.getSelectedIndex() == 0){
                    product.setType("Makanan");
                }else{
                    product.setType("Minuman");
                }
                productController.update(Integer.parseInt(idProdukInput.getText()), product);
                clearText();
                showProduct();
                setComponent(false);
                setEditDeleteButton(false);
            }
        }catch(EmptyInputException e){
            JOptionPane.showMessageDialog(this, e.message());
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        doSearchProduk();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void cashierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashierButtonActionPerformed
        // TODO add your handling code here:
        CashierView cv = new CashierView();
        this.dispose();
        cv.setVisible(true);
    }//GEN-LAST:event_cashierButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cashierButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField hargaProdukInput;
    private javax.swing.JLabel hargaProdukLabel;
    private javax.swing.JPanel header;
    private javax.swing.JTextField idProdukInput;
    private javax.swing.JLabel idProdukLabel;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField namaProdukInput;
    private javax.swing.JLabel namaProdukLabel;
    private javax.swing.JTable productTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchInput;
    private javax.swing.JPanel searchInputPanel;
    private javax.swing.JTextField stokProdukInput;
    private javax.swing.JLabel stokProdukLabel;
    private javax.swing.JScrollPane tablePanel;
    private javax.swing.JComboBox<String> tipeProdukInput;
    private javax.swing.JLabel tipeProdukLabel;
    // End of variables declaration//GEN-END:variables
}
