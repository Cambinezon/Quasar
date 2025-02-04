package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions;

import com.qteam.Quasar.Q;
import com.qteam.Quasar.api.CG.CG;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.Container;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.BindSettingInformation;
import com.qteam.Quasar.api.Render.QR;
import com.qteam.Quasar.impl.Mc;

public class Bind extends ContainerAction implements Mc {

    public final BindSettingInformation bindSettingInformation;

    private boolean binding = false;

    public Bind(BindSettingInformation transferInformation, Container parent, int offset) {
        super("KeyBind", transferInformation, parent, offset);

        this.bindSettingInformation = transferInformation;
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        boolean h = isButtonHovered(mouseX, mouseY);
        int lenth = mc.textRenderer.getWidth("Set new Bind");
        if (!binding) {
            QR.dr(parent.x + parent.w - lenth - 2, parent.y + offset + parent.h / 2 - 5, parent.x + parent.w - 4, parent.y + offset + parent.h / 2 + 5, Q.BUTTBGC.hashCode());
            QR.dr(parent.x + parent.w - lenth - 2, parent.y + offset + parent.h / 2 - 5, parent.x + parent.w - 4, parent.y + offset + parent.h / 2 + 5, Q.DISABLEDOUTLINE.hashCode());
            if (h)
                QR.dr(parent.x + parent.w - lenth - 2, parent.y + offset + parent.h / 2 - 5, parent.x + parent.w - 4, parent.y + offset + parent.h / 2 + 5, Q.S.hashCode());
            QR.drawEndedString("Set new Bind", parent.x + parent.w - 6, parent.y + offset + parent.h / 2 - mc.textRenderer.fontHeight/2, -1);
            QR.drawString(title + ": " + bindSettingInformation.keyBindSetting.getKeyboardKey(), getStartX() + 4, getCenterY(), -1);
            if (h) {
                CG.INSTANCE.discription = "Set KeyBind to enable this module on key";
            }
        } else {
            QR.dr(parent.x + parent.w - lenth - 2, parent.y + offset + parent.h / 2 - 5, parent.x + parent.w - 4, parent.y + offset + parent.h / 2 + 5, Q.BUTTBGC.hashCode());
            QR.dr(parent.x + parent.w - lenth - 2, parent.y + offset + parent.h / 2 - 5, parent.x + parent.w - 4, parent.y + offset + parent.h / 2 + 5, Q.BGC2.hashCode());
            QR.dr(parent.x + parent.w - lenth - 2, parent.y + offset + parent.h / 2 - 5, parent.x + parent.w - 4, parent.y + offset + parent.h / 2 + 5, Q.DISABLEDOUTLINE.hashCode());
            QR.drawEndedString("Set new Bind", parent.x + parent.w - 6, parent.y + offset + parent.h / 2 - mc.textRenderer.fontHeight/2, -1);

            QR.drawString(title + ": <Press any key>", getStartX() + 4, getCenterY(), -1);
            CG.INSTANCE.discription = "(Press <DELETE> key to remove the KeyBind)";
        }
    }

    public void keyPressed(int key) {
        if (binding) {
            if (key == 256) {
                binding = false;
            } else if (key == 261) {
                bindSettingInformation.keyBindSetting.parent.setKey(0);
                bindSettingInformation.keyBindSetting.setKey(0);
                binding = false;
            } else {
                bindSettingInformation.keyBindSetting.parent.setKey(key);
                bindSettingInformation.keyBindSetting.setKey(key);
                binding = false;
            }
        }
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isButtonHovered(mouseX, mouseY) && button == 0) {
            binding = true;
        }
    }

    private boolean isButtonHovered(double mouseX, double mouseY) {
        int lenth = mc.textRenderer.getWidth("Set new Bind");
        return parent.x + parent.w - 4 - lenth < mouseX && mouseX < parent.x + parent.w - 4 && parent.y + offset + parent.h / 2 - 10 < mouseY && mouseY < parent.y + offset + parent.h / 2 + 10;
    }
}
