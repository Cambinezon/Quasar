package com.lilyfena.NUBClient.api.Events.HITLEREvents.Player;

import com.lilyfena.NUBClient.api.MegaEvents.Base.Event;
import net.minecraft.util.math.BlockPos;


public class IsNormalCubeEvent extends Event {
    public BlockPos pos;

    public IsNormalCubeEvent(BlockPos pos) {
        this.pos = pos;
    }
}
