package Controlador;

import Modelo.ClienteDAO;
import Modelo.MascotaDAO;
import javax.swing.JOptionPane;

public class Controladores3y4 {

    public static void main(String[] args) {
        // 1. Instanciar los DAOs que manejan la base de datos
        ClienteDAO clienteDAO = new ClienteDAO();
        MascotaDAO mascotaDAO = new MascotaDAO();

        // =================================================================
        // PRUEBA 1: REGISTRAR UN CLIENTE
        // =================================================================
        String dniPrueba = "12345678";
        String nombreCliente = "Carlos";
        String apellidoCliente = "Mendoza";
        String telefonoCliente = "987654321";
        String direccionCliente = "Av. Las Flores 123";
        String correoCliente = "carlos.mendoza@email.com";

        System.out.println("--- Iniciando prueba de Cliente ---");
        
        // Verificamos si el cliente ya existe por su DNI
        if (clienteDAO.existeCliente(dniPrueba)) {
            JOptionPane.showMessageDialog(null, "El cliente con DNI " + dniPrueba + " ya está registrado.");
            System.out.println("El cliente ya existía en la base de datos.");
        } else {
            // Intentamos registrar al cliente
            boolean clienteRegistrado = clienteDAO.registrarCliente(
                    dniPrueba, 
                    nombreCliente, 
                    apellidoCliente, 
                    telefonoCliente, 
                    direccionCliente, 
                    correoCliente
            );

            if (clienteRegistrado) {
                JOptionPane.showMessageDialog(null, "¡Cliente registrado con éxito en la BD!");
                System.out.println("Cliente guardado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar al cliente.");
                System.out.println("Fallo en el registro del cliente.");
                return; // Detiene la ejecución si falla el cliente
            }
        }

        // =================================================================
        // PRUEBA 2: REGISTRAR UNA MASCOSTA
        // =================================================================
        System.out.println("\n--- Iniciando prueba de Mascota ---");
        
        /* NOTA IMPORTANTE: Como tu tabla 'mascotas' pide 'id_cliente' (un número INT),
          en una aplicación real primero harías un SELECT para buscar el ID generado de Carlos.
          Para esta prueba rápida, asumiremos que conocemos el ID del cliente (por ejemplo: 1).
          Asegúrate de cambiar este número por un ID que verdaderamente exista en tu tabla clientes.
        */
        int idClienteExistente = 1; 
        
        String nombreMascota = "Toby";
        String especieMascota = "Perro";
        String razaMascota = "Golden Retriever";
        String sexoMascota = "Macho"; // Recuerda que tu BD solo acepta 'Macho' o 'Hembra'
        int edadMascota = 3;
        double pesoMascota = 25.50;
        String tallaMascota = "Mediana";

        // Verificamos si este dueño ya tiene un perro llamado Toby
        if (mascotaDAO.existeMascotaDeCliente(nombreMascota, idClienteExistente)) {
            JOptionPane.showMessageDialog(null, "El cliente ya tiene una mascota registrada con el nombre: " + nombreMascota);
            System.out.println("La mascota ya se encontraba registrada para este dueño.");
        } else {
            // Intentamos registrar la mascota
            boolean mascotaRegistrada = mascotaDAO.registrarMascota(
                    idClienteExistente, 
                    nombreMascota, 
                    especieMascota, 
                    razaMascota, 
                    sexoMascota, 
                    edadMascota, 
                    pesoMascota, 
                    tallaMascota
            );

            if (mascotaRegistrada) {
                JOptionPane.showMessageDialog(null, "¡Mascota registrada con éxito en la BD!");
                System.out.println("Mascota guardada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la mascota.");
                System.out.println("Fallo en el registro de la mascota.");
            }
        }
        
        System.out.println("\n--- Pruebas finalizadas ---");
    }
}
