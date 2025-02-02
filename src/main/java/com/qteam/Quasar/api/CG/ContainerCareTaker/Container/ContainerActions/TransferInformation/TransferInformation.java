package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation;

import com.qteam.Quasar.Q;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.BooleanSettingInformation;
import com.qteam.Quasar.impl.Modules.Mod;
import com.qteam.Quasar.impl.settings.BooleanSetting;
import com.qteam.Quasar.impl.settings.Setting;

public class TransferInformation {

    public final String title;

    public TransferInformation(String title) {
        this.title = title;
    }

    public static TransferInformation makeTransferInformation(Object object) {
        Q.log("NOT SETTING" + object);
        if (object instanceof Mod) {
            Q.log("MOD" + object);
            return new ModuleInformation((Mod) object);
        } else if (object instanceof Mod.Category) {
            Q.log("CATEGORY" + object);
            return new CategoryInformation((Mod.Category) object);
        } else if (object instanceof Setting) {
            Q.log("SETTING" + object);
            if (object instanceof BooleanSetting) {
                Q.log("BOOLEANSETTING" + object);
                return new BooleanSettingInformation((BooleanSetting) object);
            }
        }
        Q.log("NULL" + object);
        return null;
    }

}
