package com.qteam.Quasar.api.Events.HITLEREvents;

import com.qteam.Quasar.api.MegaEvents.Base.Event;

public class GammaBrightnessEvent extends Event {

    public float gamma;

    public GammaBrightnessEvent(float delta) {
        this.gamma = delta;
    }
}
