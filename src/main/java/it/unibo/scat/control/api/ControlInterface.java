package it.unibo.scat.control.api;

import it.unibo.scat.common.Direction;
import it.unibo.scat.common.GameState;

/**
 * Interface for the Control class.
 */
public interface ControlInterface {

    /**
     * @param username ...
     *
     */
    void notifySetUsername(String username);

    /**
     * ...
     */
    void notifyPlayerShot();

    /**
     * ...
     */
    void notifyQuitGame();

    /**
     * @param direction ...
     */
    void notifyPlayerMovement(Direction direction);

    /**
     * ...
     */
    void notifyStartGame();

    /**
     * ...
     */
    void notifyPauseGame();

    /**
     * ...
     */
    void notifyResumeGame();

    /**
     * ...
     */
    void notifyResetGame();

    /**
     * @return the current game state.
     * 
     */
    GameState getGameState();
}
