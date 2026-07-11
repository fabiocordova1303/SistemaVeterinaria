package Modelo;

import java.sql.Timestamp;

public class Cliente2 {
    // Atributos correspondientes a las columnas de la tabla 'clientes'
    private int idCliente;
    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String correo;
    private Timestamp fechaRegistro; // Mapeado para el campo TIMESTAMP de la BD

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con todos los parámetros
    public Cliente(int idCliente, String dni, String nombres, String apellidos, String telefono, String direccion, String correo, Timestamp fechaRegistro) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    // Métodos Getter y Setter
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
