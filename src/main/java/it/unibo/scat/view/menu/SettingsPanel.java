package it.unibo.scat.view.menu;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.scat.view.components.CustomLabel;

/**
 * ...
 */
public final class SettingsPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JLabel newGameLabel;
    private JLabel quitGameLabel;
    private JLabel leaderBoardLabel;
    private JLabel infoLabel;

    /**
     * ...
     */
    public SettingsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        initComponents();
    }

    /**
     * ...
     */
    private void initComponents() {
        newGameLabel = new CustomLabel("New Game");
        quitGameLabel = new CustomLabel("Quit Game");
        leaderBoardLabel = new CustomLabel("Show Leaderboard");
        infoLabel = new CustomLabel("Info");

        newGameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitGameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leaderBoardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(newGameLabel);
        add(leaderBoardLabel);
        add(infoLabel);
        add(quitGameLabel);
        add(Box.createVerticalGlue());
    }
}
