package com.lilyfena.NUBClient.api.Font.BThackCum;


import com.lilyfena.NUBClient.api.Render.BTR;
import com.lilyfena.NUBClient.impl.Mc;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public final class FontUtils implements Mc {


    public static float getTextWidth(String text) {
        return BTR.fontRenderManager.normalFontRenderer.getStringWidth(text);
    }

    public static float getTextWidth(String text, FontRenderManager.DrawMode drawMode) {
        return BTR.fontRenderManager.fontRendererOf(drawMode).getStringWidth(text);
    }

    public static float getTextHeight(String text) {
        return BTR.fontRenderManager.normalFontRenderer.getStringHeight(text) / 2;
    }

    public static float getTextHeight(String text, FontRenderManager.DrawMode drawMode) {
        return BTR.fontRenderManager.fontRendererOf(drawMode).getStringHeight(text) / 2;
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
