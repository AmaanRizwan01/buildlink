import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

class EmailAuthenticationStrategy implements AuthenticationStrategy {

    @Override
    public boolean authenticate(String email, String password) {
        try {
            Connection con = ConnectionProvider.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM login WHERE email = ?");
            pst.setString(1, email.toLowerCase());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "User with this email already exists");
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean authenticateLogin(String email, String password) {
        try {
            Connection con = ConnectionProvider.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM login WHERE email = ? AND password = ?");
            pst.setString(1, email.toLowerCase());
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Email or Password", "Incorrect", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean authenticateAnswer(String email, String answer) {
        try {
            Connection con = ConnectionProvider.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM login WHERE email = ?");
            pst.setString(1, email.toLowerCase());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String correctAnswer = rs.getString("ans");
                if (answer.equals(correctAnswer)) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Answer", "Incorrect", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "User with this email does not exist");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}