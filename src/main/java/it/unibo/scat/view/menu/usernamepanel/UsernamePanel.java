package it.unibo.scat.view.menu.usernamepanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.scat.common.UIConstants;
import it.unibo.scat.view.api.MenuActionsInterface;
import it.unibo.scat.view.components.CustomTextField;

/**
 * This class handles the username panel.
 */
public final class UsernamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final String USERNAME = "USERNAME";
    private static final int VERTICAL_SPACE = 40;
    private final transient MenuActionsInterface menuActionsInterface;

    /**
     * @param menuActionsInterface ...
     * 
     */
    @SuppressFBWarnings("EI_EXPOSE_REP")
    public UsernamePanel(final MenuActionsInterface menuActionsInterface) {
        this.menuActionsInterface = menuActionsInterface;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(UIConstants.PANELS_BG_COLOR);
        setBorder(new LineBorder(Color.BLACK, 10));

        initUsernameText();
        initUsernameField();
        initShipText();
        initButtonsWrapper();
    }

    /**
     * ...
     */
    private void initUsernameText() {
        final JLabel label = new JLabel("ENTER USERNAME");
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setFont(UIConstants.TITLE_FONT);
        label.setFocusable(false);
        label.setForeground(Color.GREEN);

        add(Box.createVerticalGlue());
        add(label);
    }

    /**
     * ...
     */
    private void initUsernameField() {
        final CustomTextField usernameField = new CustomTextField();
        usernameField.setAlignmentX(CENTER_ALIGNMENT);
        usernameField.setText(USERNAME);
        usernameField.setForeground(Color.GRAY);
        usernameField.setHorizontalAlignment(JTextField.CENTER);

        usernameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent e) {
                if (USERNAME.equals(usernameField.getText())) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(final FocusEvent e) {
                if (usernameField.getText().isBlank()) {
                    usernameField.setText(USERNAME);
                    usernameField.setForeground(Color.GRAY);
                }
            }
        });

        add(Box.createVerticalStrut(VERTICAL_SPACE));
        add(usernameField);
    }

    /**
     * ...
     */
    private void initShipText() {
        final JLabel label = new JLabel("CHOOSE SHIP");
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setFont(UIConstants.TITLE_FONT);
        label.setFocusable(false);
        label.setForeground(Color.GREEN);

        add(Box.createVerticalGlue());
        add(label);
    }

    /**
     * ...
     */
    private void initButtonsWrapper() {
        final ButtonsWrapper buttonsWrapper = new ButtonsWrapper(menuActionsInterface);
        buttonsWrapper.setOpaque(false);

        final int width = 400;
        final int height = width * 2 / 3;
        final Dimension d = new Dimension(width, height);
        buttonsWrapper.setPreferredSize(d);
        buttonsWrapper.setMinimumSize(d);
        buttonsWrapper.setMaximumSize(d);

        add(Box.createVerticalStrut(VERTICAL_SPACE));
        add(buttonsWrapper);
        add(Box.createVerticalGlue());
    }
}
