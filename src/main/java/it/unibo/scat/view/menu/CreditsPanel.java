package it.unibo.scat.view.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.scat.util.AudioManager;
import it.unibo.scat.util.AudioTrack;
import it.unibo.scat.view.menu.api.MenuPanelInterface;

/**
 * This class handles the credits panel.
 */
@SuppressFBWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")

public final class CreditsPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int TITLE_SPACING = 10;
    private static final int BOTTOM_SPACING = 10;
    private static final int SPACING_NAMES = 5;
    private static final int TOP_MARGIN = 10;
    private static final String CALIBRI = "Calibri";

    private static final Font FONT_TITLE = new Font(CALIBRI, Font.BOLD, 40);
    private static final Font FONT_INFO = new Font(CALIBRI, Font.BOLD, 20);
    private static final Font FONT_BUTTON = new Font(CALIBRI, Font.BOLD, 30);
    private static final Font FONT_STORY = new Font(CALIBRI, Font.ITALIC, 18);

    private final transient MenuPanelInterface menuInterface;
    private final transient AudioManager soundEffect;

    /**
     * @param mInterface ...
     * 
     */
    public CreditsPanel(final MenuPanelInterface mInterface) {
        this.menuInterface = mInterface;
        this.soundEffect = new AudioManager();

        setLayout(new BorderLayout());
        setOpaque(false);

        add(createCredits(), BorderLayout.CENTER);
        initBackButton();
    }

    /**
     * Creates and returns the credits panel.
     * 
     * @return the credits panel.
     */
    private JPanel createCredits() {
        final JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(Box.createVerticalGlue());
        p.setOpaque(false);

        addCustomLabel(p, "CREDITS PANEL", FONT_TITLE);

        p.add(Box.createVerticalStrut(TITLE_SPACING));

        addCustomLabel(p, "Tribute to the original 'Space Invaders', the legendary game", FONT_STORY);
        addCustomLabel(p, "designed by Tomohiro Nishikado and released by Taito in 1978.", FONT_STORY);
        addCustomLabel(p, "A global phenomenon of the late 70s, it sold over 360,000 arcade cabinets", FONT_STORY);
        addCustomLabel(p, "and grossed billions worldwide.", FONT_STORY);

        addCustomLabel(p,
                "This remake was developed as a project for the OOP course at the University of Bologna.",
                FONT_STORY);

        addCustomLabel(p, "Credits to:", FONT_STORY);

        p.add(Box.createVerticalStrut(BOTTOM_SPACING));
        addCustomLabel(p, "GIROLAMO RONZONI - girolamo.ronzoni@studio.unibo.it", FONT_INFO);

        p.add(Box.createVerticalStrut(BOTTOM_SPACING));

        addCustomLabel(p, "LEONARDO LIOI - leonardo.lioi@studio.unibo.it", FONT_INFO);

        p.add(Box.createVerticalStrut(BOTTOM_SPACING));

        addCustomLabel(p, "MARIO LUNGU - mario.lungu@studio.unibo.it", FONT_INFO);

        p.add(Box.createVerticalStrut(BOTTOM_SPACING));

        p.add(Box.createVerticalGlue());

        return p;
    }

    /**
     * ...
     */
    private void initBackButton() {
        final String defaultText = "BACK";
        final String hoverText = "> BACK";
        final JLabel backLabel = new JLabel(defaultText);
        backLabel.setFont(FONT_BUTTON);
        backLabel.setForeground(Color.WHITE);
        backLabel.setAlignmentX(CENTER_ALIGNMENT);
        backLabel.setAlignmentX(CENTER_ALIGNMENT);

        backLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                menuInterface.showSettingsPanel();
                soundEffect.play(AudioTrack.OPTION_SELECTED, false);
            }

            @Override
            public void mouseEntered(final MouseEvent e) {
                backLabel.setText(hoverText);
                backLabel.setForeground(Color.RED);
                backLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                soundEffect.play(AudioTrack.MOUSE_OVER, false);
            }

            @Override
            public void mouseExited(final MouseEvent e) {
                backLabel.setText(defaultText);
                backLabel.setForeground(Color.WHITE);
                backLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        add(backLabel, BorderLayout.SOUTH);
    }

    /**
     * Creates labels similar to CustomLabel.
     *
     * @param target ...
     * @param text   ...
     * @param font   ...
     */
    private void addCustomLabel(final JPanel target, final String text, final Font font) {
        final JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        label.setAlignmentX(CENTER_ALIGNMENT);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(final MouseEvent e) {
                label.setForeground(Color.LIGHT_GRAY);
                soundEffect.play(AudioTrack.MOUSE_OVER, false);
            }

            @Override
            public void mouseExited(final MouseEvent e) {
                label.setForeground(Color.WHITE);
            }
        });
        target.add(label);
        target.add(Box.createVerticalStrut(SPACING_NAMES));
    }
}
