
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class AllocateProject extends javax.swing.JFrame {

    public AllocateProject() {
        initComponents();
        txtdate.setEditable(false);
        txtname.setEditable(false);
        txtaddress.setEditable(false);
        SimpleDateFormat dat = new SimpleDateFormat("yyyy/MM/dd");
        Date d = new Date();
        txtdate.setText(dat.format(d));
        loadEmployeeIDs();
        loadProjectIDs();
    }

    private void loadEmployeeIDs() {
        try {
            Connection con = ConnectionProvider.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT emp_id FROM employees WHERE status='Active'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                comboid.addItem(rs.getString("emp_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadEmployeeDetails() {
        String selectedEmpID = comboid.getSelectedItem().toString();
        try {
            Connection con = ConnectionProvider.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT emp_name, emp_type FROM employees WHERE emp_id=?");
            pst.setString(1, selectedEmpID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtname.setText(rs.getString("emp_name"));
                combotype.addItem(rs.getString("emp_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadProjectIDs() {
        try {
            Connection con = ConnectionProvider.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT pro_id FROM projects");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                comboproid.addItem(rs.getString("pro_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadProjectDetails() {
        String selectedProjectID = comboproid.getSelectedItem().toString();
        try {
            Connection con = ConnectionProvider.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT pro_name, pro_location FROM projects WHERE pro_id=?");
            pst.setString(1, selectedProjectID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtproname.setText(rs.getString("pro_name"));
                txtaddress.setText(rs.getString("pro_location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        comboproid = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        combotype = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtproname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboid = new javax.swing.JComboBox<>();
        h = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/checked.png"))); // NOI18N
        jLabel1.setText(" Allocate Project");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Project ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 291, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Employee ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 380, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Employee Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 380, 20));

        txtname.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnameFocusLost(evt);
            }
        });
        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnameKeyTyped(evt);
            }
        });
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 390, 30));

        comboproid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboproid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboproidFocusLost(evt);
            }
        });
        comboproid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboproidActionPerformed(evt);
            }
        });
        comboproid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboproidKeyPressed(evt);
            }
        });
        getContentPane().add(comboproid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 390, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Project Location");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 294, 20));

        txtaddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtaddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtaddressFocusLost(evt);
            }
        });
        txtaddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtaddressMouseClicked(evt);
            }
        });
        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });
        getContentPane().add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 390, 30));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Allocation Date (Today)");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 294, -1));

        txtdate.setEditable(false);
        txtdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdateActionPerformed(evt);
            }
        });
        getContentPane().add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 390, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Employee Type");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 257, 20));

        combotype.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combotype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combotypeItemStateChanged(evt);
            }
        });
        combotype.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combotypeMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                combotypeMouseReleased(evt);
            }
        });
        combotype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combotypeActionPerformed(evt);
            }
        });
        getContentPane().add(combotype, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 390, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Project Name");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 350, 30));

        txtproname.setEditable(false);
        txtproname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtproname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpronameActionPerformed(evt);
            }
        });
        getContentPane().add(txtproname, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 390, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 40, 40));

        jButton2.setBackground(new java.awt.Color(77, 24, 74));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Allocate Project");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 470, 390, 40));

        comboid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboidFocusLost(evt);
            }
        });
        comboid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboidActionPerformed(evt);
            }
        });
        comboid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboidKeyPressed(evt);
            }
        });
        getContentPane().add(comboid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 390, 30));

        h.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        h.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg-pages.jpg"))); // NOI18N
        getContentPane().add(h, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdateActionPerformed

    }//GEN-LAST:event_txtdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtname.getText().equals("") || txtaddress.getText().equals("") || txtproname.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Fields are Required");
        } else {
            String empID = comboid.getSelectedItem().toString();
            String projectID = comboproid.getSelectedItem().toString();
            String date = txtdate.getText();
            String location = txtaddress.getText();

            try {
                Connection con = ConnectionProvider.getInstance().getConnection();
                PreparedStatement pst = con.prepareStatement("INSERT INTO working_on (emp_id, pro_id, pro_allocated_on, pro_location) VALUES (?, ?, ?, ?)");
                pst.setString(1, empID);
                pst.setString(2, projectID);
                pst.setString(3, date);
                pst.setString(4, location);

                int rowsInserted = pst.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Data Inserted Successfully");
                    txtname.setText("");
                    txtaddress.setText("");
                    txtproname.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to Insert Data");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void combotypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combotypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combotypeActionPerformed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseReleased

    private void combotypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combotypeItemStateChanged
        PreparedStatement pst;
        ResultSet rs;
        try {
            Connection con = ConnectionProvider.getInstance().getConnection();
            pst = con.prepareStatement("select emp_type from room where emp_id=?");
            pst.setString(1, comboid.getItemAt(comboid.getSelectedIndex()));
            rs = pst.executeQuery();
            comboid.removeAllItems();
            while (rs.next()) {
                comboid.addItem(rs.getString("emp_id"));
            }
            pst = con.prepareStatement("select emp_salary from room where emp_id=?");
            pst.setString(1, comboid.getItemAt(comboid.getSelectedIndex()));
            rs = pst.executeQuery();
            if (rs.next()) {
                txtproname.setText(rs.getString("emp_salary"));
            }
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_combotypeItemStateChanged

    private void combotypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combotypeMouseClicked
    }//GEN-LAST:event_combotypeMouseClicked

    private void combotypeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combotypeMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_combotypeMouseReleased

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressActionPerformed

    private void txtaddressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtaddressMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressMouseClicked

    private void txtaddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtaddressFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressFocusLost

    private void txtpronameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpronameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpronameActionPerformed

    private void txtnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameKeyTyped

    private void txtnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyReleased

    }//GEN-LAST:event_txtnameKeyReleased

    private void txtnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameKeyPressed

    private void txtnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameFocusLost

    private void comboproidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboproidKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboproidKeyPressed

    private void comboproidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboproidActionPerformed
        loadProjectDetails();
    }//GEN-LAST:event_comboproidActionPerformed

    private void comboproidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboproidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_comboproidFocusLost

    private void comboidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_comboidFocusLost

    private void comboidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboidActionPerformed
        loadEmployeeDetails();
    }//GEN-LAST:event_comboidActionPerformed

    private void comboidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboidKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboidKeyPressed

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
            java.util.logging.Logger.getLogger(AllocateProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllocateProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllocateProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllocateProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AllocateProject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboid;
    private javax.swing.JComboBox<String> comboproid;
    private javax.swing.JComboBox<String> combotype;
    private javax.swing.JLabel h;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtproname;
    // End of variables declaration//GEN-END:variables
}
