package com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation;

import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.TransferInformation;
import com.lilyfena.NUBClient.impl.settings.BooleanSetting;
import com.lilyfena.NUBClient.impl.settings.Setting;

public class SettingInformation extends TransferInformation {

    public final Setting setting;

    public SettingInformation(Setting setting) {
        super(setting.getName());
        this.setting = setting;
    }

    public static SettingInformation make(Setting setting) {
        if (setting instanceof BooleanSetting) {
            return new BooleanSettingInformation((BooleanSetting) setting);
        }
        return new SettingInformation(setting);
    }

}
