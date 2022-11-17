package src.gui.intercambiarPaneles;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class IntercambiarPaneles {

    public IntercambiarPaneles() {

    }

<<<<<<< HEAD
    public void modificarPanel(JPanel panelNuevo, JPanel panelViejo) {
        panelNuevo.setSize(panelViejo.getWidth(), panelViejo.getHeight());
=======
    public void modificarPanel(JPanel panelNuevo, JPanel panelViejo, int lado) {

        if (lado == 0) {// Izquierdo
            panelNuevo.setSize(303, 444);
        } else {// Derecho
            panelNuevo.setSize(600, 444);
        }
>>>>>>> bd79886b4c8dc1ddbbd12677c725fde9b1127d6a
        panelViejo.removeAll();
        panelViejo.add(panelNuevo, BorderLayout.CENTER);
        panelViejo.revalidate();
        panelViejo.repaint();
    }
<<<<<<< HEAD
=======

>>>>>>> bd79886b4c8dc1ddbbd12677c725fde9b1127d6a
}
