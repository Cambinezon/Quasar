package com.lilyfena.NUBClient.impl.settings;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.function.Supplier;

public class Setting {

    private String name;
    private boolean visible = true;
    public final Supplier<Boolean> bbbb;

    public Setting(String name, Supplier<Boolean> bbbb) {
        this.name = name;
        this.bbbb = bbbb;
    }

    public String getName() {
        return name;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void load(JsonObject jsonObject, JsonElement jsonElement) {

    }

    public void save(JsonObject jsonObject) {

    }
}
