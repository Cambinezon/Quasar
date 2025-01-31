package com.lilyfena.NUBClient.impl.Modules.Client;

import com.lilyfena.NUBClient.impl.Modules.Mod;
import org.lwjgl.glfw.GLFW;

public class ClickGuiModule extends Mod {

    public ClickGuiModule() {
        super("ClickGui", "ClickGui settings", Category.CLIENT);

        bind.setKey(GLFW.GLFW_KEY_RIGHT_CONTROL);
        this.setKey(GLFW.GLFW_KEY_RIGHT_CONTROL);

        addSettings(
                isVisible
        );
    }
}
