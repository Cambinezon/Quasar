package com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions;

import com.lilyfena.NUBClient.DY;
import com.lilyfena.NUBClient.api.CG.CG;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.Container;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.ModuleInformation;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.SettingInformation;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.TransferInformation;
import com.lilyfena.NUBClient.api.Render.BTR;
import com.lilyfena.NUBClient.api.Utils.ColorUtils;
import com.lilyfena.NUBClient.impl.Modules.ModuleManager;

import java.util.ArrayList;
import java.util.Arrays;

public class PressableAction extends ContainerAction {

    public final ModuleInformation moduleInformation;

    private float hover = 0;

    public PressableAction(ModuleInformation transferInformation, Container container, int offset) {
        super(transferInformation.title, transferInformation, container, offset);
        this.moduleInformation = transferInformation;
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        boolean Integer = !moduleInformation.module.isEnabled();

        boolean hovered = isHovered(mouseX, mouseY);

        if (Integer) BTR.dr(getStartX()+2, getStartY()+2, getEndX()-2, getEndY()-2, DY.BUTTBGC.hashCode());
        else {
            BTR.dr(getStartX()+2, getStartY()+2, getEndX()-2, getEndY()-2,
                    DY.ENABLEBGC.hashCode());
        }
        if (hovered) {
            BTR.dr(getStartX()+2, getStartY()+2, getEndX()-2, getEndY()-2, DY.S.hashCode());
            CG.INSTANCE.discription = moduleInformation.module.getDescription();
        }
        BTR.drawOutlineRect(getStartX()+2, getStartY()+2, getEndX()-1, getEndY()-1, 1,
                !Integer ? DY.ENABLEOUTLINE.hashCode() : DY.DISABLEDOUTLINE.hashCode());
        if (hovered) {
            hover += (1 - hover) / 4;
            BTR.drawCenteredString(title, (int) (Math.ceil(getCenterX()+3*hover)), getCenterY(), -1);
        } else {
            hover += (0 - hover) / 4;
            BTR.drawCenteredString(title, (int) (Math.floor(getCenterX()+3*hover)), getCenterY(), -1);
        }}

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY)) {
            if (button == 0) moduleInformation.module.toggle();
            else if (button == 1) {
//                CG.INSTANCE.settings.show = true;
//                CG.INSTANCE.settings.containerActions.clear();
//                ArrayList<SettingInformation> transferInformations = new ArrayList<>(
//                        moduleInformation.module.getSettings()
//                        .stream()
//                        .map(SettingInformation::make)
//                        .toList());
//                CG.INSTANCE.settings.containerActions.addAll(
//                        new ArrayList<>(
//                            transferInformations.stream()
//                                    .map(i -> CG.INSTANCE.settings.infoToAction(i, 0))
//                                    .toList()
//                        )
//                );
//                CG.INSTANCE.settings.updateContainerActions();
//                int h = CG.INSTANCE.settings.h;
//                CG.INSTANCE.settings.containerH = Math.max(h, h * CG.INSTANCE.settings.containerActions.size());
                CG.INSTANCE.containerCareTaker.containers.add(
                        new Container(title, new ArrayList<>(moduleInformation.module.getSettings()
                                .stream()
                                .map(SettingInformation::make).toList()), 120, 20, 0, 0, true));
            }
        }
    }
}
