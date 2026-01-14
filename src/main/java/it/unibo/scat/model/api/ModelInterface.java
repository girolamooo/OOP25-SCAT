package it.unibo.scat.model.api;

import it.unibo.scat.common.Direction;

/**
 * Interface for the Model class, seen from the Controller.
 */
public interface ModelInterface {

    /**
     * Adds player's shot.
     */
    void addPlayerShot();

    /**
     * @param entitiesFile    ...
     * @param leaderboardFile ...
     * 
     */
    void initEverything(String entitiesFile, String leaderboardFile);

    /**
     * ...
     */
    void update();

    /**
     * ...
     */
    void resetGame();

    /**
     * @param direction ...
     * 
     */
    void movePlayer(Direction direction);

    /**
     * ...
     */
    void endGame();

    /**
     * ...
     */
    void pauseGame();

    /**
     * ...
     */
    void resumeGame();

    /**
     * Sets player's username.
     * 
     * @param username the username that the player chose.
     */
    void setUsername(String username);
}
