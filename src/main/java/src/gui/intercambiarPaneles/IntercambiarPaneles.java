package src.gui.intercambiarPaneles;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class IntercambiarPaneles {

    public IntercambiarPaneles() {

    }

    public void modificarPanel(JPanel panelNuevo, JPanel panelViejo) {
        panelNuevo.setSize(panelViejo.getWidth(), panelViejo.getHeight());
        panelViejo.removeAll();
        panelViejo.add(panelNuevo, BorderLayout.CENTER);
        panelViejo.revalidate();
        panelViejo.repaint();
    }
}
