package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation;

import com.qteam.Quasar.Q;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.BindSettingInformation;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.BooleanSettingInformation;
import com.qteam.Quasar.impl.Modules.Mod;
import com.qteam.Quasar.impl.settings.BooleanSetting;
import com.qteam.Quasar.impl.settings.KeyBindSetting;
import com.qteam.Quasar.impl.settings.Setting;

public class TransferInformation {

    public final String title;

    public TransferInformation(String title) {
        this.title = title;
    }

    public static TransferInformation makeTransferInformation(Object object) {
        if (object instanceof Mod) {
            return new ModuleInformation((Mod) object);
        } else if (object instanceof Mod.Category) {
            return new CategoryInformation((Mod.Category) object);
        } else if (object instanceof Setting) {
            if (object instanceof BooleanSetting) {
                return new BooleanSettingInformation((BooleanSetting) object);
            } else if (object instanceof KeyBindSetting) {
                return new BindSettingInformation((KeyBindSetting) object);
            }
        }
        return null;
    }

}
