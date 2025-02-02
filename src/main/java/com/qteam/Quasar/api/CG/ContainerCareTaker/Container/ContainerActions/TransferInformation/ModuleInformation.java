package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation;

import com.qteam.Quasar.impl.Modules.Mod;

public class ModuleInformation extends TransferInformation {

    public final Mod module;

    public ModuleInformation(Mod module) {
        super(module.getName());
        this.module = module;
    }

}
