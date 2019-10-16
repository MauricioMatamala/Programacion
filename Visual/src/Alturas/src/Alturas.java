import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alturas {
    private JPanel panelMain;
    private JTextField txtAltura;
    private JLabel Altura;
    private JButton butAñadir;
    private JTextField txtAlturas;
    private JTextField txtMedia;
    static float[] alturas = new float[5];
    static float promedio = 0;
    private int k = 0;

    public Alturas() {
        butAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtAltura.getText().equals("")) {
                    if (k < alturas.length) {
                        alturas[k] = Float.parseFloat(txtAltura.getText());
                        k++;
                        showAlturas();
                        txtMedia.setText(String.valueOf(media()));
                        txtAltura.setText("");
                        txtAltura.grabFocus();
                        if (k == alturas.length) {
                            butAñadir.setEnabled(false);
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Alturas");
        frame.setContentPane(new Alturas().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void showAlturas() {
        String strAlturas = "";
        for (int i = 0; i < alturas.length; i++) {
            strAlturas += String.valueOf(alturas[i]);
            if (i < 4) {
                strAlturas += " - ";
            }
        }
        txtAlturas.setText(strAlturas);
    }

    private float media() {
        float mediaAlturas = 0;
        for (int i = 0; i < alturas.length; i++) {
            mediaAlturas += alturas[i];
        }
        return mediaAlturas / alturas.length;
    }
}
