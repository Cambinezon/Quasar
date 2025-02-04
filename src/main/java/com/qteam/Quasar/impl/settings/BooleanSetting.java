package com.qteam.Quasar.impl.settings;

import com.qteam.Quasar.impl.Modules.Mod;

import java.util.function.Supplier;

public class BooleanSetting extends Setting {

    public String name;
    private boolean enabled;

    public BooleanSetting(String name, Mod parent, boolean defaultValue, Supplier<Boolean> bbbb) {
        super(name,parent, bbbb);
        this.name = name;
        this.enabled = defaultValue;
    }

    public BooleanSetting(String name, Mod parent, boolean defaultValue) {
        super(name, parent, () -> true);
        this.name = name;
        this.enabled = defaultValue;
    }

    public void toggle() {
        this.enabled = !this.enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return this.name;
    }
}
