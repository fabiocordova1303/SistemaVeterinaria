package Modelo;

public class Personal {
    // Atributos correspondientes a la tabla 'personal'
    private String dni;
    private String nombreCompleto;
    private String telefono;
    private String cargo; // Guardará "Veterinario" o "Técnico"
    private String especialidad;

    // Constructor vacío
    public Personal() {
    }

    // Constructor con todos los parámetros
    public Personal(String dni, String nombreCompleto, String telefono, String cargo, String especialidad) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.cargo = cargo;
        this.especialidad = especialidad;
    }

    // Métodos Getter y Setter
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
