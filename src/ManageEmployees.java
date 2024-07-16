import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageEmployees extends javax.swing.JFrame {

    String s2;

    public ManageEmployees() {
        initComponents();
        s();
        jButton3.setVisible(false);
    }

    public void s() {
        PreparedStatement pst = null;
        Statement st = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        Connection con = null;
        try {
            con = ConnectionProvider.getInstance().getConnection();
            pst = con.prepareStatement("SELECT * FROM employees");
            rs = pst.executeQuery();
            ResultSetMetaData stData = (ResultSetMetaData) rs.getMetaData();

            int q = stData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();
                for (int i = 1; i <= q; i++) {
                    columnData.add(rs.getString("emp_id"));
                    columnData.add(rs.getString("emp_name"));
                    columnData.add(rs.getString("emp_type"));
                    columnData.add(rs.getString("emp_salary"));
                    columnData.add(rs.getString("status"));
                }
                RecordTable.addRow(columnData);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtsalary = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/manage.png"))); // NOI18N
        jLabel1.setText(" Manage Employees");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, 30, 30));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Employee Name", "Employee Type", "Employee Salary", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Employee Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 396, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Employee Type");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 396, 32));

        txtname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 396, 30));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Project Manager", "Site Supervisor", "Construction Worker", "Architect", "Civil Engineer", "Estimator" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, 396, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Employee Status");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 396, 35));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, 396, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Employee Salary");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 570, 396, 33));

        txtsalary.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtsalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsalaryActionPerformed(evt);
            }
        });
        getContentPane().add(txtsalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, 396, 30));

        jButton2.setBackground(new java.awt.Color(77, 24, 74));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(240, 240, 240));
        jButton2.setText("Add Employee");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 660, 150, 50));

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

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg-pages.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void txtsalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsalaryActionPerformed

    }//GEN-LAST:event_txtsalaryActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtname.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is Requied");
            txtname.requestFocus();
        } else if (txtsalary.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is Requied");
            txtsalary.requestFocus();
        } else {
            PreparedStatement pst = null;
            Statement st = null;
            ResultSet rs = null;
            Connection con = null;
            try {
                con = ConnectionProvider.getInstance().getConnection();
                pst = con.prepareStatement("select * from employees where emp_id=?");
                pst.setString(1, txtname.getText());
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Employee Already Exist");
                } else {
                    try {
                        double sal = Double.parseDouble(txtsalary.getText());
                        try {
                            con = ConnectionProvider.getInstance().getConnection();
                            pst = con.prepareStatement("insert into employees(emp_name,emp_type,emp_salary,status)values(?,?,?,?)");
                            pst.setString(1, txtname.getText());
                            pst.setString(2, jComboBox1.getItemAt(jComboBox1.getSelectedIndex()));
                            pst.setString(3, txtsalary.getText());
                            pst.setString(4, jComboBox2.getItemAt(jComboBox2.getSelectedIndex()));
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(this, "Employee Added");
                            s();
                            txtsalary.setText("");
                            txtname.setText("");
                        } catch (SQLException ex) {
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Salary is not valied");
                    }
                }
            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            String check = JOptionPane.showInputDialog(this, "If you want to Delete this Record, write 'delete' to confirm.\nIf you want to Update this Record, write 'update' to proceed.");
            if (check.equalsIgnoreCase("delete")) {
                DefaultTableModel dmodel = (DefaultTableModel) jTable1.getModel();
                int rows = jTable1.getSelectedRow();
                s2 = (String) dmodel.getValueAt(rows, 0);
                String s1 = (String) dmodel.getValueAt(rows, 4);
                if (s1.equalsIgnoreCase("active")) {
                    JOptionPane.showMessageDialog(this, "Unable to delete employee, Employee is currently active");
                } else {
                    PreparedStatement pst;
                    Connection con;
                    try {
                        con = ConnectionProvider.getInstance().getConnection();
                        pst = con.prepareStatement("DELETE FROM employees WHERE emp_id = ?");
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
                String empId = (String) dmodel.getValueAt(rows, 0);
                String name = (String) dmodel.getValueAt(rows, 1);
                String type = (String) dmodel.getValueAt(rows, 2);
                String sal = (String) dmodel.getValueAt(rows, 3);
                String status = (String) dmodel.getValueAt(rows, 4);
                jButton3.setVisible(true);
                jButton2.setVisible(false);
                txtname.setText(name);
                txtsalary.setText(sal);
                jComboBox1.setSelectedItem(type);
                jComboBox2.setSelectedItem(status);
                txtname.setEditable(true);

                // Set the empId value to s2 variable for later use
                s2 = empId;
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String empId = s2;
        String empName = txtname.getText();
        String empType = jComboBox1.getSelectedItem().toString();
        String status = jComboBox2.getSelectedItem().toString();
        String empSalary = txtsalary.getText();

        if (empName.isEmpty() || empType.isEmpty() || status.isEmpty() || empSalary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
        } else {
            PreparedStatement pst;
            Connection con;
            try {
                con = ConnectionProvider.getInstance().getConnection();
                pst = con.prepareStatement("UPDATE employees SET emp_name = ?, emp_type = ?, status = ?, emp_salary = ? WHERE emp_id = ?");
                pst.setString(1, empName);
                pst.setString(2, empType);
                pst.setString(3, status);
                pst.setString(4, empSalary);
                pst.setString(5, empId);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Record Updated Successfully");
                    s();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update the record.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed

    }//GEN-LAST:event_txtnameActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageEmployees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtsalary;
    // End of variables declaration//GEN-END:variables
}
