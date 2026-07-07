package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ClienteDAO {
    
    // Método para registrar un nuevo cliente
    public boolean registrarCliente(String dni, String nombres, String apellidos, String telefono, String direccion, String correo) {
        String sql = "INSERT INTO clientes (dni, nombres, apellidos, telefono, direccion, correo) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            ps.setString(2, nombres);
            ps.setString(3, apellidos);
            ps.setString(4, telefono);
            ps.setString(5, direccion);
            ps.setString(6, correo);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Error al registrar cliente: " + e.getMessage(), 
                    "Error de Base de Datos", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Método para verificar si un cliente ya existe por su DNI (ya que es UNIQUE)
    public boolean existeCliente(String dni) {
        String sql = "SELECT dni FROM clientes WHERE dni = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Retorna true si encuentra el DNI, false si no
            }

        } catch (Exception e) {
            return false;
        }
    }
}
