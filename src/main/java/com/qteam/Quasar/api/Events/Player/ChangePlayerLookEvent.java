package com.qteam.Quasar.api.Events.HITLEREvents.Player;

import com.qteam.Quasar.api.MegaEvents.Base.Event;

public class ChangePlayerLookEvent extends Event {

    public final double cursorDeltaX;
    public final double cursorDeltaY;

    public ChangePlayerLookEvent(double cursorDeltaX, double cursorDeltaY) {
        this.cursorDeltaX = cursorDeltaX;
        this.cursorDeltaY = cursorDeltaY;
    }
}
