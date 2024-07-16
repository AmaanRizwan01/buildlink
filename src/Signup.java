
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Signup extends javax.swing.JFrame {

    int flag = 0;
    private AuthenticationStrategy authenticationStrategy;

    public Signup() {
        initComponents();
        jPanel1.setBackground(new Color(51, 51, 51, 200));
        authenticationStrategy = new EmailAuthenticationStrategy();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtname = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtemail = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtans = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 50, 49));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnameKeyPressed(evt);
            }
        });
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 320, -1));

        jButton2.setBackground(new java.awt.Color(77, 24, 74));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back To Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, -1, 30));

        txtemail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtemailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtemailKeyReleased(evt);
            }
        });
        jPanel1.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 320, -1));

        txtpassword.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 280, -1));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Your Favourite Game", "Your Favourite Bike", "Your Favourite City", "Your Favourite Book", "Your Favourite Phone" }));
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 320, -1));

        txtans.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtansActionPerformed(evt);
            }
        });
        txtans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtansKeyPressed(evt);
            }
        });
        jPanel1.add(txtans, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 320, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Signup");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 80));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 151, -1));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 151, 20));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 151, 20));

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Security Question");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 20));

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Answer");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 151, 20));

        jButton1.setBackground(new java.awt.Color(77, 24, 74));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Signup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 140, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eye_icon.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, -1, 30));

        lblemail.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(lblemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 240, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 410, 520));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("B U I L D  L I N K");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 270, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/start-bgSDA.jpeg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtansActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int yes = JOptionPane.showConfirmDialog(this, "Are You Sure?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (yes == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtname.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is required");
            txtname.requestFocus();
        } else if (txtemail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is required");
            txtemail.requestFocus();
        } else if (txtpassword.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is required");
            txtpassword.requestFocus();
        } else if (txtans.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All Field is required");
            txtans.requestFocus();
        } else {
            try {
                String email = txtemail.getText();
                String password = txtpassword.getText();
                boolean authenticated = authenticationStrategy.authenticate(email, password);

                if (authenticated) {
                    Connection con = ConnectionProvider.getInstance().getConnection();
                    PreparedStatement pst = con.prepareStatement("SELECT * FROM login WHERE email = ?");
                    pst.setString(1, email);
                    ResultSet rs = pst.executeQuery();
                    pst = con.prepareStatement("INSERT INTO login (name, email, password, sq, ans) VALUES (?, ?, ?, ?, ?)");
                    pst.setString(1, txtname.getText());
                    pst.setString(2, email.toLowerCase());
                    pst.setString(3, password);
                    pst.setString(4, jComboBox1.getItemAt(jComboBox1.getSelectedIndex()));
                    pst.setString(5, txtans.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Registered Successfully\nLogin Now");
                    new SignIn().setVisible(true);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new SignIn().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtansKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtansKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtname.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "All Field is required");
                txtname.requestFocus();
            } else if (txtemail.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "All Field is required");
                txtemail.requestFocus();
            } else if (txtpassword.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "All Field is required");
                txtpassword.requestFocus();
            } else if (txtans.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "All Field is required");
                txtans.requestFocus();
            } else {
                try {
                    String email = txtemail.getText();
                    String password = txtpassword.getText();
                    boolean authenticated = authenticationStrategy.authenticate(email, password);

                    if (authenticated) {
                        Connection con = ConnectionProvider.getInstance().getConnection();
                        PreparedStatement pst = con.prepareStatement("SELECT * FROM login WHERE email = ?");
                        pst.setString(1, email);
                        ResultSet rs = pst.executeQuery();
                        pst = con.prepareStatement("INSERT INTO login (name, email, password, sq, ans) VALUES (?, ?, ?, ?, ?)");
                        pst.setString(1, txtname.getText());
                        pst.setString(2, email.toLowerCase());
                        pst.setString(3, password);
                        pst.setString(4, jComboBox1.getItemAt(jComboBox1.getSelectedIndex()));
                        pst.setString(5, txtans.getText());
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Registered Successfully\nLogin Now");
                        new SignIn().setVisible(true);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_txtansKeyPressed

    private void txtnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtemail.requestFocus();
        }
    }//GEN-LAST:event_txtnameKeyPressed

    private void txtemailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtpassword.requestFocus();
        }
    }//GEN-LAST:event_txtemailKeyPressed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBox1.requestFocus();
        }
    }//GEN-LAST:event_txtpasswordKeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtans.requestFocus();
        }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        if (flag == 0) {
            jLabel9.setIcon(new ImageIcon("C:\\Users\\Sudhir\\OneDrive\\Pictures\\Documents\\NetBeansProjects\\Hotel Management System\\src\\s.png"));
            flag = 1;
            txtpassword.setEchoChar((char) 0);
        } else {
            jLabel9.setIcon(new ImageIcon("C:\\Users\\Sudhir\\OneDrive\\Pictures\\Documents\\NetBeansProjects\\Hotel Management System\\src\\h.png"));
            flag = 0;
            txtpassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txtemailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyReleased
        txtemail.setText(txtemail.getText().toLowerCase());

        int a = txtemail.getText().indexOf('@');
        int b = txtemail.getText().length();

        if (a == -1) {
            lblemail.setText("Invalid Email ID");
        } else if (b > a + 1) {
            String s = txtemail.getText();
            String[] splitString = s.split("@");
            if (splitString[1].equalsIgnoreCase("gmail.com")) {
                lblemail.setText("");
                txtpassword.requestFocus();
            } else {
                lblemail.setText("Invalid Email ID");
            }
        }
        if (txtemail.getText().equals("")) {
            lblemail.setText("");
        }
    }//GEN-LAST:event_txtemailKeyReleased

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblemail;
    private javax.swing.JTextField txtans;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
