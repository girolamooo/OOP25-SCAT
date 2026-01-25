package it.unibo.scat.common;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

/**
 * ...
 */
public final class UIConstants {
    // IMAGE PATHS
    public static final String[] SHIP_PATHS = {
            "/entities/player/ship1.png",
            "/entities/player/ship2.png",
            "/entities/player/ship3.png",
            "/entities/player/ship4.png",
            "/entities/player/ship5.png",
            "/entities/player/ship6.png",
    };

    // FONTS
    public static final Font TITLE_FONT;
    public static final Font TITLE_FONT_HOVER;
    public static final Font MEDIUM_FONT;
    public static final Font SMALL_FONT;

    static {
        final float titleBase = 60f;
        final float titleHover = 65f;
        final float medium = 32f;
        final float small = 20f;

        try (InputStream is = UIConstants.class.getResourceAsStream("/fonts/PressStart2P.ttf")) {

            final Font base = Font.createFont(Font.TRUETYPE_FONT, is);
            GraphicsEnvironment
                    .getLocalGraphicsEnvironment()
                    .registerFont(base);

            TITLE_FONT = base.deriveFont(titleBase);
            TITLE_FONT_HOVER = base.deriveFont(titleHover);
            MEDIUM_FONT = base.deriveFont(medium);
            SMALL_FONT = base.deriveFont(small);

        } catch (final IOException | FontFormatException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Private constructor to avoid initialization.
     */
    private UIConstants() {
    }

}
