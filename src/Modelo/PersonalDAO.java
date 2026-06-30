package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PersonalDAO {
    
    public boolean registrarPersonal(String dni, String nombre, String telefono, String cargo, String especialidad) {
        String sql = "INSERT INTO personal (dni, nombre_completo, telefono, cargo, especialidad) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, telefono);
            ps.setString(4, cargo);
            ps.setString(5, especialidad);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar personal: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Object[]> listarPersonal() {
        ArrayList<Object[]> lista = new ArrayList<>();
        String sql = "SELECT * FROM personal";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getString("dni");
                fila[1] = rs.getString("nombre_completo");
                fila[2] = rs.getString("telefono");
                fila[3] = rs.getString("cargo");
                fila[4] = rs.getString("especialidad");
                lista.add(fila);
            }
        } catch (Exception e) {
            System.out.println("Error al listar personal: " + e.getMessage());
        }
        return lista;
    }
}