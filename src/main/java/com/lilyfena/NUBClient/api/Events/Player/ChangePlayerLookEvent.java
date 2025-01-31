package com.lilyfena.NUBClient.api.Events.HITLEREvents.Player;

import com.lilyfena.NUBClient.api.MegaEvents.Base.Event;

public class ChangePlayerLookEvent extends Event {

    public final double cursorDeltaX;
    public final double cursorDeltaY;

    public ChangePlayerLookEvent(double cursorDeltaX, double cursorDeltaY) {
        this.cursorDeltaX = cursorDeltaX;
        this.cursorDeltaY = cursorDeltaY;
    }
}
