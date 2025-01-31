package com.lilyfena.NUBClient.api.Events.HITLEREvents;

import com.lilyfena.NUBClient.api.MegaEvents.Base.Event;
import net.minecraft.entity.projectile.FireworkRocketEntity;

public class FireworkTickEvent extends Event {
    public FireworkRocketEntity firework;

    public FireworkTickEvent(FireworkRocketEntity firework) {
        this.firework = firework;
    }
}
