package prueba;

// @author Abeld
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Prueba {

    private static void createAndShowGUI() {
        FlatDarkLaf.setup();  //Must be called first of all Swing code as this sets the look and feel to FlatDark.

        //constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        //constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        final JPanel panel = new JPanel(); //FlowLayout.

        GridBagLayout grillaPrincipal = new GridBagLayout();

        GridBagConstraints posicion = new GridBagConstraints();

        panel.setLayout(grillaPrincipal);

        // Label Inicio de Sesion
        JLabel lblInicio = new JLabel();
        posicionGrilla(posicion, 0, 0, 0, 0);
        labels(lblInicio, "Inicio de Sesion", panel, posicion);

        // Label Documento de Identidad
        JLabel lblCIC = new JLabel();
        posicionGrilla(posicion, 1, 0, 0, 0);
        labels(lblCIC, "Documento de Identidad", panel, posicion);

        // Caja de texto documento de identidad
        JTextField txtCIC = new JTextField();
        posicionGrilla(posicion, 2, 0, 0, 0);
        textBox(txtCIC, panel, posicion);

        // Label Contraseña
        JLabel lblContrasena = new JLabel();
        posicionGrilla(posicion, 3, 0, 0, 0);
        labels(lblContrasena, "Contraseña", panel, posicion);

        // Caja de Contraseña
        JTextField boxPass = new JTextField();
        posicionGrilla(posicion, 4, 0, 0, 0);
        textBox(boxPass, panel, posicion);

// Btn de Iniciar Sesion
        JButton btn = new JButton("Iniciar Sesión");
        //constraints.gridy = 5; // El área de texto empieza en la fila cero
        //constraints.gridx = 0; // El área de texto empieza en la columna cero.
        //constraints.gridwidth = 2; // El área de texto ocupa dos columnas.
        //panel.add(btn, constraints);

        final JFrame frame = new JFrame("Bienvenido");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Genera labels
    public static void labels(JLabel label, String texto, JPanel panel, GridBagConstraints posicion) {
        label.setText(texto);
        panel.add(label, posicion);
    }

    public static void posicionGrilla(GridBagConstraints posicion, int fila, int columna, int ancho, int largo) {
        posicion.gridy = fila;
        posicion.gridx = columna;
        posicion.gridwidth = ancho; // ancho columnas.
        posicion.gridheight = largo; // largo filas.
        //return posicionGrilla;
    }

    // Genera cajas de texto
    public static void textBox(JTextField caja, JPanel panel, GridBagConstraints posicion) {
        panel.add(caja, posicion);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(Prueba::createAndShowGUI);
    }

}
