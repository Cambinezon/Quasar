package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation;

import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.TransferInformation;
import com.qteam.Quasar.impl.settings.BooleanSetting;
import com.qteam.Quasar.impl.settings.Setting;

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
