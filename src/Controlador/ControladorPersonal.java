package Controlador;

import Modelo.PersonalDAO;
import Vista.ifrmPersonal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorPersonal implements ActionListener {

    private final ifrmPersonal vista;
    private final PersonalDAO dao;
    private DefaultTableModel modeloTabla;

    public ControladorPersonal(ifrmPersonal vista) {
        this.vista = vista;
        this.dao = new PersonalDAO();
        
        // Escuchar las acciones de los botones de la vista
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        
        iniciarTabla();
    }

    private void iniciarTabla() {
        modeloTabla = new DefaultTableModel(
            new Object[][] {},
            new String[] {"DNI", "Nombre Completo", "Teléfono", "Cargo", "Especialidad"}
        );
        vista.tblPersonal.setModel(modeloTabla);
        cargarDatos();
    }

    public void cargarDatos() {
        modeloTabla.setRowCount(0); // Limpia filas viejas
        ArrayList<Object[]> lista = dao.listarPersonal();
        for (Object[] fila : lista) {
            modeloTabla.addRow(fila);
        }
    }

    private void limpiarCampos() {
        vista.txtDni.setText("");
        vista.txtNombre.setText("");
        vista.txtTelefono.setText("");
        vista.cboCargo.setSelectedIndex(0); // Regresa a la primera opción
        vista.txtEspecialidad.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            String dni = vista.txtDni.getText().trim();
            String nombre = vista.txtNombre.getText().trim();
            String telf = vista.txtTelefono.getText().trim();
            String cargo = vista.cboCargo.getSelectedItem().toString();
            String espec = vista.txtEspecialidad.getText().trim();

            if (dni.isEmpty() || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "El DNI y el Nombre Completo son obligatorios.");
                return;
            }

            if (dao.registrarPersonal(dni, nombre, telf, cargo, espec)) {
                JOptionPane.showMessageDialog(vista, "¡Personal operativo registrado con éxito!");
                cargarDatos();
                limpiarCampos();
            }
        }

        if (e.getSource() == vista.btnLimpiar) {
            limpiarCampos();
        }
    }
}