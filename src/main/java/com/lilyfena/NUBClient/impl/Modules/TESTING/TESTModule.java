package com.lilyfena.NUBClient.impl.Modules.TESTING;

import com.lilyfena.NUBClient.impl.Modules.Mod;
import com.lilyfena.NUBClient.impl.settings.BooleanSetting;

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
