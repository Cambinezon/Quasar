package com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions;

import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.Container;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.BooleanSettingInformation;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Icons;
import com.lilyfena.NUBClient.api.Render.BTR;

public class Switch extends ContainerAction {

    public final BooleanSettingInformation booleanSettingInformation;
    public boolean enabled = false;
    private float process = 0;
    private final int outline = 2;

    public Switch(BooleanSettingInformation transferInformation, Container parent, int offset) {
        super(transferInformation.title, transferInformation, parent, offset);
        this.booleanSettingInformation = transferInformation;
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        if (enabled) {
            process += (1f - process)/5;
        } else {
            process += (0f - process)/5;
        }
        BTR.drawString(title, getStartX()+4, getCenterY(), -1);
        BTR.guiGraphics.setShaderColor((1f-process)*0.75f, process*0.75f, 0f, 1f);
        BTR.drawTextureRect(Icons.SWITCHBG, getEndX()-20, getCenterY()-4, getEndX()-4, getCenterY()+4);
        BTR.guiGraphics.setShaderColor(1f,1f,1f,1f);
        BTR.drawTextureRect(Icons.SWITCHOUTLINE, getEndX()-20, getCenterY()-4, getEndX()-4, getCenterY()+4);
        BTR.drawTextureRect(Icons.CIRCLE, getEndX()-12-8*(1f-process), getCenterY()-4, getEndX()-4-8*(1f-process), getCenterY()+4);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isSwitchHovered(mouseX, mouseY) && button == 0) enabled = !enabled;
    }

    public boolean isSwitchHovered(double mouseX, double mouseY) {
        return getEndX()-24<mouseX&&mouseX<getEndX()-10&&getCenterY()-5<mouseY&&mouseY<getCenterY()+10;
    }
}
