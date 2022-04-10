package Billingsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Inventory extends javax.swing.JFrame {
Database db = new Database();
ResultSet Result = null;
DecimalFormat df = new DecimalFormat("#,##,##,###.00");
boolean admin;
boolean editFlag;
    public Inventory(boolean value) {
        initComponents();
        updateTable();
        this.setLocationRelativeTo(null);
        this.admin= value;
        if(value){
            LogOut.setText("Back to Admin");
        }
    }
    public void updateTable(){
        if(SearchBar.getText().equals("")){
            Result = db.getResult("SELECT * FROM PRODUCTS ORDER BY CODE ASC");
            InventoryTable.setModel(DbUtils.resultSetToTableModel(Result));
        }
        else{
            Result = db.getResult("SELECT * FROM PRODUCTS WHERE PRODUCTNAME LIKE '"+SearchBar.getText().toUpperCase()+"%' ORDER BY CODE ASC");
            InventoryTable.setModel(DbUtils.resultSetToTableModel(Result));
        }
        double total = 0;
        for(int i = 0; i< InventoryTable.getRowCount(); i++){
            total += Double.parseDouble(String.valueOf(InventoryTable.getValueAt(i, 2)))* Double.parseDouble(String.valueOf(InventoryTable.getValueAt(i, 3)));
        }
        TotalValue.setText(df.format(total));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        Code = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        ProductCode = new javax.swing.JTextField();
        ProductName = new javax.swing.JTextField();
        InStock = new javax.swing.JLabel();
        ProductInStock = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        InventoryTable = new javax.swing.JTable();
        AddItem = new javax.swing.JButton();
        RupeeLablle = new javax.swing.JLabel();
        ProductPrice = new javax.swing.JTextField();
        DeleteItems = new javax.swing.JButton();
        SearchBar = new javax.swing.JTextField();
        Seach = new javax.swing.JLabel();
        TotalValue = new javax.swing.JTextField();
        InventoryWorth = new javax.swing.JLabel();
        RupeeLable2 = new javax.swing.JLabel();
        LogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackgroundPanel.setBackground(new java.awt.Color(0, 204, 153));

        Code.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        Code.setText("Product Code:");

        Name.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        Name.setText("Product Name:");

        Price.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        Price.setText("Product Price:");

        ProductCode.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        ProductCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProductCodeFocusLost(evt);
            }
        });

        ProductName.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N

        InStock.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        InStock.setText("Product In Stock:");

        ProductInStock.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        ProductInStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProductInStockFocusLost(evt);
            }
        });

        InventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Price", "InStock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        InventoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InventoryTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(InventoryTable);

        AddItem.setText("Add Item");
        AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemActionPerformed(evt);
            }
        });

        RupeeLablle.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        RupeeLablle.setText("Rs.");

        ProductPrice.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        ProductPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProductPriceFocusLost(evt);
            }
        });

        DeleteItems.setText("Delete");
        DeleteItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteItemsActionPerformed(evt);
            }
        });

        SearchBar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        SearchBar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                SearchBarCaretUpdate(evt);
            }
        });

        Seach.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        Seach.setText("Search:");

        TotalValue.setEditable(false);
        TotalValue.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N

        InventoryWorth.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        InventoryWorth.setText("Inventory Worth:");

        RupeeLable2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        RupeeLable2.setText("Rs.");

        LogOut.setText("LogOut");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackgroundPanelLayout = new javax.swing.GroupLayout(BackgroundPanel);
        BackgroundPanel.setLayout(BackgroundPanelLayout);
        BackgroundPanelLayout.setHorizontalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(InventoryWorth, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RupeeLable2)
                .addGap(2, 2, 2)
                .addComponent(TotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Seach, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(BackgroundPanelLayout.createSequentialGroup()
                            .addGap(232, 232, 232)
                            .addComponent(ProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(BackgroundPanelLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Price)
                                .addComponent(InStock)
                                .addComponent(Name)
                                .addComponent(Code))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ProductInStock, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(BackgroundPanelLayout.createSequentialGroup()
                                        .addComponent(RupeeLablle)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(ProductName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(BackgroundPanelLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddItem)
                            .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DeleteItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        BackgroundPanelLayout.setVerticalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Code, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RupeeLablle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InStock, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductInStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(AddItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DeleteItems, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LogOut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Seach, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InventoryWorth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RupeeLable2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemActionPerformed
        if(ProductCode.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter an item code");
            ProductCode.requestFocus();
        }
        else if(ProductName.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Plase enter an product name");
            ProductName.requestFocus();
        }
        else if(ProductPrice.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please enter an price for the Product");
            ProductPrice.requestFocus();
        }
        else if(ProductInStock.getText().equals("")){
            JOptionPane.showMessageDialog(this, "PLease enter an stock qunatity");
            ProductInStock.requestFocus();
        }
        else if(this.editFlag){
            String sql= "";
            int i =0;
            try{
                sql = "UPDATE PRODUCTS SET PRODUCTNAME='"+ProductName.getText()+"', PRICE ="+df.format(Double.parseDouble(ProductPrice.getText()))+", ";
            }
            catch(NumberFormatException errors){
                JOptionPane.showMessageDialog(this, "Please enter a valid Price value");
                ProductPrice.requestFocus();
                i++;
            }
            try{
                sql += "INSTOCK = "+Integer.parseInt(ProductInStock.getText())+" WHERE CODE = '"+ProductCode.getText()+"'";
            }catch(NumberFormatException errors){
                JOptionPane.showMessageDialog(this, "Please enter a valid In Stock value");
                ProductInStock.requestFocus();
                i++;
            }
            if(i == 0){
                db.runQuery(sql);
                AddItem.setText("Add Item");
                ProductName.setEnabled(true);
                updateTable();
                ProductCode.setText("");
                ProductName.setText("");
                ProductPrice.setText("");
                ProductInStock.setText("");
                SearchBar.setText("");
                this.editFlag = true;
            }
        }
        else{
            try{
                Result = db.getResult("SELECT CODE FROM PRODUCTS WHERE CODE ='"+ProductCode.getText()+"'");
                if(Result.next()){
                    JOptionPane.showMessageDialog(this, "The Item Code Already Exists\nPlease use another one");
                    ProductCode.setText("");
                }
                else{
                    PreparedStatement pstat = db.Connect.prepareStatement("INSERT INTO PRODUCTS VALUES(?,?,?,?)");
                    pstat.setString(1, ProductCode.getText());
                    pstat.setString(2, ProductName.getText().toUpperCase());
                    pstat.setDouble(3, Double.parseDouble(ProductPrice.getText()));
                    pstat.setInt(4, Integer.parseInt(ProductInStock.getText()));
                    int i = pstat.executeUpdate();
                    updateTable();
                    ProductCode.setText("");
                    ProductName.setText("");
                    ProductPrice.setText("");
                    ProductInStock.setText("");
                    SearchBar.setText("");
                }
            }
            catch(SQLException errors){
                errors.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_AddItemActionPerformed

    private void ProductPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductPriceFocusLost
        try{
            ProductPrice.setText(df.format(Double.parseDouble(ProductPrice.getText())));
        }
        catch(NumberFormatException errors){
            JOptionPane.showMessageDialog(this, "Please enter only numbers and the decimal point here");
            ProductPrice.setText("");
            ProductPrice.requestFocus();
        }
    }//GEN-LAST:event_ProductPriceFocusLost

    private void ProductCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductCodeFocusLost
        try{
            ProductCode.setText(String.valueOf(Integer.parseInt(ProductCode.getText())));
        }
        catch(NumberFormatException errors){
            JOptionPane.showMessageDialog(this, "Please enter only numbers");
            ProductCode.setText("");
            ProductCode.requestFocus();
        }
    }//GEN-LAST:event_ProductCodeFocusLost

    private void InventoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InventoryTableMouseClicked
    int row = InventoryTable.getSelectedRow();
        if(row != -1){
            ProductCode.setEnabled(true);
            ProductCode.setText(String.valueOf(InventoryTable.getValueAt(row,0)));
            ProductName.setText(String.valueOf(InventoryTable.getValueAt(row,1)));
            ProductPrice.setText(String.valueOf(InventoryTable.getValueAt(row, 2)));
            ProductInStock.setText(String.valueOf(InventoryTable.getValueAt(row, 3)));
            this.editFlag = true;
            AddItem.setText("Edit");
        }
    }//GEN-LAST:event_InventoryTableMouseClicked

    private void DeleteItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemsActionPerformed
        int row = InventoryTable.getSelectedRow();
        if(row != -1)
            db.runQuery("DELETE FROM PRODUCTS WHERE CODE ='"+InventoryTable.getValueAt(row , 0) +"'");
        SearchBar.setText("");
        updateTable();
    }//GEN-LAST:event_DeleteItemsActionPerformed

    private void SearchBarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_SearchBarCaretUpdate
        updateTable();
    }//GEN-LAST:event_SearchBarCaretUpdate

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "Are you sure want to Log Out \nAll Unsaved work will be lost");
        if (i ==0){
            if(this.admin){
                Admin movetoAdmin = new Admin();
                movetoAdmin.setVisible(true);
            }
            else{
                Login movetoLogin = new Login();
                movetoLogin.setVisible(true);
            }
            this.dispose();
        }   
    }//GEN-LAST:event_LogOutActionPerformed

    private void ProductInStockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductInStockFocusLost
        try{
            ProductInStock.setText(String.valueOf(Integer.parseInt(ProductInStock.getText())));
        }
        catch(NumberFormatException errors){
            JOptionPane.showMessageDialog(this, "Please enter only numbers");
            ProductCode.setText("");
            ProductCode.requestFocus();
        }
    }//GEN-LAST:event_ProductInStockFocusLost

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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory(false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItem;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JLabel Code;
    private javax.swing.JButton DeleteItems;
    private javax.swing.JLabel InStock;
    private javax.swing.JTable InventoryTable;
    private javax.swing.JLabel InventoryWorth;
    private javax.swing.JButton LogOut;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Price;
    private javax.swing.JTextField ProductCode;
    private javax.swing.JTextField ProductInStock;
    private javax.swing.JTextField ProductName;
    private javax.swing.JTextField ProductPrice;
    private javax.swing.JLabel RupeeLable2;
    private javax.swing.JLabel RupeeLablle;
    private javax.swing.JLabel Seach;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JTextField TotalValue;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
