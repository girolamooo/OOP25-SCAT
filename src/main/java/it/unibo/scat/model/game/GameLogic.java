package it.unibo.scat.model.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.scat.common.Direction;
import it.unibo.scat.common.EntityType;
import it.unibo.scat.common.GameResult;
import it.unibo.scat.model.game.entity.AbstractEntity;
import it.unibo.scat.model.game.entity.Invader;
import it.unibo.scat.model.game.entity.Player;
import it.unibo.scat.model.game.entity.Shot;

/**
 * Handles the game rules and updates.
 * Move entities, checks collisions, manage shots, and determinate when the,
 * game ends.
 * 
 */
@SuppressFBWarnings({ "EI2", "DMI_RANDOM_USED_ONLY_ONCE" })
public class GameLogic {
    private final GameWorld gameWorld;

    /**
     * GameLogic constructor.
     *
     * @param gWorld the game world.
     */
    public GameLogic(final GameWorld gWorld) {
        this.gameWorld = gWorld;
    }

    /**
     * Checks if every shot (player/invader shot) has hit some other entity.
     * The entities that got hit get added to a list.
     * 
     * @return the list of entities and shots engaged in every hit.
     */
    public CollisionReport checkCollisions() {
        final List<AbstractEntity> entitiesThatGotShot = new ArrayList<>();
        final List<Shot> shotList = gameWorld.getShots();

        for (final Shot shot : shotList) {
            for (final AbstractEntity entity : gameWorld.getEntities()) {
                final boolean isSameEntity = entity.equals(shot);
                final boolean isCollision = areColliding(shot, entity);
                final boolean isUselessCollision = isPlayerShot(shot) && entity instanceof Player
                        || isInvaderShot(shot) && entity instanceof Invader;

                if (isSameEntity || !isCollision || isUselessCollision) {
                    continue;
                }
                entitiesThatGotShot.add(shot);
                entitiesThatGotShot.add(entity);
            }
        }
        return new CollisionReport(entitiesThatGotShot);
    }

    /**
     * Checks if the shot is a player's shot.
     * 
     * @param shot shot that needs to be checked.
     * @return true if the shot is a player's shot, false otherwise.
     */
    private boolean isPlayerShot(final Shot shot) {
        return shot.getDirection() == Direction.UP;
    }

    /**
     * Checks if the shot is a invader's shot.
     * 
     * @param shot shot that needs to be checked.
     * @return true if the shot is a invader's shot, false otherwise.
     */

    private boolean isInvaderShot(final Shot shot) {
        return shot.getDirection() == Direction.DOWN;
    }

    /**
     * Checks if two entities (a shot and another one) are colliding.
     * 
     * @param shot the shot.
     * @param e    the entity that needs to be checked if it was hit or not.
     * @return true if there is a collision, false otherwise.
     */
    private boolean areColliding(final AbstractEntity shot, final AbstractEntity e) {
        return checkX(shot, e) && checkY(shot, e);
    }

    /**
     * Checks if the horizontal bounds (X-axis) of the shot and the target entity
     * overlap.
     * 
     * @param shot the shot.
     * @param e    the entity.
     * @return true if the two entities intersect horizontally.
     */
    private boolean checkX(final AbstractEntity shot, final AbstractEntity e) {
        return shot.getPosition().getX() < e.getPosition().getX() + e.getWidth()
                && e.getPosition().getX() < shot.getPosition().getX() + shot.getWidth();
    }

    /**
     * Checks if the vertical bounds (Y-axis) of the shot and the target entity
     * overlap.
     * 
     * @param shot the shot.
     * @param e    the entity.
     * @return true if the two entities intersect vertically.
     */
    private boolean checkY(final AbstractEntity shot, final AbstractEntity e) {
        return shot.getPosition().getY() < e.getHeight() + e.getPosition().getY()
                && e.getPosition().getY() < shot.getHeight() + shot.getPosition().getY();
    }

    /**
     * Calculates and returns the amount of points that were gained.
     * 
     * @param cr the collision report.
     * @return the points gained.
     */
    public int handleCollisionReport(final CollisionReport cr) {
        int points = 0;

        for (final AbstractEntity entity : cr.getEntities()) {
            points += entity.onHit();
        }
        return points;
    }

    /**
     * Creates the new shot onject, given the player's coordinates.
     */
    public void addPlayerShot() {
        if (!canPlayerShoot()) {
            return;
        }

        final Player player = gameWorld.getPlayer();

        final int shotWidth = 1;
        final int shotHeight = 2;
        final int shotHealth = 1;
        final int shotX = player.getPosition().getX() + (player.getWidth() / 2);
        final int shotY = player.getPosition().getY() - shotHeight;

        final Shot newShot = new Shot(EntityType.SHOT, shotX, shotY, shotWidth, shotHeight, shotHealth, Direction.UP);

        gameWorld.addEntity(newShot);

    }

    /**
     * ...
     */
    public void resetEntities() {

        removeAllShots();
        gameWorld.getEntities().forEach(x -> {
            x.reset();
        });
    }

    /**
     * @return ...
     *
     */
    public GameResult checkGameEnd() {

        if (invadersReachedBottom(gameWorld.getInvaders()) || isPlayerDead(gameWorld.getPlayer())) {
            return GameResult.INVADERS_WON;
        }
        if (!areInvadersAlive(gameWorld.getInvaders())) {
            return GameResult.PLAYER_WON;
        }
        return GameResult.STILL_PLAYING;

    }

