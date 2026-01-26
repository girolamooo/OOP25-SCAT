package it.unibo.scat.view.menu.usernamepanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.scat.common.UIConstants;
import it.unibo.scat.view.api.MenuActionsInterface;
import it.unibo.scat.view.components.CustomButton;
import it.unibo.scat.view.components.CustomTextField;

/**
 * This class handles the username panel.
 */
public final class UsernamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final String USERNAME = "USERNAME";
    private final transient MenuActionsInterface menuActionsInterface;

    /**
     * @param menuActionsInterface ...
     * 
     */
    @SuppressFBWarnings("EI_EXPOSE_REP")
    public UsernamePanel(final MenuActionsInterface menuActionsInterface) {
        this.menuActionsInterface = menuActionsInterface;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // setBackground(new Color(255, 255, 255, 25));
        // setBorder(new LineBorder(Color.BLACK, 10));

        initUsernameField();
        initButtonsWrapper();
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

        add(Box.createVerticalGlue());
        add(usernameField);
    }

    /**
     * ...
     */
    private void initButtonsWrapper() {
        final JPanel buttonsWrapper = new JPanel();
        buttonsWrapper.setBackground(Color.GREEN);
        buttonsWrapper.setLayout(new GridLayout(2, 3, 10, 10));

        final int buttonsCounter = 6;
        final JButton[] buttons = new JButton[buttonsCounter];

        for (int i = 0; i < buttonsCounter; i++) {
            final int index = i;
            final int size = 80;
            final Dimension d = new Dimension(size, size);

            buttons[i] = new CustomButton(UIConstants.SHIP_PATHS.get(i), d);

            buttons[i].addActionListener(e -> {
                menuActionsInterface.setChosenShipIndex(index);
            });

            buttonsWrapper.add(buttons[i]);
        }

        // add(Box.createVerticalStrut(40));
        add(buttonsWrapper);
        add(Box.createVerticalGlue());
    }
}
