package it.unibo.scat.view.menu.usernamepanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unibo.scat.view.api.MenuActionsInterface;
import it.unibo.scat.view.components.CustomTextField;

/**
 * This class handles the username panel.
 */
public final class UsernamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private final MenuActionsInterface menuActionsInterface;
    private JTextField usernameField;

    /**
     * @param menuActionsInterface ...
     * 
     */
    public UsernamePanel(final MenuActionsInterface menuActionsInterface) {
        this.menuActionsInterface = menuActionsInterface;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // setBackground(new Color(255, 255, 255, 25));
        // setBorder(new LineBorder(Color.BLACK, 10));

        initUsernameField();
        JButton a = new JButton("ewcwece");
        add(a);

    }

    /**
     * ...
     */
    private void initUsernameField() {

        usernameField = new CustomTextField();
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameField.setText("USERNAME");
        usernameField.setForeground(Color.GRAY);
        usernameField.setHorizontalAlignment(JTextField.CENTER);

        usernameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usernameField.getText().equals("USERNAME")) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isBlank()) {
                    usernameField.setText("USERNAME");
                    usernameField.setForeground(Color.GRAY);
                }
            }
        });

        add(Box.createVerticalGlue());
        add(usernameField);
        add(Box.createVerticalGlue());

    }
}
