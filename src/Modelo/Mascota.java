package Modelo;

public class Mascota {
    // Atributos correspondientes a las columnas de la tabla 'mascotas'
    private int idMascota;
    private int idCliente; // Llave foránea que conecta con el dueño
    private String nombre;
    private String especie;
    private String raza;
    private String sexo;   // Mapeado para el tipo ENUM('Macho','Hembra')
    private int edad;
    private double peso;   // Mapeado para el tipo DECIMAL(5,2)
    private String talla;

    // Constructor vacío
    public Mascota() {
    }

    // Constructor con todos los parámetros
    public Mascota(int idMascota, int idCliente, String nombre, String especie, String raza, String sexo, int edad, double peso, String talla) {
        this.idMascota = idMascota;
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    // Métodos Getter y Setter
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
}
