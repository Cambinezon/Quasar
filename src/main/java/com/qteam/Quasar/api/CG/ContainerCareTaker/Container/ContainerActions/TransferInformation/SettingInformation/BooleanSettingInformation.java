package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation;

import com.qteam.Quasar.impl.settings.BooleanSetting;

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
