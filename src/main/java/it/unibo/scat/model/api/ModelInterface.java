package it.unibo.scat.model.api;

/**
 * Interface for the Model class, seen from the Controller.
 */
public interface ModelInterface {

    /**
     * @param filename ...
     * 
     */
    void initEverything(String filename);

    /**
     * ...
     */
    void update();

    /**
     * ...
     */
    void generateInvaderShot();

    /**
     * @param points ...
     * 
     */
    void increaseScore(int points);

}
