package com.lilyfena.NUBClient.impl.settings;

import java.util.function.Supplier;

public class BooleanSetting extends Setting {

    public String name;
    private boolean enabled;

    public BooleanSetting(String name, boolean defaultValue, Supplier<Boolean> bbbb) {
        super(name, bbbb);
        this.name = name;
        this.enabled = defaultValue;
    }

    public BooleanSetting(String name, boolean defaultValue) {
        super(name, () -> true);
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
