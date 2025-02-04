package com.qteam.Quasar.impl.Modules.TESTING;

import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.ModeSettingInformation;
import com.qteam.Quasar.impl.Modules.Mod;
import com.qteam.Quasar.impl.settings.BooleanSetting;
import com.qteam.Quasar.impl.settings.ModeSetting;
import com.qteam.Quasar.impl.settings.NumberSetting;

public class TESTModule extends Mod {

    private final BooleanSetting booleanSetting = new BooleanSetting("Switch", this, true);
    private final NumberSetting numberSetting = new NumberSetting("Test", this, 0, 10, 3, 0.6);
    private final ModeSetting<testEnum> modeSetting = new ModeSetting<>("TestMode", this, testEnum.PRIVET, testEnum.values());

    public TESTModule() {
        super("TestModule", "Made only for testing.", Category.FORTESTING);

        smartSettings(
                this,

                booleanSetting,
                numberSetting,
                modeSetting

                );

    }


    private enum testEnum {

        PRIVET("Привет!"),
        KAKDELA("Как дела?"),
        UMENYEHOROSHO("У меня все хорошо.");

        public String string;

        private testEnum(String string) {
            this.string = string;
        }

    }

}
