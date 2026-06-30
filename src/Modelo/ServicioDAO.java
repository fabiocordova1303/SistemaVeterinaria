package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ServicioDAO {
    
    public boolean registrarServicio(String nombre, double precio, String descripcion) {
        String sql = "INSERT INTO servicios (nombre, precio, descripcion) VALUES (?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setString(3, descripcion);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar servicio: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Object[]> listarServicios() {
        ArrayList<Object[]> lista = new ArrayList<>();
        String sql = "SELECT * FROM servicios";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("id_servicio");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getDouble("precio");
                fila[3] = rs.getString("descripcion");
                lista.add(fila);
            }
        } catch (Exception e) {
            System.out.println("Error al listar servicios: " + e.getMessage());
        }
        return lista;
    }
    
    // Aquí puedes añadir luego los métodos para modificar y eliminar de forma similar
}