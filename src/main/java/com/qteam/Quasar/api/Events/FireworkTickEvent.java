package com.qteam.Quasar.api.Events.HITLEREvents;

import com.qteam.Quasar.api.MegaEvents.Base.Event;
import net.minecraft.entity.projectile.FireworkRocketEntity;

public class FireworkTickEvent extends Event {
    public FireworkRocketEntity firework;

    public FireworkTickEvent(FireworkRocketEntity firework) {
        this.firework = firework;
    }
}
