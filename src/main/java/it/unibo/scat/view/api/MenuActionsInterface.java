package it.unibo.scat.view.api;

/**
 * Interface for the View class, used by MenuPanel, GamePanel.
 */
public interface MenuActionsInterface {
    /**
     * ...
     */
    void showGamePanel();

    /**
     * ...
     */
    void hideGamePanel();

    /**
     * ...
     */
    void showMenuPanel();

    /**
     * ...
     */
    void hideMenuPanel();

    /**
     * @return ...
     * 
     */
    int fetchScore();
}
