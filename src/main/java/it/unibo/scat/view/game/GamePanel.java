package it.unibo.scat.view.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JPanel;

import it.unibo.scat.view.api.MenuActionsInterface;
import it.unibo.scat.view.game.api.GamePanelInterface;

/**
 * Panel that contains all the graphics element for the game.
 */
public final class GamePanel extends JPanel implements GamePanelInterface {
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
        statusBar = new StatusBar(this);
        statusBar.setPreferredSize(new Dimension(0, 100));
        add(statusBar, BorderLayout.NORTH);
    }

    public Dimension computeBestFrameSize(final Rectangle maxWindowBounds, final Insets ins) {
        final double aspect = 59.0 / 36.0;

        final int wMax = maxWindowBounds.width - ins.left - ins.right;
        final int hMax = maxWindowBounds.height - ins.top - ins.bottom;

        final int barH = statusBar.getPreferredSize().height;

        final int canvasH = Math.min(hMax - barH, (int) Math.floor(wMax / aspect));
        final int canvasW = (int) Math.floor(canvasH * aspect);

        return new Dimension(
                canvasW + ins.left + ins.right,
                canvasH + barH + ins.top + ins.bottom);
    }

    private void initPausePanel() {

    }

    private void initGameOverPanel() {

    }

    @Override
    public void pause() {
        viewInterface.pauseGame();
    }

    @Override
    public void resume() {
        viewInterface.resumeGame();
    }

}
