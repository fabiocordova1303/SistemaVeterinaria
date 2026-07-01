package Controlador;

//import Conexion.ConexionBD; 
import Conexion.Conexion;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO { 

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    // =========================================================================
    // REQUERIMIENTO 9: REGISTRAR CLIENTE
    // =========================================================================
    public boolean registrar(Cliente cli) {
        String sql = "INSERT INTO clientes (dni, nombres, apellidos, telefono, correo) VALUES (?, ?, ?, ?, ?)";
        try {
            con = Conexion.conectar();
            pst = con.prepareStatement(sql);

            pst.setString(1, cli.getDni());
            pst.setString(2, cli.getNombres());
            pst.setString(3, cli.getApellidos());
            pst.setString(4, cli.getTelefono());
            pst.setString(5, cli.getCorreo());

            int filasAfectadas = pst.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar cliente en el DAO: " + e.getMessage());
            return false;
        } finally {
            desconectar();
        }
    }

    // =========================================================================
    // REQUERIMIENTO 10: MODIFICAR CLIENTE
    // =========================================================================
    public boolean modificar(Cliente cli) {
        String sql = "UPDATE clientes SET nombres=?, apellidos=?, telefono=?, correo=? WHERE dni=?";
        try {
            con = Conexion.conectar();
            pst = con.prepareStatement(sql);

            pst.setString(1, cli.getNombres());
            pst.setString(2, cli.getApellidos());
            pst.setString(3, cli.getTelefono());
            pst.setString(4, cli.getCorreo());
            pst.setString(5, cli.getDni());

            int filasAfectadas = pst.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al modificar cliente en el DAO: " + e.getMessage());
            return false;
        } finally {
            desconectar();
        }
    }

    // =========================================================================
    // MÉTODO COMPLEMENTARIO: BUSCAR CLIENTE POR DNI
    // (Este es el método que solucionará tus errores en el Frm_cliente)
    // =========================================================================
    public Cliente buscarPorDni(String dni) {
        Cliente cli = null;
        String sql = "SELECT * FROM clientes WHERE dni = ?";

        try {
            con = Conexion.conectar();
            pst = con.prepareStatement(sql);
            pst.setString(1, dni);
            rs = pst.executeQuery();

            if (rs.next()) {
                cli = new Cliente();
                cli.setDni(rs.getString("dni"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setCorreo(rs.getString("correo"));
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar cliente en el DAO: " + e.getMessage());
        } finally {
            desconectar();
        }
        return cli;
    }

    // =========================================================================
    // MÉTODO AUXILIAR: CERRAR CONEXIONES (Buenas prácticas)
    // =========================================================================
    private void desconectar() {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexiones: " + e.getMessage());
        }
    }

    public java.util.List<Modelo.Cliente> listar() {
        java.util.List<Modelo.Cliente> lista = new java.util.ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try {
            con = Conexion.conectar();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Modelo.Cliente cli = new Modelo.Cliente();
                cli.setDni(rs.getString("dni"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setCorreo(rs.getString("correo"));
                lista.add(cli);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar clientes en el DAO: " + e.getMessage());
        } finally {
            desconectar();
        }

        return lista;
    }
}
