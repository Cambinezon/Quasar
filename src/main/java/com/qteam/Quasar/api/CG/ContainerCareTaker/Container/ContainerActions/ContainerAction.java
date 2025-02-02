package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions;

import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.Container;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.TransferInformation;

public class ContainerAction {

    public final Container parent;
    public final TransferInformation transferInformation;
    public int offset;
    public final String title;

    public ContainerAction(String title, TransferInformation transferInformation, Container container, int offset) {
        this.title = title;
        this.transferInformation = transferInformation;
        this.parent = container;
        this.offset = offset;
    }

    public void render(int mouseX, int mouseY, float delta) {

    }

    public void mouseClicked(double mouseX, double mouseY, int button) {

    }

    public int getStartX() {
        return parent.x;
    }

    public int getStartY() {
        return parent.y + offset;
    }

    public int getCenterX() {
        return parent.x + parent.w / 2;
    }

    public int getCenterY() {
        return parent.y + offset + parent.h / 2;
    }

    public int getEndX() {
        return parent.x + parent.w;
    }

    public int getEndY() {
        return parent.y + offset + parent.h;
    }

    public boolean isHovered(double mouseX, double mouseY) {
        return getStartX()<mouseX&&getEndX()>mouseX&&getStartY()<mouseY&&getEndY()>mouseY;
    }
}
