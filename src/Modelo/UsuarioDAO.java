package Modelo;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    // Método para registrar usuario
    public boolean registrarUsuario(String nombre, String user, String pass, String rol) {
        String sql =
    "INSERT INTO usuarios(nombre_completo, username, password, rol, activo) " +
    "VALUES (?, ?, ?, ?, ?)";

    try(Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, nombre);
        ps.setString(2, user);
        ps.setString(3, pass);
        ps.setString(4, rol);
        ps.setBoolean(5, true);

        ps.executeUpdate();

        return true;

    } catch(Exception e) {

        JOptionPane.showMessageDialog(null,
                "Error al registrar: " + e.getMessage());

        return false;
    }
    }
    // Método para validar login
    public boolean validarLogin(String user, String pass) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ? AND activo = 1";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, user);
            ps.setString(2, pass);
            
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Si devuelve true, el usuario existe
            
        } catch (Exception e) {
            return false;
        }
    }
    public boolean existeUsuario(String user) {

    String sql = "SELECT username FROM usuarios WHERE username = ?";

    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, user);

        ResultSet rs = ps.executeQuery();

        return rs.next();

    } catch (Exception e) {

        return false;
    }
}
}