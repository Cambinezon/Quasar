package com.qteam.Quasar.api.Events.HITLEREvents;

import com.qteam.Quasar.api.MegaEvents.Base.Event;

public class RenderHudPostEvent extends Event {
    private final float partialTicks;

    public RenderHudPostEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return this.partialTicks;
    }
}
