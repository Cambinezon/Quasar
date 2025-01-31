package com.lilyfena.NUBClient.impl.Modules;

import com.lilyfena.NUBClient.impl.Modules.Client.ClickGuiModule;
import com.lilyfena.NUBClient.impl.Modules.TESTING.TESTModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuleManager {

    //FORTESTING
    public static final Mod TESTModule = new TESTModule();

    //CLIENT
    public static final Mod ClickGui = new ClickGuiModule();

    public static final ModuleManager INSTANCE = new ModuleManager();
    private List<Mod> modules = new ArrayList<>();
    public ModuleManager() {
        addModules();
    }

    public List<Mod> getModules() {
        return modules;
    }

    public List<Mod> getEnabledModules() {
        List<Mod> enabled = new ArrayList<>();
        for (Mod module : modules) {
            if (module.isEnabled()) {
                enabled.add(module);
            }
        }

        return enabled;
    }

    public List<Mod> getModulesCategory(Mod.Category category) {
        List<Mod> categoryModules = new ArrayList<>();

        for (Mod mod : modules) {
            if (mod.getCategory() == category) {
                categoryModules.add(mod);
            }
        }
        return categoryModules;
    }

    private void addModules() {
        modules.addAll(Arrays.asList(

                //FORTESTING
                TESTModule,

                //CLIENT
                ClickGui
        ));
    }


}
