package it.unibo.scat.model.api;

import java.util.List;

import it.unibo.scat.common.EntityView;

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
    List<EntityView> getEntities();

    /**
     * @return ...
     * 
     */
    List<Record> getLeaderboard();
  
    /**
     * @return ...
     * 
     */
    String getUsername();
}
