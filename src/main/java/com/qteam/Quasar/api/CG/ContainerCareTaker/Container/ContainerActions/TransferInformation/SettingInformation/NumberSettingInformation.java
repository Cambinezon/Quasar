package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation;

import com.qteam.Quasar.impl.settings.NumberSetting;

public class NumberSettingInformation extends SettingInformation {

    public final NumberSetting numberSetting;

    public NumberSettingInformation(NumberSetting setting) {
        super(setting);
        this.numberSetting = setting;
    }

}
