package com.qteam.Quasar.impl.settings;

import com.qteam.Quasar.api.Utils.KeyboardUtils;
import com.qteam.Quasar.impl.Modules.Mod;

public class KeyBindSetting extends Setting {

    private int key;
    private boolean enabled;

    public KeyBindSetting(String name, Mod parent, int defaultKey) {
        super(name, parent, () -> true);
        this.key = defaultKey;
    }
    public int getKey() {
        return key;
    }

    public String getKeyboardKey() {
        return KeyboardUtils.getKeyName(key);
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void toggle() {
        this.enabled = !this.enabled;
    }
}