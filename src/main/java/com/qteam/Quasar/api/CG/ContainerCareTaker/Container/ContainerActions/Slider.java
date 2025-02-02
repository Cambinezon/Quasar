package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions;

import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.Container;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.NumberSettingInformation;

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
