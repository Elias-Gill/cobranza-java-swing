package src.gui.intercambiarPaneles;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class IntercambiarPaneles {

    public IntercambiarPaneles() {

    }

    public void modificarPanel(JPanel panelNuevo, JPanel panelViejo, int lado) {

        if (lado == 0) {// Izquierdo
            panelNuevo.setSize(303, 444);
        } else {// Derecho
            panelNuevo.setSize(600, 444);
        }
        panelViejo.removeAll();
        panelViejo.add(panelNuevo, BorderLayout.CENTER);
        panelViejo.revalidate();
        panelViejo.repaint();
    }

}
