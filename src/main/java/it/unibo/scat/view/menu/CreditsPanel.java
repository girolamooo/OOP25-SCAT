package it.unibo.scat.view.menu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class handles the credits panel.
 */
public final class CreditsPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    /**
     * ...
     */
    public CreditsPanel() {
        // final Color background = new Color(0, 0, 0, 150);
        // setBackground(background);

        final JLabel label = new JLabel("CREDITS PANEL!!");
        add(label);

        final JButton prova = new JButton("BACK");
        add(prova);
    }
}
