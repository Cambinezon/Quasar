package com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation;

import com.lilyfena.NUBClient.DY;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.BooleanSettingInformation;
import com.lilyfena.NUBClient.impl.Modules.Mod;
import com.lilyfena.NUBClient.impl.settings.BooleanSetting;
import com.lilyfena.NUBClient.impl.settings.Setting;

public class TransferInformation {

    public final String title;

    public TransferInformation(String title) {
        this.title = title;
    }

    public static TransferInformation makeTransferInformation(Object object) {
        DY.log("NOT SETTING" + object);
        if (object instanceof Mod) {
            DY.log("MOD" + object);
            return new ModuleInformation((Mod) object);
        } else if (object instanceof Mod.Category) {
            DY.log("CATEGORY" + object);
            return new CategoryInformation((Mod.Category) object);
        } else if (object instanceof Setting) {
            DY.log("SETTING" + object);
            if (object instanceof BooleanSetting) {
                DY.log("BOOLEANSETTING" + object);
                return new BooleanSettingInformation((BooleanSetting) object);
            }
        }
        DY.log("NULL" + object);
        return null;
    }

}
