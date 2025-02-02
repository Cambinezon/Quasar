package com.qteam.Quasar.api.Font.QuasarCum;


import com.qteam.Quasar.api.Render.QR;
import com.qteam.Quasar.impl.Mc;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public final class FontUtils implements Mc {


    public static float getTextWidth(String text) {
        return QR.fontRenderManager.normalFontRenderer.getStringWidth(text);
    }

    public static float getTextWidth(String text, FontRenderManager.DrawMode drawMode) {
        return QR.fontRenderManager.fontRendererOf(drawMode).getStringWidth(text);
    }

    public static float getTextHeight(String text) {
        return QR.fontRenderManager.normalFontRenderer.getStringHeight(text) / 2;
    }

    public static float getTextHeight(String text, FontRenderManager.DrawMode drawMode) {
        return QR.fontRenderManager.fontRendererOf(drawMode).getStringHeight(text) / 2;
    }

    public static Font createFont(InputStream inputStream, float size) throws IOException, FontFormatException {
        return Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(inputStream)).deriveFont(Font.PLAIN, size);
    }

    public static Font createFontNoThrow(InputStream inputStream, float size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(inputStream)).deriveFont(Font.PLAIN, size);
        } catch (Exception ignored) {
            return null;
        }
    }
}
