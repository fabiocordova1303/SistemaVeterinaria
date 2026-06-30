package Controlador;

import Modelo.ServicioDAO;
import Vista.ifrmServicios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorServicio implements ActionListener {
    
    private final ifrmServicios vista;
    private final ServicioDAO dao;
    private DefaultTableModel modeloTabla;

    public ControladorServicio(ifrmServicios vista) {
        this.vista = vista;
        this.dao = new ServicioDAO();
        
        // Escuchar las acciones de los botones de la vista
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        
        iniciarTabla();
    }

    private void iniciarTabla() {
        modeloTabla = new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Servicio", "Precio", "Descripción"}
        );
        vista.tblServicios.setModel(modeloTabla);
        cargarDatos();
    }

    public void cargarDatos() {
        modeloTabla.setRowCount(0); // Limpia filas viejas
        ArrayList<Object[]> lista = dao.listarServicios();
        for (Object[] fila : lista) {
            modeloTabla.addRow(fila);
        }
    }

    private void limpiarCampos() {
        vista.txtIdServicio.setText("");
        vista.txtNombre.setText("");
        vista.txtPrecio.setText("");
        vista.txaDescripcion.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            String nombre = vista.txtNombre.getText().trim();
            String precioStr = vista.txtPrecio.getText().trim();
            String desc = vista.txaDescripcion.getText().trim();

            if (nombre.isEmpty() || precioStr.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor, complete los campos obligatorios.");
                return;
            }

            try {
                double precio = Double.parseDouble(precioStr);
                if (dao.registrarServicio(nombre, precio, desc)) {
                    JOptionPane.showMessageDialog(vista, "¡Servicio registrado con éxito!");
                    cargarDatos();
                    limpiarCampos();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "El precio debe ser un número decimal válido (ej: 45.00).");
            }
        }
        
        if (e.getSource() == vista.btnLimpiar) {
            limpiarCampos();
        }
    }
}
