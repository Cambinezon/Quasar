package com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions;

import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.Container;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.NumberSettingInformation;
import com.lilyfena.NUBClient.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.TransferInformation;

public class Slider extends ContainerAction {

    public final NumberSettingInformation numberSettingInformation;

    public Slider(NumberSettingInformation numberSettingInformation, Container parent, int offset) {
        super(numberSettingInformation.title, numberSettingInformation, parent, offset);
        this.numberSettingInformation = numberSettingInformation;
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        
    }
}
