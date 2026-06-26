package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection conectar() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bd_veterinaria",
                "root",
                ""
            );

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return con;
    }
}