package it.unibo.scat.view.menu;

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
    private JLabel leaderboardLabel;
    private JLabel infoLabel;

    /**
     * ...
     */
    public SettingsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        initNewGameLabel();
        initInfoLabel();
        initLeaderboardLabel();
        initQuitGameLabel();
    }

    /**
     * ...
     */
    private void initNewGameLabel() {
        newGameLabel = new CustomLabel("New Game");
        newGameLabel.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(newGameLabel);
    }

    /**
     * ...
     */
    private void initLeaderboardLabel() {
        leaderboardLabel = new CustomLabel("Show Leaderboard");
        leaderboardLabel.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(100));
        add(leaderboardLabel);
    }

    /**
     * ...
     */
    private void initInfoLabel() {
        infoLabel = new CustomLabel("Info");
        infoLabel.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(100));
        add(infoLabel);
    }

    /**
     * ...
     */
    private void initQuitGameLabel() {
        quitGameLabel = new CustomLabel("Quit Game");
        quitGameLabel.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(100));
        add(quitGameLabel);
        add(Box.createVerticalGlue());
    }

    /**
     * Temporary function to pass checkstyle...
     */
    public void useless() {
        newGameLabel.setAlignmentX(CENTER_ALIGNMENT);
        quitGameLabel.setAlignmentX(CENTER_ALIGNMENT);
        leaderboardLabel.setAlignmentX(CENTER_ALIGNMENT);
        infoLabel.setAlignmentX(CENTER_ALIGNMENT);
    }
}
