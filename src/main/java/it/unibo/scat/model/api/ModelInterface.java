package it.unibo.scat.model.api;

import it.unibo.scat.common.Direction;

/**
 * Interface for the Model class, seen from the Controller.
 */
public interface ModelInterface {

    /**
     * ...
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
     * Reset all entities throught the gameLogic and restores score and difficulty.
     */
    void resetGame();

    /**
     * Moves the plater in the given direction.
     * Gets the player from the gameWorld and updates its position.
     * 
     * @param direction the movement direction
     */
    void movePlayer(Direction direction);

    /**
     * Ends the current game.
     * Sets the game state to GAMEOVER.
     */
    void endGame();

    /**
     * Pauses the game.
     * Sets the game state to PAUSE.
     */
    void pauseGame();

    /**
     * Resumes the game.
     * Sets the game state to RUNNING.
     */
    void resumeGame();
}
