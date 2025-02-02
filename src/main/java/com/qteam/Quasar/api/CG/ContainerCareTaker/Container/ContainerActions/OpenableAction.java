package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions;

import com.qteam.Quasar.Q;
import com.qteam.Quasar.api.CG.CG;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.Container;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.CategoryInformation;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.ModuleInformation;
import com.qteam.Quasar.api.Render.QR;
import com.qteam.Quasar.impl.Mc;
import com.qteam.Quasar.impl.Modules.ModuleManager;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class OpenableAction extends ContainerAction implements Mc {

    public final Identifier icon;
    public final CategoryInformation categoryInformation;

    private float hover = 0;

    public OpenableAction(CategoryInformation transferInformation, Container container, int offset) {
        super(transferInformation.title, transferInformation, container, offset);
        this.icon = transferInformation.icon;
        this.categoryInformation = transferInformation;
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        boolean hovered = isHovered(mouseX, mouseY);

        if (hovered) {
            hover += (1 - hover) / 4;
        } else {
            hover += (0 - hover) / 4;
        }

        QR.drawRoundedRect(getStartX()+1, getStartY()+1, getEndX()-1, getEndY()-1, 4, Q.DISABLEDOUTLINE.hashCode());
        QR.drawRoundedRect(getStartX()+2, getStartY()+2, getEndX()-2, getEndY()-2, 4, Q.BUTTBGC.hashCode());
        if (hovered) QR.dr(getStartX()+2, getStartY()+2, getEndX()-2, getEndY()-2, Q.S.hashCode());
        QR.drawTextureRect(
                icon,
                getStartX()+2,
                getStartY()+2,
                getStartX()+18,
                getStartY()+18
        );
        QR.drawCenteredString(title, (int) (getCenterX()+3*hover), getCenterY(), -1);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY) && button == 0) {
//            CG.INSTANCE.modules.show = true;
//            CG.INSTANCE.modules.containerActions.clear();
//            CG.INSTANCE.modules.containerActions.addAll(new ArrayList(ModuleManager.INSTANCE.getModulesCategory(categoryInformation.category).stream().map(
//                    i -> CG.INSTANCE.modules.infoToAction(TransferInformation.makeTransferInformation(i), 0)
//            ).toList()));
//            CG.INSTANCE.modules.updateContainerActions();
//            int h = CG.INSTANCE.modules.h;
//            CG.INSTANCE.modules.containerH = Math.max(h, h * CG.INSTANCE.modules.containerActions.size());
            CG.INSTANCE.containerCareTaker.containers.add(
                    new Container(title, new ArrayList<>(ModuleManager.INSTANCE.getModulesCategory(categoryInformation.category)
                    .stream()
                    .map(ModuleInformation::new).toList()), 120, 20, 0, 0, true));
        }
    }
}
