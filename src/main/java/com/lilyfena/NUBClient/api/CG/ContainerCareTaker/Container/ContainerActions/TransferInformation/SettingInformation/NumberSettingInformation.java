package com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation;

import com.lilyfena.NUBClient.impl.settings.NumberSetting;

public class NumberSettingInformation extends SettingInformation {

    public final NumberSetting numberSetting;

    public NumberSettingInformation(NumberSetting setting) {
        super(setting);
        this.numberSetting = setting;
    }

}
