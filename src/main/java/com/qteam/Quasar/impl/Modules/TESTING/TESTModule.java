package com.qteam.Quasar.impl.Modules.TESTING;

import com.qteam.Quasar.impl.Modules.Mod;
import com.qteam.Quasar.impl.settings.BooleanSetting;

public class TESTModule extends Mod {

    private final BooleanSetting booleanSetting = new BooleanSetting("Switch", true);

    public TESTModule() {
        super("TestModule", "Made only for testing.", Category.FORTESTING);

        addSettings(
                booleanSetting,
                isVisible
        );

    }

}
