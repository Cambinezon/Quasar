package com.lilyfena.NUBClient.api.Events.HITLEREvents;

import com.lilyfena.NUBClient.api.MegaEvents.Base.Event;

public class RenderHudPostEvent extends Event {
    private final float partialTicks;

    public RenderHudPostEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return this.partialTicks;
    }
}
