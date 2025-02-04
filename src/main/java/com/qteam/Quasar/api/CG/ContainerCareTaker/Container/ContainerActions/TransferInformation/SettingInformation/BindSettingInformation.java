package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation;

import com.qteam.Quasar.impl.settings.KeyBindSetting;

public class BindSettingInformation extends SettingInformation {

    public final KeyBindSetting keyBindSetting;

    public BindSettingInformation(KeyBindSetting setting) {
        super(setting);
        this.keyBindSetting = setting;
    }

}
