package it.unibo.scat.control.api;

/**
 * Interface for the Control class.
 */
public interface ControlInterface {

    /**
     * ...
     */
    void notifyQuitGame();

    /**
     * ...
     */
    void notifyPlayerMovement();

    /**
     * @param username ...
     * 
     */
    void notifySetUsername(String username);

    /**
     * ...
     */
    void notifyPlayerShot();

}
