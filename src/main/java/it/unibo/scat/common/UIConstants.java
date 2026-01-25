package it.unibo.scat.common;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

public final class UIConstants {

    // FONTS
    public final static Font TITLE_FONT;
    public final static Font TITLE_FONT_HOVER;

    public final static Font MEDIUM_FONT;
    public final static Font SMALL_FONT;
    // public final static Font TITLE_HOVER_FONT;

    static {
        try (InputStream is = UIConstants.class.getResourceAsStream("/fonts/PressStart2P.ttf")) {

            Font base = Font.createFont(Font.TRUETYPE_FONT, is);
            GraphicsEnvironment
                    .getLocalGraphicsEnvironment()
                    .registerFont(base);

            TITLE_FONT = base.deriveFont(60f);
            TITLE_FONT_HOVER = base.deriveFont(65f);
            MEDIUM_FONT = base.deriveFont(32f);
            SMALL_FONT = base.deriveFont(18f);

        } catch (IOException | FontFormatException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Private constructor to avoid initialization.
     */
    private UIConstants() {
    }

}
