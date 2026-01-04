package it.unibo.scat.model.api;

import java.util.List;

/**
 * Read-only interface for the Model class, seen from the View.
 */
public interface ModelObservable {

    /**
     * @return ...
     * 
     */
    int getScore();

    /**
     * @return ...
     * 
     */
    List<Record> getLeaderboard();
}
