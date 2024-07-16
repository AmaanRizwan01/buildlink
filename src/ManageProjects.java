import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.beans.Statement;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageProjects extends javax.swing.JFrame {
    double pri;
    String s2;
    public ManageProjects() {
        initComponents();
        s();
        jButton3.setVisible(false);
        jButton2.setVisible(true);
    }

    public void s() {
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = null;
        int q, i;
        try {
            con = ConnectionProvider.getInstance().getConnection();
            pst = con.prepareStatement("Select * from projects");
            rs = pst.executeQuery();
            ResultSetMetaData stData = (ResultSetMetaData) rs.getMetaData();
            q = stData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            RecordTable.setRowCount(0);
            while (rs.next()) {
                Vector columnData = new Vector();
                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString("pro_id"));
                    columnData.add(rs.getString("pro_name"));
                    columnData.add(rs.getString("pro_location"));
                    columnData.add(rs.getString("budget"));
                    columnData.add(rs.getString("status"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtlocation = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtbudget = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/manage.png"))); // NOI18N
        jLabel1.setText(" Manage Projects");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 50));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Project ID", "Project Name", "Project Location", "Project Budget", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 1010, 370));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, 30, 30));

        txtlocation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtlocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlocationActionPerformed(evt);
            }
        });
        getContentPane().add(txtlocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 530, 396, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Project Location");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, 396, 33));

        txtname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, 396, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Project Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 396, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Double Click on rows for update & Delete");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 670, 410, 32));

        jButton3.setBackground(new java.awt.Color(77, 24, 74));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 660, 120, 50));

        jButton2.setBackground(new java.awt.Color(77, 24, 74));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(240, 240, 240));
        jButton2.setText("Add Project");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 660, 150, 50));

        txtbudget.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtbudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbudgetActionPerformed(evt);
            }
        });
        getContentPane().add(txtbudget, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, 396, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Project Budget");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, 396, 33));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg-pages.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            String check = JOptionPane.showInputDialog(this, "If you want to Delete this Record, write 'delete' to confirm.\nIf you want to Update this Record, write 'update' to proceed.");
            if (check.equalsIgnoreCase("delete")) {
                DefaultTableModel dmodel = (DefaultTableModel) jTable1.getModel();
                int rows = jTable1.getSelectedRow();
                s2 = (String) dmodel.getValueAt(rows, 0);
                String s1 = (String) dmodel.getValueAt(rows, 4);
                if (s1.equalsIgnoreCase("Active")) {
                    JOptionPane.showMessageDialog(this, "Unable to delete Project, Project is currently active");
                } else {
                    PreparedStatement pst;
                    Connection con;
                    try {
                        con = ConnectionProvider.getInstance().getConnection();
                        pst = con.prepareStatement("DELETE FROM projects WHERE pro_id = ?");
                        pst.setString(1, s2);
                        pst.executeUpdate();
                        s();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (check.equalsIgnoreCase("update")) {
                DefaultTableModel dmodel = (DefaultTableModel) jTable1.getModel();
                int rows = jTable1.getSelectedRow();
                String proID = (String) dmodel.getValueAt(rows, 0);
                String name = (String) dmodel.getValueAt(rows, 1);
                String location = (String) dmodel.getValueAt(rows, 2);
                String budget = (String) dmodel.getValueAt(rows, 3);
                jButton3.setVisible(true);
                jButton2.setVisible(false);
                txtname.setText(name);
                txtlocation.setText(location);
                txtbudget.setText(budget);
                txtname.setEditable(true);
                s2 = proID;
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed

    }//GEN-LAST:event_txtnameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String proID = s2;
        String proName = txtname.getText();
        String proLocation = txtlocation.getText();
        String proBudget = txtbudget.getText();

        if (proName.isEmpty() || proLocation.isEmpty() || proBudget.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
        } else {
            PreparedStatement pst;
            Connection con;
            try {
                con = ConnectionProvider.getInstance().getConnection();
                pst = con.prepareStatement("UPDATE projects SET pro_name = ?, pro_location = ?, budget = ? WHERE pro_id = ?");
                pst.setString(1, proName);
                pst.setString(2, proLocation);
                pst.setString(3, proBudget);
                pst.setString(4, proID);
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Record Updated Successfully");
                    s();
                    txtname.setText("");
                    txtlocation.setText("");
                    txtbudget.setText("");
                    jButton3.setVisible(false);
                    jButton2.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update the record.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtname.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is Requied");
            txtname.requestFocus();
        } else if (txtlocation.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is Requied");
            txtlocation.requestFocus();
        } else {
            PreparedStatement pst = null;
            Statement st = null;
            ResultSet rs = null;
            Connection con = null;
            try {
                con = ConnectionProvider.getInstance().getConnection();
                pst = con.prepareStatement("select * from projects where pro_id=?");
                pst.setString(1, s2);
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Employee Already Exist");
                } else {
                    try {
                        double sal = Double.parseDouble(txtlocation.getText());
                        try {
                            con = ConnectionProvider.getInstance().getConnection();
                            pst = con.prepareStatement("insert into projects(pro_name,pro_location,budget,status)values(?,?,?,?)");
                            pst.setString(1, txtname.getText());
                            pst.setString(2, txtlocation.getText());
                            pst.setString(3, txtbudget.getText());
                            pst.setString(4, "Active");
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(this, "Project Added");
                            s();
                            txtlocation.setText("");
                            txtname.setText("");
                            txtbudget.setText("");
                        } catch (SQLException ex) {
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Invalid Type");
                    }
                }
            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtlocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlocationActionPerformed

    }//GEN-LAST:event_txtlocationActionPerformed

    private void txtbudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbudgetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbudgetActionPerformed

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
            java.util.logging.Logger.getLogger(ManageProjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageProjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageProjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageProjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageProjects().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtbudget;
    private javax.swing.JTextField txtlocation;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
