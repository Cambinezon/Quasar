package com.qteam.Quasar.api.CG;

import com.qteam.Quasar.Q;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.Container;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.CategoryInformation;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.TransferInformation;
import com.qteam.Quasar.api.CG.ContainerCareTaker.ContainerCareTaker;
import com.qteam.Quasar.impl.Modules.Mod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.stream.Stream;

@Environment(EnvType.CLIENT)
public class CG extends Screen {

    public static CG INSTANCE = new CG();
    ArrayList<TransferInformation> transferInformations = new ArrayList<>(Stream.of(
            Mod.Category.values()
    ).map(CategoryInformation::make).toList());
    private final Container categories;
    public String discription = "";
    public final ContainerCareTaker containerCareTaker;

    private final Selection selection;
    private float process = 0;

    private CG() {
        super(Text.literal("ClickGUI"));
        Q.log(transferInformations.toString());
        categories = new Container("Categories", transferInformations, 120, 20, 15, 15, false);
        containerCareTaker = new ContainerCareTaker(categories);
        this.selection = new Selection();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        discription = "";
        containerCareTaker.render(mouseX, mouseY, delta);
        boolean hovered = !"".equals(discription);
        if (hovered) {
            process += (1f - process) / 7;
            selection.render(discription, mouseX+7, mouseY, process);
        } else {
            process = 0;
        }}

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        containerCareTaker.mouseClicked(mouseX, mouseY, button);
        return true;
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

//    @Override
//    public void onDisplayed() {
//        enableBlur();
//    }
//
//    @Override
//    public void removed() {
//        disableBlur();
//    }
//
//    private void enableBlur() {
//        if (blurShader != null) {
//            blurShader.activate();
//
//            int screenSizeLocation = GL20.glGetUniformLocation(blurShader.getProgramId(), "ScreenSize");
//            GL20.glUniform2f(screenSizeLocation, mc.getWindow().getFramebufferWidth(), mc.getWindow().getFramebufferHeight());
//
//            int blurRadiusLocation = GL20.glGetUniformLocation(blurShader.getProgramId(), "BlurRadius");
//            GL20.glUniform1f(blurRadiusLocation, 10.0f);
//        }
//    }
//
//    private void disableBlur() {
//        blurShader.deactivate();
//    }


}
