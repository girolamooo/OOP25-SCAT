package it.unibo.scat.model.game;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * ...
 */
@SuppressFBWarnings(value = "UUF_UNUSED_FIELD", justification = "Fields will be used by upcoming game logic")
public class GameLogic {
    private GameWorld gameWorld;
    private int lastInvaderShotTime;
    private int invaderShootCooldown;

    /**
     * @return ...
     * 
     */
    public CollisionReport checkCollisions() {
        return null;
    }

    /**
     * @param cr ...
     * 
     */
    public void handleCollisionReport(final CollisionReport cr) {

    }

    /**
     * ...
     */
    public void addPlayerShot() {

    }

}
