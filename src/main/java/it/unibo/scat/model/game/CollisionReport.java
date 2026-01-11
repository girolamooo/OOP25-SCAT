package it.unibo.scat.model.game;

import java.util.ArrayList;
import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.scat.model.game.entity.AbstractEntity;

/**
 * ...
 */
public class CollisionReport {
    private static final String EI_EXPOSE_REP = "EI_EXPOSE_REP";
    private final List<AbstractEntity> entities;
    private final boolean collisions;

    /**
     * @param entities ...
     * 
     */
    public CollisionReport(final List<AbstractEntity> entities) {
        this.entities = new ArrayList<>(entities);

        if (!entities.isEmpty()) {
            this.collisions = true;
        } else {
            this.collisions = false;
        }
    }

    /**
     * @return ...
     *
     */
    @SuppressFBWarnings(value = EI_EXPOSE_REP, justification = "Entities are a part of the game state, intentionally exposed")
    public List<AbstractEntity> getEntities() {
        return this.entities;
    }

    /**
     * @return ...
     *
     */
    public boolean hasCollisions() {
        return this.collisions;
    }

}
