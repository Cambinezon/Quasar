package com.lilyfena.NUBClient.impl.settings;

public class KeyBindSetting extends Setting {

    private int key;
    private boolean enabled;

    public KeyBindSetting(String name, int defaultKey) {
        super(name, () -> true);
        this.key = defaultKey;
    }
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void toggle() {
        this.enabled = !this.enabled;
    }
}