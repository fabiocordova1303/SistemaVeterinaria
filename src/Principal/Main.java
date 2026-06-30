package Principal;
import Vista.frmLogin;
public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmLogin login = new frmLogin();
                login.setLocationRelativeTo(null);
                login.setVisible(true);
            }
        });
    }
}