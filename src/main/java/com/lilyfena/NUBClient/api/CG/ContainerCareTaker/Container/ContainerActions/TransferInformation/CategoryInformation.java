package com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation;

import com.lilyfena.NUBClient.impl.Modules.Mod;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class CategoryInformation extends TransferInformation {

    public final Mod.Category category;
    public final Identifier icon;

    public CategoryInformation(Mod.Category category) {
        super(category.name);
        this.icon = category.icon;
        this.category = category;
    }

    public static CategoryInformation make(Mod.Category category) {
        return new CategoryInformation(category);
    }

}
