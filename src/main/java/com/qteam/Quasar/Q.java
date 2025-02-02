package com.qteam.Quasar;

import com.qteam.Quasar.api.CG.CG;
import com.qteam.Quasar.api.MegaEvents.Base.EventBus;
import com.qteam.Quasar.api.Shader.ShaderLoader;
import com.qteam.Quasar.impl.Mc;
import com.qteam.Quasar.impl.Modules.Mod;
import com.qteam.Quasar.impl.Modules.ModuleManager;
import com.qteam.Quasar.api.Render.BWRC;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;


public class Q implements ModInitializer, Mc {
    public static Q INSTANCE;
    public static String NAME = "Quasar";
    public static String VERSION = "beta_0004";

    public static final Logger logger = LoggerFactory.getLogger(NAME);

    public static Color S = new Color(0x30000000, true);
    public static Color BGC2 = new Color(0x99000000, true);
    public static Color BGC = new Color(0xFF33323C);
    public static Color BUTTBGC = new Color(0x3B3A45);
    public static Color DISABLEDOUTLINE = new Color(0x555463);
    public static Color ENABLEBGC = new Color(0x575963);
    public static Color ENABLEOUTLINE = new Color(0x868597);

    public static String ChatPrefix = "&";
    private static String currentConfigName = "";

    public static ShaderLoader blurShader;

    public static final EventBus EVENT_BUS = new EventBus();
    public static BWRC renderContext = new BWRC();


    public static void log(String message) {
        logger.info(message);
    }

    @Override
    public void onInitialize() {
        INSTANCE = this;
        log(NAME+" "+VERSION+" init!");
    }

    public void loadShaders() {
        blurShader = new ShaderLoader(
                new Identifier("quasar", "shaders/core/blur.vert"),
                new Identifier("quasar", "shaders/core/blur.frag")
        ); blurShader.init();
    }

    public void onKeyPressed(int key, int action) {
        if (action == GLFW.GLFW_PRESS) {
            for (Mod module : ModuleManager.INSTANCE.getModules()) {
                if (key == module.getKey()) module.toggle();
            }
        }

        if (key == ModuleManager.ClickGui.getKey()) {
            mc.setScreen(CG.INSTANCE);
        }
    }

    public void onTick() {
        if (mc.player != null && mc.world != null) {
            for (Mod module : ModuleManager.INSTANCE.getEnabledModules()) {
                module.onTick();
            }
        }
    }

    public static void setCurrentConfigName(String currentConfigName) {
        Q.currentConfigName = currentConfigName;
    }

    public static String getCurrentConfigName() {
        return currentConfigName;
    }

    public static void setChatPrefix(String chatPrefix) {
        ChatPrefix = chatPrefix;
    }

    public static String getChatPrefix() {
        return ChatPrefix;
    }
}
