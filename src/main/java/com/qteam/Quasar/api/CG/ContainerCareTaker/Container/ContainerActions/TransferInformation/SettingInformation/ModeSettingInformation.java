package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation;

import com.qteam.Quasar.impl.settings.ModeSetting;

public class ModeSettingInformation extends SettingInformation {

    public final ModeSetting modeSetting;

    public ModeSettingInformation(ModeSetting modeSetting) {
        super(modeSetting);
        this.modeSetting = modeSetting;
    }

}
