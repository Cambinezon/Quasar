package com.qteam.Quasar.impl.Modules;

import com.qteam.Quasar.Q;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Icons;
import com.qteam.Quasar.impl.settings.BooleanSetting;
import com.qteam.Quasar.impl.settings.KeyBindSetting;
import com.qteam.Quasar.impl.settings.Setting;
import com.qteam.Quasar.mixins.AccessorClientWorld;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.PendingUpdateManager;
import net.minecraft.client.network.SequencedPacketCreator;
import net.minecraft.network.listener.ServerPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class Mod {
    private String name;
    private String description;
    private int key;
    private boolean enabled;
    public Category category;
    public BooleanSetting isVisible;
    public KeyBindSetting bind;

    private List<Setting> settings = new ArrayList<>();

    public static MinecraftClient mc = MinecraftClient.getInstance();

    public Mod(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.isVisible = new BooleanSetting("isVisible", this,true);
        this.bind = new KeyBindSetting("key", this, 0);;
    }

    protected void sendPacket(Packet<?> packet) {
        mc.getNetworkHandler().sendPacket(packet);
    }

    /**
     *
     *
     * @param p
     */
    public void sendSequencedPacket(final SequencedPacketCreator p)
    {
        if (mc.world != null)
        {
            PendingUpdateManager updater =
                    ((AccessorClientWorld) mc.world).hookGetPendingUpdateManager().incrementSequence();
            try
            {
                int i = updater.getSequence();
                Packet<ServerPlayPacketListener> packet = p.predict(i);
                sendPacket(packet);
            }
            catch (Throwable e)
            {
                e.printStackTrace();
                if (updater != null)
                {
                    try
                    {
                        updater.close();
                    }
                    catch (Throwable e1)
                    {
                        e1.printStackTrace();
                        e.addSuppressed(e1);
                    }
                }
                throw e;
            }
            if (updater != null)
            {
                updater.close();
            }
        }
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public void addSetting(Setting setting) {
        settings.add(setting);
    }

    public void addSettings(Mod module, boolean b, boolean v, Setting... settings) {
        for (Setting setting : settings) addSetting(setting);
        if (v) addSetting(isVisible);
        if (b) addSetting(bind);
    }

    public void smartSettings(Mod module, Setting... settings) {
        addSettings(module, true, true, settings);
    }

    public void toggle() {
        this.enabled = !this.enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void onEnable() {
        Q.EVENT_BUS.register(this);
    }

    public void onDisable() {
        Q.EVENT_BUS.unregister(this);
    }

    public void onTick() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String s) {
        this.description = s;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) onEnable();
        else onDisable();
    }

    public void setQuietEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Category getCategory() {
            return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public enum Category {
        FORTESTING("ForTesting", Icons.GEAR),
        COMBAT("Combat", Icons.SWORDS),
        CLIENT("Client", Icons.PERSON),
        EXPLOITS("Exploits", Icons.CULT),
        PLAYER("Player", Icons.JOYSTICK),
        MOVEMENT("Movement", Icons.RUNNING),
        RENDER("Render", Icons.EYE),
        WORLD("World", Icons.BOXES);

        public String name;
        public Identifier icon;

        private Category(String name, Identifier icon)
        {
            this.name = name;
            this.icon = icon;
        }
    }


    public static boolean nullCheck() {
        return mc.player == null || mc.world == null;
    }

}
