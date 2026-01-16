package it.unibo.scat.model.game.entity;

import it.unibo.scat.common.EntityType;

/**
 * This class represents the "Player" entity.
 */
// @SuppressFBWarnings("SS_SHOULD_BE_STATIC")
public class Player extends AbstractEntity {
    private static final long PLAYER_SHOOTING_COOLDOWN = 500;
    private static long lastShotTime;

    /**
     * Creates a new Player entity.
     * 
     * @param type   the type of the player.
     * @param x      the initial x coordinate.
     * @param y      the initial y coordinate.
     * @param width  the witdh of the player.
     * @param height the height of the player.
     * @param health the initial health of the player.
     * 
     */
    public Player(final EntityType type, final int x, final int y, final int width, final int height,
            final int health) {
        super(type, x, y, width, height, health);
    }

    /**
     * Moves the player one unit to the left.
     */
    public void moveLeft() {
        setPosition(getPosition().getX() - 1, getPosition().getY());
    }

    /**
     * Moves the player one unit to the right.
     */
    public void moveRight() {
        setPosition(getPosition().getX() + 1, getPosition().getY());
    }

    /**
     * @return ...
     * 
     */
    public static long getLastShotTime() {
        return lastShotTime;
    }

    /**
     * @param shotTime ...
     * 
     */
    public static void setLastShotTime(final long shotTime) {
        lastShotTime = shotTime;
    }

    /**
     * @return ...
     * 
     */
    public static long getShootingCooldown() {
        return PLAYER_SHOOTING_COOLDOWN;
    }

}
