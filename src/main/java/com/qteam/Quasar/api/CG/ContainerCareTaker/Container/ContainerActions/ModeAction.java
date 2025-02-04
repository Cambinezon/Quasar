package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions;

import com.qteam.Quasar.Q;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.Container;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.ModeSettingInformation;
import com.qteam.Quasar.api.Render.QR;
import com.qteam.Quasar.impl.Mc;

public class ModeAction extends ContainerAction implements Mc {

    public final ModeSettingInformation modeSettingInformation;

    private int lenth;

    public ModeAction(ModeSettingInformation transferInformation, Container parent, int offset) {
        super(transferInformation.title, transferInformation, parent, offset);
        this.modeSettingInformation = transferInformation;
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {

        QR.drawString(title, getStartX() + 2, getStartY(), -1);

        String name = modeSettingInformation.modeSetting.getMode().toString();
        lenth = mc.textRenderer.getWidth(name);

        QR.dr(getEndX() - lenth - 2, getCenterY() + 7, getEndX() - 2, getCenterY() - 7, Q.BGC2.hashCode());
        QR.drawEndedString(name, getEndX() - 2, getCenterY() - 7, -1);

        if (isModeHovered(mouseX, mouseY)) {
            QR.dr(getEndX() - lenth - 2, getCenterY() + 7, getEndX() - 2, getCenterY() - 7, Q.S.hashCode());
        }

    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isModeHovered(mouseX, mouseY) && button == 0) {
            modeSettingInformation.modeSetting.cycle(1);
        }
    }

    private boolean isModeHovered(double mouseX, double mouseY) {
        return getEndX() - lenth - 2 < mouseX && mouseX < getEndX() - 2 &&
                getCenterY() - 7 < mouseY && mouseY < getCenterY() + 7;
    }
}
