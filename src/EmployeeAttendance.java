import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.beans.Statement;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmployeeAttendance extends javax.swing.JFrame {

    static String idd;

    public EmployeeAttendance() throws SQLException {
        initComponents();
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        txtdate.setText(d.format(date));
        s();
    }

    public void s() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con;
        int q, i;

        try {
            con = ConnectionProvider.getInstance().getConnection();
            pst = con.prepareStatement("SELECT emp_id AS 'Employee ID', emp_name AS 'Employee Name', emp_type AS 'Employee Type', emp_salary AS 'Employee Salary' FROM employees");
            rs = pst.executeQuery();
            ResultSetMetaData stData = (ResultSetMetaData) rs.getMetaData();
            q = stData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            RecordTable.setRowCount(0);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = dateFormat.format(new Date());
            while (rs.next()) {
                Vector columnData = new Vector();
                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString(i));
                }
                columnData.add(currentDate);

                String empId = rs.getString("Employee ID");
                String attendance = getAttendance(empId, currentDate);
                columnData.add(attendance);
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getAttendance(String empId, String currentDate) {
        String attendance = "";
        try {
            Connection con = ConnectionProvider.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT attendance FROM employee_attendance WHERE emp_id = ? AND date = ?");
            pst.setString(1, empId);
            pst.setString(2, currentDate);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                attendance = rs.getString("attendance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attendance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        mark_as_absent = new javax.swing.JButton();
        mark_as_present = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.lightGray);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bill.jpg"))); // NOI18N
        jLabel1.setText("Customer Details Bill");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 40, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search Attendance By Date ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 260, -1));

        txtdate.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        txtdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdateActionPerformed(evt);
            }
        });
        getContentPane().add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 220, 40));

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(240, 240, 240));
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 90, 40));

        mark_as_absent.setBackground(new java.awt.Color(77, 24, 74));
        mark_as_absent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mark_as_absent.setForeground(new java.awt.Color(255, 255, 255));
        mark_as_absent.setText("Mark As Absent");
        mark_as_absent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mark_as_absentMouseReleased(evt);
            }
        });
        mark_as_absent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mark_as_absentActionPerformed(evt);
            }
        });
        getContentPane().add(mark_as_absent, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 650, 260, 40));

        mark_as_present.setBackground(new java.awt.Color(77, 24, 74));
        mark_as_present.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mark_as_present.setForeground(new java.awt.Color(255, 255, 255));
        mark_as_present.setText("Mark As Present");
        mark_as_present.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mark_as_presentMouseReleased(evt);
            }
        });
        mark_as_present.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mark_as_presentActionPerformed(evt);
            }
        });
        getContentPane().add(mark_as_present, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 650, 260, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Employee Name", "Employee Type", "Employee Salary", "Date", "Attendance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1120, 470));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Double Click on row to Open Bill");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 400, 42));

        jButton3.setBackground(new java.awt.Color(153, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(240, 240, 240));
        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 100, 40));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg-pages.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String selectedDate = txtdate.getText(); // Assuming txtdate is the name of the text field containing the date

        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con;
        int q, i;

        try {
            con = ConnectionProvider.getInstance().getConnection();
            pst = con.prepareStatement("SELECT emp_id AS 'Employee ID', emp_name AS 'Employee Name', emp_type AS 'Employee Type', emp_salary AS 'Employee Salary' FROM employees");
            rs = pst.executeQuery();
            ResultSetMetaData stData = (ResultSetMetaData) rs.getMetaData();
            q = stData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();
                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString(i));
                }
                columnData.add(selectedDate);

                String empId = rs.getString("Employee ID");
                String attendance = getAttendance1(empId, selectedDate);
                columnData.add(attendance);
                RecordTable.addRow(columnData);
            }

            pst = con.prepareStatement("SELECT emp_id AS 'Employee ID', date AS 'Date', attendance AS 'Attendance' FROM employee_attendance WHERE date = ?");
            pst.setString(1, selectedDate);
            rs = pst.executeQuery();
            q = stData.getColumnCount();

            while (rs.next()) {
                Vector columnData = new Vector();
                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString(i));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private String getAttendance1(String empId, String selectedDate) {
        String attendance = "";
        try {
            Connection con = ConnectionProvider.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT attendance FROM employee_attendance WHERE emp_id = ? AND date = ?");
            pst.setString(1, empId);
            pst.setString(2, selectedDate);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                attendance = rs.getString("attendance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attendance;
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        s();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdateActionPerformed

    private void mark_as_absentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mark_as_absentMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_mark_as_absentMouseReleased

    private void mark_as_absentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mark_as_absentActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row from the table.");
        } else {
            String empId = jTable1.getValueAt(selectedRow, 0).toString();
            String date = jTable1.getValueAt(selectedRow, jTable1.getColumnCount() - 2).toString(); // Assuming the date column is the second-to-last column
            String attendance = "Absent";

            // Store the data in the employee_attendance table
            storeEmployeeAttendance1(empId, date, attendance);
        }
    }//GEN-LAST:event_mark_as_absentActionPerformed

    private void storeEmployeeAttendance1(String empId, String date, String attendance) {
        PreparedStatement pst = null;
        Connection con;
        try {
            con = ConnectionProvider.getInstance().getConnection();
            PreparedStatement checkPst = con.prepareStatement("SELECT attendance FROM employee_attendance WHERE emp_id = ? AND date = ?");
            checkPst.setString(1, empId);
            checkPst.setString(2, date);
            ResultSet rs = checkPst.executeQuery();
            if (rs.next()) {
                String existingAttendance = rs.getString("attendance");
                if (existingAttendance.equalsIgnoreCase("Present")) {
                    // Update the existing record from Absent to Present
                    pst = con.prepareStatement("UPDATE employee_attendance SET attendance = 'Absent' WHERE emp_id = ? AND date = ?");
                    pst.setString(1, empId);
                    pst.setString(2, date);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Attendance updated to Absent for Employee ID: " + empId);
                    s();
                } else {
                    JOptionPane.showMessageDialog(this, "Attendance already marked as " + existingAttendance + " for Employee ID: " + empId);
                }
            } else {
                pst = con.prepareStatement("INSERT INTO employee_attendance (emp_id, date, attendance) VALUES (?, ?, ?)");
                pst.setString(1, empId);
                pst.setString(2, date);
                pst.setString(3, attendance);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Attendance marked as " + attendance + " for Employee ID: " + empId);
                s();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mark_as_presentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mark_as_presentMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_mark_as_presentMouseReleased

    private void storeEmployeeAttendance(String empId, String date, String attendance) {
        PreparedStatement pst = null;
        Connection con;
        try {
            con = ConnectionProvider.getInstance().getConnection();
            PreparedStatement checkPst = con.prepareStatement("SELECT attendance FROM employee_attendance WHERE emp_id = ? AND date = ?");
            checkPst.setString(1, empId);
            checkPst.setString(2, date);
            ResultSet rs = checkPst.executeQuery();
            if (rs.next()) {
                String existingAttendance = rs.getString("attendance");
                if (existingAttendance.equalsIgnoreCase("Absent")) {
                    // Update the existing record from Absent to Present
                    pst = con.prepareStatement("UPDATE employee_attendance SET attendance = 'Present' WHERE emp_id = ? AND date = ?");
                    pst.setString(1, empId);
                    pst.setString(2, date);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Attendance updated to Present for Employee ID: " + empId);
                    s();
                } else {
                    JOptionPane.showMessageDialog(this, "Attendance already marked as " + existingAttendance + " for Employee ID: " + empId);
                }
            } else {
                pst = con.prepareStatement("INSERT INTO employee_attendance (emp_id, date, attendance) VALUES (?, ?, ?)");
                pst.setString(1, empId);
                pst.setString(2, date);
                pst.setString(3, attendance);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Attendance marked as " + attendance + " for Employee ID: " + empId);
                s();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void mark_as_presentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mark_as_presentActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row from the table.");
        } else {
            String empId = jTable1.getValueAt(selectedRow, 0).toString();
            String date = jTable1.getValueAt(selectedRow, jTable1.getColumnCount() - 2).toString(); // Assuming the date column is the second-to-last column
            String attendance = "Present";

            // Store the data in the employee_attendance table
            storeEmployeeAttendance(empId, date, attendance);
        }
    }//GEN-LAST:event_mark_as_presentActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EmployeeAttendance().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeAttendance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton mark_as_absent;
    private javax.swing.JButton mark_as_present;
    private javax.swing.JTextField txtdate;
    // End of variables declaration//GEN-END:variables
}
