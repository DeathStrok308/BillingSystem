package Billingsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class ManageAccounts extends javax.swing.JFrame {
ResultSet Result = null;
Database db = new Database();
boolean editFlag = false;
    public ManageAccounts() {
        initComponents();
        updateTable();
    }

    private String getPass(){
        char[] tpass = EmployeePassword.getPassword();
        String pass = new String(tpass);
        return pass;
    }
    private String getCPass(){
        char[] tpass = EmployeeConfirmPassword.getPassword();
        String pass = new String(tpass);
        return pass;
    }
    
    public void updateTable(){
        if(SearchBar.getText().equals("")){
            Result = db.getResult("SELECT USERNAME, USERTYPE FROM LOGIN");
            UserTable.setModel(DbUtils.resultSetToTableModel(Result));
        }
        else{
            Result = db.getResult("SELECT USERNAME, USERTYPE FROM LOGIN WHERE USERNAME LIKE '"+SearchBar.getText()+"%'");
            UserTable.setModel(DbUtils.resultSetToTableModel(Result));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserTable = new javax.swing.JTable();
        Search = new javax.swing.JLabel();
        SearchBar = new javax.swing.JTextField();
        Username = new javax.swing.JLabel();
        UserType = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        ConfirmPassword = new javax.swing.JLabel();
        EmployeeUsername = new javax.swing.JTextField();
        EmployeeUserType = new javax.swing.JComboBox<>();
        EmployeePassword = new javax.swing.JPasswordField();
        EmployeeConfirmPassword = new javax.swing.JPasswordField();
        AddUser = new javax.swing.JButton();
        DeleteUser = new javax.swing.JButton();
        BackToAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackgroundPanel.setBackground(new java.awt.Color(204, 102, 255));

        UserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name of employee ", "Employee ID", "Field of work", "Account password"
            }
        ));
        UserTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(UserTable);

        Search.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        Search.setText("Search:");

        SearchBar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        SearchBar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                SearchBarCaretUpdate(evt);
            }
        });

        Username.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        Username.setText("Username:");

        UserType.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        UserType.setText("User Type:");

        Password.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        Password.setText("Account password:");

        ConfirmPassword.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        ConfirmPassword.setText("Retype Password:");

        EmployeeUsername.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N

        EmployeeUserType.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        EmployeeUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "POS", "Inventory" }));
        EmployeeUserType.setSelectedIndex(-1);

        EmployeePassword.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N

        EmployeeConfirmPassword.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N

        AddUser.setText("Add User");
        AddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserActionPerformed(evt);
            }
        });

        DeleteUser.setText("Delete User");
        DeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteUserActionPerformed(evt);
            }
        });

        BackToAdmin.setText("Back");
        BackToAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackgroundPanelLayout = new javax.swing.GroupLayout(BackgroundPanel);
        BackgroundPanel.setLayout(BackgroundPanelLayout);
        BackgroundPanelLayout.setHorizontalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackgroundPanelLayout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DeleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BackToAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(180, 180, 180))
                    .addGroup(BackgroundPanelLayout.createSequentialGroup()
                        .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(BackgroundPanelLayout.createSequentialGroup()
                                        .addComponent(UserType)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(EmployeeUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BackgroundPanelLayout.createSequentialGroup()
                                        .addComponent(ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(EmployeeConfirmPassword))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BackgroundPanelLayout.createSequentialGroup()
                                        .addComponent(Password)
                                        .addGap(18, 18, 18)
                                        .addComponent(EmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BackgroundPanelLayout.createSequentialGroup()
                                        .addComponent(Username)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(EmployeeUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        BackgroundPanelLayout.setVerticalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search))
                .addGap(24, 24, 24)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Username)
                    .addComponent(EmployeeUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EmployeeUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserType))
                .addGap(18, 18, 18)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password)
                    .addComponent(EmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmPassword)
                    .addComponent(EmployeeConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(AddUser)
                .addGap(18, 18, 18)
                .addComponent(DeleteUser)
                .addGap(18, 18, 18)
                .addComponent(BackToAdmin)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserActionPerformed
        if(EmployeeUsername.getText().equals("")){
            JOptionPane.showMessageDialog(this, "The Employee ID field is empty");
            EmployeeUsername.requestFocus();
        }
        else if(EmployeeUserType.getSelectedIndex()== -1){
            JOptionPane.showMessageDialog(this, "Please select a Designation for the User");
            EmployeeUserType.requestFocus();
        }
        else if(getPass().equals("")){
            JOptionPane.showMessageDialog(this, "The Password field is empty");
            EmployeePassword.requestFocus();
        }
        else if(getCPass().equals("")){
            JOptionPane.showMessageDialog(this, "The Confirm Password field is empty");
            EmployeeConfirmPassword.requestFocus();
        }
        else if(!(getPass().equals(getCPass()))){
            JOptionPane.showMessageDialog(this, "The Password and Confirm password fields dont match");
            EmployeePassword.setText("");
            EmployeeConfirmPassword.setText("");
            EmployeePassword.requestFocus();
        }
        else if (this.editFlag){
            db.runQuery("UPDATE LOGIN SET USERTYPE='"+String.valueOf(EmployeeUserType.getSelectedItem())+"', PASSWORD ='"+getPass()+"' WHERE USERNAME ='"+EmployeeUsername.getText()+"'");
            SearchBar.setText("");
            EmployeeUsername.setEnabled(true);
            EmployeeUsername.setText("");
            EmployeePassword.setText("");
            EmployeeConfirmPassword.setText("");
            EmployeeUserType.setSelectedIndex(-1);
            AddUser.setText("Add User");
            this.editFlag = false;
            updateTable();
        }
        else{
            try{
            Result = db.getResult("SELECT USERNAME FROM LOGIN WHERE USERNAME ='"+EmployeeUsername.getText()+"'");
                if(Result.next()){
                    JOptionPane.showMessageDialog(this, "The Username already exists\nPlease Choose an other User Name");
                }
                else{
                    PreparedStatement pstat = db.Connect.prepareStatement("INSERT INTO LOGIN VALUES(?,?,?)");
                    pstat.setString(1, EmployeeUsername.getText());
                    pstat.setString(2, getPass());
                    pstat.setString(3, String.valueOf(EmployeeUserType.getSelectedItem()));
                    int i = pstat.executeUpdate();
                    JOptionPane.showMessageDialog(this, "The User was added Succesfully");
                    SearchBar.setText("");
                    EmployeeUsername.setText("");
                    EmployeePassword.setText("");
                    EmployeeConfirmPassword.setText("");
                    EmployeeUserType.setSelectedIndex(-1);
                    this.editFlag = false;
                    updateTable();
                }
            }
            catch(SQLException errors){
                errors.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_AddUserActionPerformed

    private void UserTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserTableMouseClicked
        int row = UserTable.getSelectedRow();
        if(row != -1){
            EmployeeUsername.setText(String.valueOf(UserTable.getValueAt(row,0)));
            EmployeeUsername.setEnabled(false);
            EmployeeUserType.setSelectedItem(UserTable.getValueAt(row, 1));
            EmployeePassword.setText("");
            EmployeeConfirmPassword.setText("");
            this.editFlag = true;
            AddUser.setText("Edit");
        }
    }//GEN-LAST:event_UserTableMouseClicked

    private void DeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteUserActionPerformed
        int row = UserTable.getSelectedRow();
        if(row != -1)
            db.runQuery("DELETE FROM LOGIN WHERE USERNAME ='"+UserTable.getValueAt(row , 0) +"'");
        SearchBar.setText("");
        EmployeeUsername.setText("");
        EmployeeUsername.setEnabled(true);
        this.editFlag = false;
        AddUser.setText("Add");
        EmployeeUserType.setSelectedIndex(-1);
        
        updateTable();
    }//GEN-LAST:event_DeleteUserActionPerformed

    private void SearchBarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_SearchBarCaretUpdate
        updateTable();
    }//GEN-LAST:event_SearchBarCaretUpdate

    private void BackToAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToAdminActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "Are you sure want to quit?\nAll unsaved work will be lost.");
        if(i == 0){            
            Admin movetoAdmin = new Admin();
            movetoAdmin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BackToAdminActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the NimBackgroundPanelk and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://dBackgroundPanel.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageAccounts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUser;
    private javax.swing.JButton BackToAdmin;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JLabel ConfirmPassword;
    private javax.swing.JButton DeleteUser;
    private javax.swing.JPasswordField EmployeeConfirmPassword;
    private javax.swing.JPasswordField EmployeePassword;
    private javax.swing.JComboBox<String> EmployeeUserType;
    private javax.swing.JTextField EmployeeUsername;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Search;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JTable UserTable;
    private javax.swing.JLabel UserType;
    private javax.swing.JLabel Username;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
