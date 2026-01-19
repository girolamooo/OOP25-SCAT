package it.unibo.scat.view.game;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import it.unibo.scat.view.api.MenuActionsInterface;

/**
 * Panel that contains all the graphics element for the game.
 */
public final class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private final transient MenuActionsInterface viewInterface;

    private Canvas canvas;
    private StatusBar statusBar;
    private PausePanel pausePanel;
    private GameOverPanel gameOverPanel;

    /**
     * @param viewInterface ...
     * 
     */
    public GamePanel(final MenuActionsInterface viewInterface) {
        this.viewInterface = viewInterface;

        setLayout(new BorderLayout());

        initCanvas();
        initStatusBar();
        initPausePanel();
        initGameOverPanel();
    }

    private void initCanvas() {
        canvas = new Canvas();
        add(canvas, BorderLayout.CENTER);
    }

    private void initStatusBar() {

    }

    private void initPausePanel() {

    }

    private void initGameOverPanel() {

    }

}
