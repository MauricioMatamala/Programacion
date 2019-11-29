package com.politecnico.urgencia;

import com.politecnico.Paciente;
import com.politecnico.SalaEspera;
import com.politecnico.SalaEsperaChangeListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

public class SalaEsperaForm {
    private JButton btnSiguiente;
    private JTextField txtNombre;
    private JComboBox cmbEspecialidades;
    private JButton btnNuevoPaciente;
    private JList lstPacientes;
    private JCheckBox chkPrioridad;
    private JTextField txtDNI;
    private JTextField txtEdad;
    private JTextField txtSiguiente;
    private JPanel pnlMain;

    SalaEspera salaEspera;

    public SalaEsperaForm(SalaEspera salaEspera){
        cargarEspecialidadesEnComboBox();
        this.salaEspera = salaEspera;
        salaEspera.setSalaEsperaChangeListener(ON_NUEVO_PACIENTE_ACTUALIZAR_LISTA_ESPERA);

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UrgenciaMedica siguienteUrgencia = salaEspera.siguienteUrgencia();
                if (siguienteUrgencia != null)
                    txtSiguiente.setText(siguienteUrgencia.toString());
                else
                    txtSiguiente.setText("");
            }
        });

        btnNuevoPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Paciente paciente = new Paciente(txtNombre.getText(),txtDNI.getText(),Integer.parseInt(txtEdad.getText()));
                int especialidad = Especialidades.getIdEspecialidadPorNombre((String)cmbEspecialidades.getSelectedItem());
                UrgenciaMedica urgencia = UrgenciaMedicaFactory.createUrgenciaMedica(especialidad);
                urgencia.setPaciente(paciente);
                if (chkPrioridad.isSelected()) {
                    urgencia.setNivelDeUrgencia(0);
                    chkPrioridad.setSelected(false);
                }
                salaEspera.addUrgenciaMedica(urgencia);
            }
        });
    }

    private void cargarEspecialidadesEnComboBox() {
        Map<Integer,String> especialidades = Especialidades.getNombresEspecialidades();
        Iterator<Integer> it = especialidades.keySet().iterator();
        while (it.hasNext())
            cmbEspecialidades.addItem(especialidades.get(it.next()));
    }

    public JPanel getPnlMain(){
        return pnlMain;
    }

    public SalaEsperaChangeListener ON_NUEVO_PACIENTE_ACTUALIZAR_LISTA_ESPERA = new SalaEsperaChangeListener(){
        @Override
        public void onChangeDo() {
            lstPacientes.removeAll();
            DefaultListModel listModel = new DefaultListModel<>();
            listModel.addAll(salaEspera.getColaEspera());
            lstPacientes.setModel(listModel);
        }
    };
}
