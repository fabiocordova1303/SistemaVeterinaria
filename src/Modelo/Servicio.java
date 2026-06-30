package Modelo;
public class Servicio {
    // Atributos correspondientes a las columnas de la tabla 'servicios'
    private int idServicio;
    private String nombre;
    private double precio;
    private String descripcion;
    // Constructor vacío (necesario para frameworks o instanciaciones simples)
    public Servicio() {
    }
    // Constructor con todos los parámetros
    public Servicio(int idServicio, String nombre, double precio, String descripcion) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    // Métodos Getter y Setter (Permiten leer y escribir en los atributos privados)
    public int getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
