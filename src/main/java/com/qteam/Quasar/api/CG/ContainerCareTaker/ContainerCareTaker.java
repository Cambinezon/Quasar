package com.qteam.Quasar.api.CG.ContainerCareTaker;

import com.qteam.Quasar.api.CG.ContainerCareTaker.Container.Container;
import com.qteam.Quasar.impl.Mc;
import net.minecraft.client.util.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContainerCareTaker implements Mc {

    public final List<Container> containers;

    public ContainerCareTaker(Container... containers) {
        this.containers = new CopyOnWriteArrayList<>(List.of(containers));
    }


    public boolean render(double mouseX, double mouseY, float delta) {
        if (containers.isEmpty()) return true;
        setPositions(15);

        for (Container container : containers) {
            if (!container.show) {
                containers.remove(container); // Safe removal
            } else {
                container.render((int) mouseX, (int) mouseY, delta);
            }
        }

        return true;
    }


    public void mouseClicked(double mouseX, double mouseY, int button) {
        for (Container container : containers) {
            if (container.show) {
                container.mouseClicked(mouseX, mouseY, button);
            }
        }
    }

    public void keyPressed(int key) {
        if (containers.isEmpty()) return;

        for (Container container : containers) {
            if (container.show) container.keyPressed(key);
        }
    }

    public void setPositions(int space) {
        ArrayList<Container> var1000 = new ArrayList<>(containers
                .stream()
                .filter(i -> i.show)
                .toList());

        Window window = mc.getWindow();
        int w = window.getWidth();
        int h = window.getHeight();

        if (var1000.isEmpty()) return;
        int spacing = (-var1000.stream().mapToInt(i -> i.w).sum() + (-var1000.size() - 1) * space) / 2;
        for (Container container : var1000) {
            container.y = -container.containerH / 2 + h / 4;
            container.x = spacing + w / 4;
            spacing += container.w + space;
        }

    }

    public void mouseReleased(double mouseX, double mouseY, int button) {

        for (Container container : containers) {
            container.mouseReleased(mouseX, mouseY, button);
        }

    }
}
