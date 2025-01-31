package com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container;

import com.lilyfena.NUBClient.DY;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.ContainerAction;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.OpenableAction;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.PressableAction;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.Switch;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.CategoryInformation;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.ModuleInformation;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.BooleanSettingInformation;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.SettingInformation;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.TransferInformation;
import com.lilyfena.NUBClient.api.Render.BTR;
import com.lilyfena.NUBClient.impl.Mc;

import java.util.ArrayList;

public class Container implements Mc {
    public ArrayList<ContainerAction> containerActions = new ArrayList<>();
    public final int w;
    public final int h;
    public int x;
    public int y;
    public int containerH;
    public boolean show = true;
    public final CloseButton closeButton;
    public final String title;
    protected String sorryText = "Nothing there :(";
    public Container(String title, ArrayList<TransferInformation> transferInformations, int w, int h, int x, int y, boolean closeable) {this.w = w;this.h = h;this.x = x;this.y = y;this.title = title;int setOffset = 0;for (TransferInformation transferInformation : transferInformations) {containerActions.add(infoToAction(transferInformation, setOffset));setOffset += h;}this.containerH=containerActions.size()*h;if(closeable)closeButton=new CloseButton(this); else closeButton = null;}
    public Container(String title, int w, int h, int x, int y) {this.w = w;this.h = h;this.x = x;this.y = y;this.title = title;closeButton = new CloseButton(this);}
    public ContainerAction infoToAction(TransferInformation transferInformation, int setOffset) {
        if (!(transferInformation instanceof SettingInformation)) {
            if (transferInformation instanceof CategoryInformation) {
                return new OpenableAction((CategoryInformation) transferInformation, this, setOffset);
            } else if (transferInformation instanceof ModuleInformation) {
                return new PressableAction((ModuleInformation) transferInformation, this, setOffset);
            }
        } else {
            if (transferInformation instanceof BooleanSettingInformation) {
                return new Switch((BooleanSettingInformation) transferInformation, this, setOffset);
            }
        }
        return null;
    }
    public boolean mouseClicked(double mouseX, double mouseY, int button){if(!show)return true;if(closeButton!=null)if(closeButton.mouseClicked(mouseX,mouseY,button))return true;for(ContainerAction containerAction:containerActions){containerAction.mouseClicked(mouseX,mouseY,button);}return true;}
    public void render(int mouseX, int mouseY, float delta) {
        if (!show) return;
        if (!containerActions.isEmpty()) {
            BTR.Scissor(x, y-h, x + w, y + containerH);
            BTR.dr(x, y-h, x + w, y + containerH, DY.BGC.hashCode());
            BTR.drawCenteredString(title, x+w/2, y-h/2, -1);
            if (closeButton != null) {
                closeButton.render(mouseX, mouseY);
            }
            for (ContainerAction containerAction : containerActions) {
                containerAction.render(mouseX, mouseY, delta);
            }
            BTR.disableScissor();
        } else {
            containerH = h;
            if (closeButton != null) {
                BTR.dr(x, y-h, x + Math.max(w, mc.textRenderer.getWidth(sorryText) + 4), y + h, DY.BGC.hashCode());
                BTR.drawString(sorryText, x + 2, y + (float) h / 2 - (float) mc.textRenderer.fontHeight / 2, -1);
                closeButton.render(mouseX, mouseY);
            }
            else {
                BTR.dr(x, y, x + Math.max(w, mc.textRenderer.getWidth(sorryText) + 4), y + h, DY.BGC.hashCode());
                BTR.drawString(sorryText, x + 2, y + (float) h / 2 - (float) mc.textRenderer.fontHeight / 2, -1);
            }
        }
    }

    public void updateContainerActions() {
        int setOffset = 0;
        if (containerActions.isEmpty()) return;
        for (ContainerAction containerAction : containerActions) {
            containerAction.offset = setOffset;
            setOffset += h;
        }
    }
}
