package com.lilyfena.NUBClient.api.CG;

import com.lilyfena.NUBClient.DY;
import com.lilyfena.NUBClient.api.Render.BTR;
import com.lilyfena.NUBClient.impl.Mc;

public class Selection implements Mc {

    public Selection() {

    }

    public void render(String description, int x, int y, float process) {
        int lenth =mc.textRenderer.getWidth(description);
        int globalLenth = (x+lenth+4);
        int globalHeight = y+mc.textRenderer.fontHeight+2;
        float prrprprp = (globalLenth+2)*process;

        BTR.guiGraphics.getMatrices().translate(0,0, 1000);
        BTR.Scissor(x,y-2, (int) prrprprp+1, globalHeight);
        BTR.dr(x,y-2,globalLenth, globalHeight, DY.BGC2.hashCode());
        BTR.drawString(description, x+2, y, -1);
        BTR.disableScissor();
        BTR.guiGraphics.getMatrices().translate(0,0, -1000);

    }
}
