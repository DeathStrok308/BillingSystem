package Billingsystem;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Admin extends javax.swing.JFrame {
Database db = new Database();    
    public Admin() {
        initComponents();
        this.setLocationRelativeTo(null);
        Database db = new Database();
        java.util.Date getDate = new java.util.Date();
        java.sql.Date getDateSQL = new java.sql.Date(getDate.getTime());
        java.sql.ResultSet Result = db.getResult("SELECT SALES FROM DAILYSALES WHERE TDATE = '"+getDateSQL.toString()+"'");
        try{
            if(Result.next()){
                TotalSales.setText(String.valueOf(Result.getDouble(1)));
            }
            else
                TotalSales.setText("0");
        }
        catch(java.sql.SQLException errors){
            errors.printStackTrace();
        }
}

        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Welcome = new javax.swing.JLabel();
        Sales = new javax.swing.JLabel();
        TotalSales = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        ReportAndAnalysis = new javax.swing.JMenu();
        ReportGenerator = new javax.swing.JMenuItem();
        ManageAccounts = new javax.swing.JMenu();
        ManageAccount = new javax.swing.JMenuItem();
        Users = new javax.swing.JMenu();
        POS = new javax.swing.JMenuItem();
        Inventory = new javax.swing.JMenuItem();
        LogOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        Welcome.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        Welcome.setText("Welcome");

        Sales.setText("Today'sSales");

        TotalSales.setEditable(false);
        TotalSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalSalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addComponent(Sales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalSales, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(Welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Welcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sales)
                    .addComponent(TotalSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ReportAndAnalysis.setText("Report & Analysis");
        ReportAndAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportAndAnalysisActionPerformed(evt);
            }
        });

        ReportGenerator.setText("Create Report");
        ReportGenerator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportGeneratorActionPerformed(evt);
            }
        });
        ReportAndAnalysis.add(ReportGenerator);

        jMenuBar1.add(ReportAndAnalysis);

        ManageAccounts.setText("Manage User Accounts");

        ManageAccount.setText("Manage Accounts");
        ManageAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageAccountActionPerformed(evt);
            }
        });
        ManageAccounts.add(ManageAccount);

        jMenuBar1.add(ManageAccounts);

        Users.setText("Users");

        POS.setText("POS");
        POS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POSActionPerformed(evt);
            }
        });
        Users.add(POS);

        Inventory.setText("Inventory");
        Inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventoryActionPerformed(evt);
            }
        });
        Users.add(Inventory);

        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });
        Users.add(LogOut);

        jMenuBar1.add(Users);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReportGeneratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportGeneratorActionPerformed
JOptionPane.showMessageDialog(this, "Please click OK, the report will be generated.\n please dont close the application!");
        

    try {
            File f = new File("Sales.jrxml");
            JasperDesign JD = JRXmlLoader.load(f.getAbsolutePath());
            String Q = "SELECT\n" +
"     DAILYSALES.`TDATE` AS DAILYSALES_TDATE,\n" +
"     DAILYSALES.`SALES` AS DAILYSALES_SALES\n" +
"FROM\n" +
"     `DAILYSALES` DAILYSALES order by TDATE desc";
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(Q);
            JD.setQuery(updateQuery);
            JasperReport JR = JasperCompileManager.compileReport(JD);
            JasperPrint JP = JasperFillManager.fillReport(JR, null, db.Connect);    
            JasperViewer.viewReport(JP);
    } catch (JRException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_ReportGeneratorActionPerformed

    private void ManageAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageAccountActionPerformed
        ManageAccounts movetoManageAccounts = new ManageAccounts();
        movetoManageAccounts.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ManageAccountActionPerformed

    private void POSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_POSActionPerformed
        POS movetoPOS = new POS(true);
        movetoPOS.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_POSActionPerformed

    private void InventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventoryActionPerformed
        Inventory movetoInventory = new Inventory(true);
        movetoInventory.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_InventoryActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        Login movetoLogin = new Login();
        movetoLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutActionPerformed

    private void ReportAndAnalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportAndAnalysisActionPerformed
        
    }//GEN-LAST:event_ReportAndAnalysisActionPerformed

    private void TotalSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalSalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalSalesActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Inventory;
    private javax.swing.JMenuItem LogOut;
    private javax.swing.JMenuItem ManageAccount;
    private javax.swing.JMenu ManageAccounts;
    private javax.swing.JMenuItem POS;
    private javax.swing.JMenu ReportAndAnalysis;
    private javax.swing.JMenuItem ReportGenerator;
    private javax.swing.JLabel Sales;
    private javax.swing.JTextField TotalSales;
    private javax.swing.JMenu Users;
    private javax.swing.JLabel Welcome;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
