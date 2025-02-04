package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation;

import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.TransferInformation;
import com.qteam.Quasar.impl.settings.*;

public class SettingInformation extends TransferInformation {

    public final Setting setting;

    public SettingInformation(Setting setting) {
        super(setting.getName());
        this.setting = setting;
    }

    public static SettingInformation make(Setting setting) {
        if (setting instanceof BooleanSetting) {
            return new BooleanSettingInformation((BooleanSetting) setting);
        } else if (setting instanceof KeyBindSetting) {
            return new BindSettingInformation((KeyBindSetting) setting);
        } else if (setting instanceof NumberSetting) {
            return new NumberSettingInformation((NumberSetting) setting);
        } else if (setting instanceof ModeSetting<?>) {
            return new ModeSettingInformation((ModeSetting) setting);
        }
        return new SettingInformation(setting);
    }

}
