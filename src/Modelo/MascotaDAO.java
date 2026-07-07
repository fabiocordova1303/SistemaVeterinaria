package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class MascotaDAO {

    // Método para registrar una nueva mascota asociada a un cliente
    public boolean registrarMascota(int idCliente, String nombre, String especie, String raza, String sexo, int edad, double peso, String talla) {
        String sql = "INSERT INTO mascotas (id_cliente, nombre, especie, raza, sexo, edad, peso, talla) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ps.setString(2, nombre);
            ps.setString(3, especie);
            ps.setString(4, raza);
            ps.setString(5, sexo); // Debe recibir 'Macho' o 'Hembra' según tu ENUM
            ps.setInt(6, edad);
            ps.setDouble(7, peso);
            ps.setString(8, talla);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                    "Error al registrar mascota: " + e.getMessage(), 
                    "Error de Base de Datos", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Método opcional pero muy útil: Verificar si el mismo dueño ya registró una mascota con ese nombre
    public boolean existeMascotaDeCliente(String nombreMascota, int idCliente) {
        String sql = "SELECT nombre FROM mascotas WHERE nombre = ? AND id_cliente = ?";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombreMascota);
            ps.setInt(2, idCliente);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Retorna true si el cliente ya tiene una mascota con ese nombre
            }

        } catch (Exception e) {
            return false;
        }
    }
}
