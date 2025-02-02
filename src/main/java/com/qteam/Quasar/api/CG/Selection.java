package com.qteam.Quasar.api.CG;

import com.qteam.Quasar.Q;
import com.qteam.Quasar.api.Render.QR;
import com.qteam.Quasar.impl.Mc;

public class Selection implements Mc {

    public Selection() {

    }

    public void render(String description, int x, int y, float process) {
        int lenth =mc.textRenderer.getWidth(description);
        int globalLenth = (x+lenth+4);
        int globalHeight = y+mc.textRenderer.fontHeight+2;
        float prrprprp = (globalLenth+2)*process;

        QR.guiGraphics.getMatrices().translate(0,0, 1000);
        QR.Scissor(x,y-2, (int) prrprprp+1, globalHeight);
        QR.dr(x,y-2,globalLenth, globalHeight, Q.BGC2.hashCode());
        QR.drawString(description, x+2, y, -1);
        QR.disableScissor();
        QR.guiGraphics.getMatrices().translate(0,0, -1000);

    }
}
