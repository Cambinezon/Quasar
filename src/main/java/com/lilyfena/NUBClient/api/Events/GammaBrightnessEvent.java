package com.lilyfena.NUBClient.api.Events.HITLEREvents;

import com.lilyfena.NUBClient.api.MegaEvents.Base.Event;

public class GammaBrightnessEvent extends Event {

    public float gamma;

    public GammaBrightnessEvent(float delta) {
        this.gamma = delta;
    }
}
