package com.qteam.Quasar.impl.settings;

import com.qteam.Quasar.impl.Modules.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModeSetting<E> extends Setting {

    private E mode;
    private ArrayList<E> modes;
    private int index;
    public String name;

    public ModeSetting(String name, Mod parent, E defaultMode, Supplier<Boolean> bbbb, E... modes) {
        super(name, parent, bbbb);
        this.name = name;
        this.modes = new ArrayList<>(List.of(modes));
        this.mode = defaultMode;
        this.index = this.modes.indexOf(defaultMode);
    }

    public ModeSetting(String name,Mod parent, E defaultMode, E... modes) {
        super(name, parent, () -> true);
        this.name = name;
        this.modes = new ArrayList<>(List.of(modes));
        this.mode = defaultMode;
        this.index = this.modes.indexOf(defaultMode);
    }

    public E getMode() {
        return mode;
    }

    public List<E> getModes() {
        return modes;
    }

    public void setMode(E mode) {
        this.mode = mode;
        this.index = modes.indexOf(mode);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        this.mode = modes.get(index);
    }

    public void cycle(int side) {
        index += side;
        if (index < 0) {
            index += modes.size();
        } else if (index > modes.size() - 1) {
            index = 0;
        }
        mode = modes.get(index);
    }

    public boolean isMode(E mode) {
        return this.mode.toString().equals(mode);
    }

    public String getName() {
        return this.name;
    }
}