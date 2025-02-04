package com.qteam.Quasar.api.CG.ContainerCareTaker.Container;

import com.qteam.Quasar.Q;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.*;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.CategoryInformation;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.ModuleInformation;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.*;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.TransferInformation;
import com.qteam.Quasar.api.Render.QR;
import com.qteam.Quasar.impl.Mc;

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
            } else if (transferInformation instanceof BindSettingInformation) {
                return new Bind((BindSettingInformation) transferInformation, this, setOffset);
            } else if (transferInformation instanceof NumberSettingInformation) {
                return new Slider((NumberSettingInformation) transferInformation, this, setOffset);
            } else if (transferInformation instanceof ModeSettingInformation) {
                return new ModeAction((ModeSettingInformation) transferInformation, this, setOffset);
            }
        }
        return null;
    }
    public boolean mouseClicked(double mouseX, double mouseY, int button){if(!show)return true;if(closeButton!=null)if(closeButton.mouseClicked(mouseX,mouseY,button))return true;for(ContainerAction containerAction:containerActions){containerAction.mouseClicked(mouseX,mouseY,button);}return true;}
    public void render(int mouseX, int mouseY, float delta) {
        if (!show) return;
        if (!containerActions.isEmpty()) {
            QR.Scissor(x, y-h, x + w, y + containerH+1);
            QR.dr(x, y-h, x + w, y + containerH, Q.BGC.hashCode());
            QR.drawCenteredString(title, x+w/2, y-h/2, -1);
            if (closeButton != null) {
                closeButton.render(mouseX, mouseY);
            }
            for (ContainerAction containerAction : containerActions) {
                containerAction.render(mouseX, mouseY, delta);
            }
            QR.disableScissor();
        } else {
            containerH = h;
            if (closeButton != null) {
                QR.dr(x, y-h, x + Math.max(w, mc.textRenderer.getWidth(sorryText) + 4), y + h, Q.BGC.hashCode());
                QR.drawString(sorryText, x + 2, y + (float) h / 2 - (float) mc.textRenderer.fontHeight / 2, -1);
                closeButton.render(mouseX, mouseY);
            }
            else {
                QR.dr(x, y, x + Math.max(w, mc.textRenderer.getWidth(sorryText) + 4), y + h, Q.BGC.hashCode());
                QR.drawString(sorryText, x + 2, y + (float) h / 2 - (float) mc.textRenderer.fontHeight / 2, -1);
            }
        }
    }

    public void keyPressed(int key) {
        for (ContainerAction containerAction : containerActions) {
            containerAction.keyPressed(key);
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

    public void mouseReleased(double mouseX, double mouseY, int button) {
        for (ContainerAction containerAction : containerActions) {
            containerAction.mouseReleased(mouseX, mouseY, button);
        }
    }
}
