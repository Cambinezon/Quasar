package com.qteam.Quasar.impl.Modules.Client;

import com.qteam.Quasar.impl.Modules.Mod;
import org.lwjgl.glfw.GLFW;

public class ClickGuiModule extends Mod {

    public ClickGuiModule() {
        super("ClickGui", "ClickGui settings", Category.CLIENT);

        bind.setKey(GLFW.GLFW_KEY_RIGHT_CONTROL);
        this.setKey(GLFW.GLFW_KEY_RIGHT_CONTROL);

        smartSettings(this);
    }
}