    /**
     * @param p ...
     * @return ...
     * 
     */
    private boolean isPlayerDead(final Player p) {
        return !p.isAlive();
    }

    /**
     * @param invaders ...
     * @return ...
     * 
     */
    private boolean areInvadersAlive(final List<Invader> invaders) {
        for (final Invader x : invaders) {

            if (x.isAlive()) {
                return true;
            }

        }
        return false;
    }

    /**
     * @param invader ...
     * @return ...
     * 
     */
    private boolean invadersReachedBottom(final List<Invader> invader) {
        for (final Invader x : invader) {
            if (x.isAlive() && x.getPosition().getY() + x.getHeight() >= GameWorld.getInvaderBottomLimit()) {
                return true;
            }
        }
        return false;
    }

    /**
     * ...
     */
    public void removeAllShots() {
        gameWorld.getEntities().forEach(x -> {
            if (x instanceof Shot) {
                gameWorld.getEntities().remove(x);
            }
        });
        gameWorld.getShots().clear();
    }

    /**
     * ...
     */
    public void moveEntities() {
        for (final Invader invader : gameWorld.getInvaders()) {
            invader.move();
        }
        for (final Shot shot : gameWorld.getShots()) {
            shot.move();
        }
    }

    /**
     * @return ...
     * 
     */
    public boolean canInvadersShoot() {
        final long currTime = System.currentTimeMillis();
        return (currTime - Invader.getLastShotTime()) >= Invader.getShootingCooldown();
    }

    /**
     * ...
     */
    public void generateInvaderShot() {
        final Invader invader = getRandomInvader();

        final Shot newShot = new Shot(EntityType.SHOT, invader.getPosition().getX(), invader.getPosition().getY() + 2,
                1, 2, 1, Direction.DOWN);

        gameWorld.addEntity(newShot);
    }

    /**
     * @return ...
     * 
     */
    private Invader getRandomInvader() {
        final List<Invader> aliveInvaders = gameWorld.getInvaders().stream()
                .filter(Invader::isAlive)
                .toList();

        if (aliveInvaders.isEmpty()) {
            return null;
        }

        return aliveInvaders.get(new Random().nextInt(aliveInvaders.size()));
    }

    /**
     * ...
     */
    public void updateLastInvadersShotTime() {
        Invader.setLastShotTime(System.currentTimeMillis());
    }

    /**
     * Updates the last shot time of the player.
     */
    public void updateLastPlayerShotTime() {
        Player.setLastShotTime(System.currentTimeMillis());
    }

    /**
     * Removes the dead shots.
     */
    public void removeDeadShots() {
        for (final Shot shot : gameWorld.getShots()) {
            if (!shot.isAlive()) {
                gameWorld.removeEntity(shot);
            }
        }
    }

    /**
     * Checks if enough time has passed since the last shot of the player.
     * 
     * @return true if the player can shoot, false otherwise.
     */
    public boolean canPlayerShoot() {
        final long actualTime = System.currentTimeMillis();

        return actualTime - Player.getLastShotTime() >= Player.getShootingCooldown();
    }

    /**
     * @param direction ..
     * @return ...
     * 
     */
    public boolean canPlayerMove(final Direction direction) {

        return direction == Direction.RIGHT && canPlayerMoveRight()
                || direction == Direction.LEFT && canPlayerMoveLeft();

    }

    /**
     * @return ...
     * 
     */
    private boolean canPlayerMoveRight() {
        return gameWorld.getPlayer().getPosition().getX() + gameWorld.getPlayer().getWidth() <= GameWorld
                .getBorderRight();
    }

    /**
     * @return ...
     * 
     */
    private boolean canPlayerMoveLeft() {
        return gameWorld.getPlayer().getPosition().getX() + gameWorld.getPlayer().getWidth() >= GameWorld
                .getBorderLeft();
    }

    /**
     * Checks if the entity is completely out of border.
     * 
     * @param entity the entity.
     * @return true if the entity is out of border, false otherwise.
     */
    public boolean isOutOfBorder(final AbstractEntity entity) {
        return isOverTopBorder(entity) || isOverBottomBorder(entity) || isOverLeftBorder(entity)
                || isOverRightBorder(entity);
    }

    /**
     * Checks if the entity is completely above the top border.
     * 
     * @param entity the entity.
     * @return true if the entity is fully out of bounds (top).
     */
    private boolean isOverTopBorder(final AbstractEntity entity) {
        return entity.getPosition().getY() + entity.getHeight() < GameWorld.getBorderUp();
    }

    /**
     * Checks if the entity is completely below the bottom border.
     * 
     * @param entity the entity.
     * @return true if the entity is fully out of bounds (bottom).
     */
    private boolean isOverBottomBorder(final AbstractEntity entity) {
        return entity.getPosition().getY() > GameWorld.getBorderBottom();
    }

    /**
     * Checks if the entity is completely to the left of the game area.
     * 
     * @param entity the entity.
     * @return true if the entity is fully out of bounds (left).
     */
    private boolean isOverLeftBorder(final AbstractEntity entity) {
        return entity.getPosition().getX() + entity.getWidth() < GameWorld.getBorderLeft();
    }

    /**
     * Checks if the entity is completely to the right of the game area.
     * 
     * @param entity the entity.
     * @return true if the entity is fully out of bounds (right).
     */
    private boolean isOverRightBorder(final AbstractEntity entity) {
        return entity.getPosition().getX() > GameWorld.getBorderRight();
    }
}
