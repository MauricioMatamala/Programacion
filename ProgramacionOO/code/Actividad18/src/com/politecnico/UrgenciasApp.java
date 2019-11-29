package com.politecnico;

import com.politecnico.urgencia.SalaEsperaForm;
import javax.swing.*;
import java.awt.*;

public class UrgenciasApp {
    public static void main(String[] args) {
        SalaEspera salaEspera = new SalaEspera();

        JFrame frame = new JFrame("Urgencias");
        frame.setContentPane(new SalaEsperaForm(salaEspera).getPnlMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
