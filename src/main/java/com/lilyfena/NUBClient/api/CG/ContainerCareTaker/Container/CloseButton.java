package com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container;

import com.lilyfena.NUBClient.DY;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Icons;
import com.lilyfena.NUBClient.api.Render.BTR;

public class CloseButton {

    public final Container parent;

    public CloseButton(Container parent) {
        this.parent = parent;
    }

    public void render(double mouseX, double mouseY) {
        if (isHovered(mouseX, mouseY)) BTR.drawTextureRect(Icons.CANCELHOVERED, parent.x+4, parent.y-parent.h+4, parent.x+18, parent.y-parent.h+18);
        else BTR.drawTextureRect(Icons.CANCELNOTHOVERED, parent.x+4, parent.y-parent.h+4, parent.x+18, parent.y-parent.h+18);
    }
    private boolean isHovered(double mouseX, double mouseY) {return parent.x+4<mouseX&&mouseX<parent.x+18&&parent.y-parent.h+4<mouseY&&parent.y-parent.h+18>mouseY;}
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY) && button == 0) {
            parent.show = false;
            return true;
        } else {
            return false;
        }
    }

}
