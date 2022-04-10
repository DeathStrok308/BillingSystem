package Billingsystem;

import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class POS extends javax.swing.JFrame {
Database db = new Database();
ResultSet Result = null;
boolean admin;
boolean Continue = false;
DecimalFormat DecimalFormater = new DecimalFormat("########.##");
Date getDate = new Date();
java.sql.Date getDateSQL = new java.sql.Date(getDate.getTime());

    public POS(boolean value) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.admin = value;
        if(value){
            LogOut.setText("Back to Admin");
        }
        SearchBar.requestFocus();
    }
    public void printBill()
    {
        String total = ProductBillTotal.getText();
        String Payamnt = PayedAmount.getText();
        String balance = BalanceAmount.getText();
        DefaultTableModel prodtable = new DefaultTableModel();
        prodtable = (DefaultTableModel)ProductTable.getModel();
        FBill.setText(FBill.getText() + "-------------------------------------------------------------------------\n");
        FBill.setText(FBill.getText() + "                                   Abhi Groceries                        \n");
        FBill.setText(FBill.getText() + "-------------------------------------------------------------------------\n");
        FBill.setText(FBill.getText() + "Product"    + "\t" + "Quantity" + "\t" + "Rate" + "\t" + "Total price" + "\n");
        for(int i=0; i<prodtable.getRowCount(); i++)
        {
            String prodname = (String)prodtable.getValueAt(i, 1);
            String prodquantity = (String)prodtable.getValueAt(i, 2);
            String prodrate = (String)prodtable.getValueAt(i, 3);
            String prodprice = (String)prodtable.getValueAt(i, 4);
            FBill.setText(FBill.getText() + prodname   + "\t" + prodquantity + "\t" + prodrate + "\t" + prodprice + "\n");
        }
        FBill.setText(FBill.getText() + "\n");
        FBill.setText(FBill.getText() + "                                                                             " + "Total :" +total);
        FBill.setText(FBill.getText() + "\n");
        FBill.setText(FBill.getText() + "Phone number :" +Phone.getText());
        FBill.setText(FBill.getText() + "\n");
        FBill.setText(FBill.getText() + "                                           Thank you                     \n");
        
    }
    private void removeAllItems(){
        for(int i = ProductName.getItemCount()-1;ProductName.getItemCount()>1;i--){
            ProductName.removeItemAt(i);
        }
    }
    
    private void refreshComboBox(){
        if(!(SearchBar.getText().equals(""))){
            removeAllItems();
            Result = db.getResult("SELECT PRODUCTNAME FROM PRODUCTS WHERE PRODUCTNAME LIKE '"+SearchBar.getText().toUpperCase()+"%'");
            try{
                while(Result.next()){
                    ProductName.addItem(Result.getString(1));
                }
            }
            catch(SQLException errors){
                errors.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Code = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        Quantity = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        BillTotal = new javax.swing.JLabel();
        ProductCode = new javax.swing.JTextField();
        ProductQuantity = new javax.swing.JTextField();
        ProductPrice = new javax.swing.JTextField();
        ProductBillTotal = new javax.swing.JTextField();
        AddProduct = new javax.swing.JButton();
        Balence = new javax.swing.JLabel();
        PayedAmount = new javax.swing.JTextField();
        BalanceAmount = new javax.swing.JTextField();
        Payed1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        CalculateBilling = new javax.swing.JButton();
        ProductName = new javax.swing.JComboBox<>();
        LogOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        FBill = new javax.swing.JTextArea();
        SearchBar = new javax.swing.JTextField();
        Phone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POS");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));

        Code.setFont(new java.awt.Font("High Tower Text", 3, 24)); // NOI18N
        Code.setText("Product code");

        Name.setFont(new java.awt.Font("High Tower Text", 3, 24)); // NOI18N
        Name.setText("Product Name");

        Quantity.setFont(new java.awt.Font("High Tower Text", 3, 24)); // NOI18N
        Quantity.setText("Quantity");

        Price.setFont(new java.awt.Font("High Tower Text", 3, 24)); // NOI18N
        Price.setText("Rate");

        BillTotal.setFont(new java.awt.Font("High Tower Text", 3, 24)); // NOI18N
        BillTotal.setText("Bill Total");

        ProductCode.setEditable(false);
        ProductCode.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N

        ProductQuantity.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        ProductQuantity.setNextFocusableComponent(AddProduct);
        ProductQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProductQuantityFocusLost(evt);
            }
        });

        ProductPrice.setEditable(false);
        ProductPrice.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N

        ProductBillTotal.setEditable(false);
        ProductBillTotal.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N

        AddProduct.setText("Add Product");
        AddProduct.setName(""); // NOI18N
        AddProduct.setNextFocusableComponent(SearchBar);
        AddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductActionPerformed(evt);
            }
        });

        Balence.setFont(new java.awt.Font("High Tower Text", 3, 24)); // NOI18N
        Balence.setText("Balance");

        PayedAmount.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        PayedAmount.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                PayedAmountCaretUpdate(evt);
            }
        });

        BalanceAmount.setEditable(false);
        BalanceAmount.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N

        Payed1.setFont(new java.awt.Font("High Tower Text", 3, 24)); // NOI18N
        Payed1.setText("Payed amount");

        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Product Quantity", "Rate", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProductTable.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(ProductTable);
        ProductTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (ProductTable.getColumnModel().getColumnCount() > 0) {
            ProductTable.getColumnModel().getColumn(0).setResizable(false);
            ProductTable.getColumnModel().getColumn(1).setResizable(false);
            ProductTable.getColumnModel().getColumn(2).setResizable(false);
            ProductTable.getColumnModel().getColumn(3).setResizable(false);
            ProductTable.getColumnModel().getColumn(4).setResizable(false);
        }

        CalculateBilling.setText("Finish Current Bill");
        CalculateBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateBillingActionPerformed(evt);
            }
        });

        ProductName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        ProductName.setNextFocusableComponent(ProductQuantity);
        ProductName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ProductNameItemStateChanged(evt);
            }
        });
        ProductName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ProductNameFocusGained(evt);
            }
        });

        LogOut.setText("Logout");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        FBill.setEditable(false);
        FBill.setColumns(20);
        FBill.setRows(5);
        jScrollPane1.setViewportView(FBill);

        SearchBar.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        SearchBar.setNextFocusableComponent(ProductName);
        SearchBar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                SearchBarCaretUpdate(evt);
            }
        });

        Phone.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        Phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("High Tower Text", 3, 24)); // NOI18N
        jLabel1.setText("Phone number");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LogOut)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(ProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Code, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Name)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(315, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(BillTotal))
                            .addComponent(ProductBillTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Payed1)
                            .addComponent(PayedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CalculateBilling, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Balence, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BalanceAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(163, 163, 163)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogOut)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Name)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Price)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AddProduct))))
                            .addGap(1, 1, 1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Code)
                                .addComponent(Quantity))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BillTotal)
                            .addComponent(Payed1)
                            .addComponent(Balence))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProductBillTotal)
                            .addComponent(PayedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BalanceAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(CalculateBilling)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductActionPerformed
        if(ProductName.getSelectedIndex()== 0){
            JOptionPane.showMessageDialog(this, "Please Select an Item");
            ProductName.requestFocus();
        }
        else if(ProductQuantity.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter Quantity of Amount Required");
            ProductQuantity.requestFocus();
        }
        else{
            try{
                Result = db.getResult("SELECT INSTOCK FROM PRODUCTS WHERE CODE='"+ProductCode.getText()+"'");
                Result.next();
                int stockQuantity = Result.getInt(1);
                if (stockQuantity>=Integer.parseInt(ProductQuantity.getText())){
                    boolean presentInTable = false;
                    int i;
                    for(i =0;i<ProductTable.getRowCount();i++){
                        if(Integer.parseInt(String.valueOf(ProductTable.getValueAt(i, 0)))== Integer.parseInt(ProductCode.getText())){
                            presentInTable = true; 
                            break;
                        }
                    }
                    if (presentInTable){
                        ProductTable.setValueAt(String.valueOf(Integer.parseInt(String.valueOf(ProductTable.getValueAt(i,2))) + 
                                Integer.parseInt(ProductQuantity.getText())), i, 2);
                        ProductTable.setValueAt(DecimalFormater.format(Double.parseDouble(String.valueOf(ProductTable.getValueAt(i,2)))*
                                Double.parseDouble(String.valueOf(ProductTable.getValueAt(i,3)))),i,4);
                    }
                    else{
                        DefaultTableModel prodtable = new DefaultTableModel();
                        prodtable = (DefaultTableModel)ProductTable.getModel();
                        prodtable.addRow(new Object[]
                        {
                            ProductCode.getText(),
                            ProductName.getSelectedItem(),
                            ProductQuantity.getText(),
                            ProductPrice.getText(),
                            String.valueOf(DecimalFormater.format(Double.parseDouble(ProductQuantity.getText())*Double.parseDouble(ProductPrice.getText())))
                        });
                    }    
                    double billtotal = 0;
                    for (i=0; i<ProductTable.getRowCount(); i++){
                        billtotal = billtotal + Double.parseDouble(String.valueOf(ProductTable.getValueAt(i, 4)));
                    }
                    ProductBillTotal.setText(String.valueOf(billtotal));
                    FBill.setText("");
                    printBill();
                    ProductCode.setText("");
                    removeAllItems();
                    ProductQuantity.setText("");
                    ProductPrice.setText("");
                    SearchBar.requestFocus();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Not enough Qunatity available");
                    ProductQuantity.setText("");
                    ProductQuantity.requestFocus();
                }
            }
            catch(SQLException errors)
            {
                errors.printStackTrace();
            }
        }    

    }//GEN-LAST:event_AddProductActionPerformed

    private void PayedAmountCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_PayedAmountCaretUpdate
        if(!(PayedAmount.getText().equals(""))){
            BalanceAmount.setText(DecimalFormater.format(Double.parseDouble(PayedAmount.getText())-Double.parseDouble(ProductBillTotal.getText())));
        }
    }//GEN-LAST:event_PayedAmountCaretUpdate

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

    private void ProductQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductQuantityFocusLost
        try{
            ProductQuantity.setText(String.valueOf(Integer.parseInt(ProductQuantity.getText())));
        }
        catch(NumberFormatException errors){
            JOptionPane.showMessageDialog(this, "Please enter only numbers in quantity");
            ProductQuantity.setText("");
        }
    }//GEN-LAST:event_ProductQuantityFocusLost

    private void CalculateBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateBillingActionPerformed
        if(ProductTable.getRowCount() ==0)
        {
            JOptionPane.showMessageDialog(this, "Please add Items in the bill to proceed");
        }
        else{
            int i =  JOptionPane.showConfirmDialog(this, "Is this the final bill?\nAll values will be updated in the database.");
            if(i ==0){

                try{
                    for(int j = 0; j<ProductTable.getRowCount();j++){
                        Result = db.getResult("SELECT INSTOCK FROM PRODUCTS WHERE CODE ='"+ProductTable.getValueAt(j,0)+"'");
                        Result.next();
                        db.runQuery("UPDATE PRODUCTS SET INSTOCK = "+(Result.getInt(1)-Integer.parseInt(String.valueOf(ProductTable.getValueAt(j,2))))+" WHERE CODE ='"+ProductTable.getValueAt(j,0)+"'");
                    }
                }
                catch(SQLException errors){
                    errors.printStackTrace();
                }
                try{
                    Result = db.getResult("SELECT * FROM DAILYSALES WHERE TDATE = '"+getDateSQL.toString()+"'");
                    if(Result.next()){
                        db.runQuery("UPDATE DAILYSALES SET SALES ="+(Result.getDouble(2)+Double.parseDouble(ProductBillTotal.getText()))+" WHERE TDATE='"+getDateSQL.toString()+"'");
                    }
                    else{
                        java.sql.Date sqlDate = new java.sql.Date(getDate.getTime());
                        PreparedStatement pstat = db.Connect.prepareStatement("INSERT INTO DAILYSALES VALUES(?,?)");
                        pstat.setDate(1,  sqlDate);
                        pstat.setDouble(2, Double.parseDouble(ProductBillTotal.getText()));
                        int x = pstat.executeUpdate();
                    }
                }
                catch(SQLException errors){
                    errors.printStackTrace();
                }
                try{
                    boolean complete = FBill.print();
                    if (complete){
                        JOptionPane.showMessageDialog (null,    "Done printing","Note", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog (null, "The document will be processed, please click OK", "Note", JOptionPane.ERROR_MESSAGE);
                    }
                    } catch (PrinterException e) {
                    JOptionPane.showMessageDialog (null, e);
                }
                Phone.setText("");
                ProductCode.setText("");
                removeAllItems();
                ProductQuantity.setText("");
                ProductPrice.setText("");
                SearchBar.requestFocus();
                ProductBillTotal.setText("");
                PayedAmount.setText("");
                BalanceAmount.setText("");
                FBill.setText("");
                DefaultTableModel prodtable = new DefaultTableModel();
                prodtable = (DefaultTableModel)ProductTable.getModel();
                int row = ProductTable.getRowCount();
                for(int j = 0; j<row;j++){
                    prodtable.removeRow(0);
                }
            }
        }

    }//GEN-LAST:event_CalculateBillingActionPerformed

    private void SearchBarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_SearchBarCaretUpdate
        refreshComboBox();
    }//GEN-LAST:event_SearchBarCaretUpdate

    private void ProductNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ProductNameItemStateChanged
        if(!(ProductName.getSelectedItem().toString().equals(" "))){
            Result = db.getResult("SELECT * FROM PRODUCTS WHERE PRODUCTNAME ='"+ProductName.getSelectedItem()+"'");
            try{
                if(Result.next()){
                    ProductCode.setText(Result.getString(1));
                    ProductPrice.setText(Result.getString(3));
                }
            }
            catch(SQLException errors){
                errors.printStackTrace();
            }
            SearchBar.setText("");
            refreshComboBox();
        }
    }//GEN-LAST:event_ProductNameItemStateChanged

    private void ProductNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductNameFocusGained

    private void PhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneActionPerformed

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
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POS(false).setVisible(true);
            }
        });
    }
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProduct;
    private javax.swing.JTextField BalanceAmount;
    private javax.swing.JLabel Balence;
    private javax.swing.JLabel BillTotal;
    private javax.swing.JButton CalculateBilling;
    private javax.swing.JLabel Code;
    private javax.swing.JTextArea FBill;
    private javax.swing.JButton LogOut;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Payed1;
    private javax.swing.JTextField PayedAmount;
    private javax.swing.JTextField Phone;
    private javax.swing.JLabel Price;
    private javax.swing.JTextField ProductBillTotal;
    private javax.swing.JTextField ProductCode;
    private javax.swing.JComboBox<String> ProductName;
    private javax.swing.JTextField ProductPrice;
    private javax.swing.JTextField ProductQuantity;
    private javax.swing.JTable ProductTable;
    private javax.swing.JLabel Quantity;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}