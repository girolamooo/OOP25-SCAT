package it.unibo.scat.view.game;

import java.awt.Image;
import java.util.List;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import it.unibo.scat.common.EntityView;
import it.unibo.scat.view.api.MenuActionsInterface;

/**
 * ...
 */
// @SuppressFBWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")

public final class Canvas extends JPanel {
    private static final long serialVersionUID = 1L;
    private final MenuActionsInterface viewInterface;
    private List<EntityView> entities;
    private Image player;
    private Image[] invader1;
    private Image[] invader2;
    private Image[] invader3;
    private Image[] invader4;
    private Image[] bunker;
    private Image[] shot;

    /**
     * ...
     */
    public Canvas(final MenuActionsInterface viewInterface) {
        this.viewInterface = viewInterface;

        invader1 = new Image[2];
        invader2 = new Image[2];
        invader3 = new Image[2];
        invader4 = new Image[2];
        bunker = new Image[3];
        shot = new Image[2];
        player = null;

        // entities =

        initImages();
    }

    /**
     * ...
     */
    private void initImages() {
        // PLAYER
        player = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/player.png"))).getImage();

        // SHOTS
        shot[0] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/shots/player_shot.png"))).getImage();
        shot[1] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/shots/invader_shot.png"))).getImage();

        // BUNKERS
        bunker[0] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/bunkers/bunker1.png"))).getImage();
        bunker[1] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/bunkers/bunker2.png"))).getImage();
        bunker[2] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/bunkers/bunker3.png"))).getImage();

        // INVADERS
        invader1[0] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/invaders/invader_1_1.png"))).getImage();
        invader1[1] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/invaders/invader_1_2.png"))).getImage();

        invader2[0] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/invaders/invader_2_1.png"))).getImage();
        invader2[1] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/invaders/invader_2_2.png"))).getImage();

        invader3[0] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/invaders/invader_3_1.png"))).getImage();
        invader3[1] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/invaders/invader_3_2.png"))).getImage();

        invader4[0] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/invaders/invader_4_1.png"))).getImage();
        invader4[1] = new ImageIcon(
                Objects.requireNonNull(getClass().getResource("/entities/invaders/invader_4_2.png"))).getImage();
    }

}
