package com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation;

import com.lilyfena.NUBClient.impl.settings.BooleanSetting;
import com.lilyfena.NUBClient.impl.settings.Setting;

public class BooleanSettingInformation extends SettingInformation {

    public final BooleanSetting booleanSetting;

    public BooleanSettingInformation(BooleanSetting setting) {
        super(setting);
        this.booleanSetting = setting;
    }

    public static BooleanSettingInformation make(BooleanSetting booleanSetting) {
        return new BooleanSettingInformation(booleanSetting);
    }

}
