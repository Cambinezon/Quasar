package com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions;

import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.Container;
import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.ContainerActions.TransferInformation.SettingInformation.NumberSettingInformation;
import com.qteam.Quasar.api.Render.QR;
import com.qteam.Quasar.impl.settings.NumberSetting;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 *
 *
 * @author DoggLilY
 * @since beta0008
 */
public class Slider extends ContainerAction {

    public final NumberSettingInformation numberSettingInformation;
    public final NumberSetting numSet;
    private int sliderP = 0;
    private boolean sliding = false;
    private final Color sliderColor = new Color(0xFF7300);

    public Slider(NumberSettingInformation numberSettingInformation, Container parent, int offset) {
        super(numberSettingInformation.title, numberSettingInformation, parent, offset);
        this.numberSettingInformation = numberSettingInformation;
        this.numSet = this.numberSettingInformation.numberSetting;
    }

    /**
     *
     * @param mouseX
     * @param mouseY
     * @param delta
     */
    @Override
    public void render(int mouseX, int mouseY, float delta) {
        if (!numSet.isVisible()) return;

        double diff = Math.min(parent.w-2, max(0, mouseX - parent.x - 2));
        int renderW = (int) Math.min(parent.w - 2, (parent.w - 2) * ((numSet.getValue() - numSet.getMin()) / (numSet.getMax() - numSet.getMin())));
        sliderP += (renderW - sliderP) / 3;

        QR.dr(parent.x + 2, parent.y + parent.h + offset - 8, (parent.x + 2 + max(0, sliderP)), parent.y + parent.h + offset - 6, sliderColor.hashCode());
        QR.dr((parent.x + 2 + max(0, sliderP))-1, parent.y + parent.h + offset - 10, (parent.x + 2 + max(0, sliderP))+1, parent.y + parent.h + offset - 4, -1);

        if (sliding) {
            if (diff == 0) {
                numSet.setValue(numSet.getMin());
            } else {
                numSet.setValue(min(numSet.getMax(), roundToPlace((diff / (parent.w-2)) * (numSet.getMax() - numSet.getMin()) + numSet.getMin(), 1)));
            }
        }

        String text = numSet.getName() + ": " + roundToPlace(numSet.getValue(), 2);
        QR.drawString(text, parent.x + 2, parent.y + offset + 2, -1);

    }

    /**
     *
     * @param mouseX
     * @param mouseY
     * @param button
     */
    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY) && button == 0) {
            sliding = true;
        }
    }

    /**
     *
     * @param mouseX
     * @param mouseY
     * @param button
     */
    @Override
    public void mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0) sliding = false;
    }


    /**
     *
     *
     *
     * round 'value' to the certain place
     *
     * @param value
     * @param place
     * @return
     */
    private double roundToPlace(double value, int place) {
        if (place < 0) {
            return value;
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(place, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
