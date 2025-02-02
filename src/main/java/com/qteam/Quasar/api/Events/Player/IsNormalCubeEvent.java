package com.qteam.Quasar.api.Events.HITLEREvents.Player;

import com.qteam.Quasar.api.MegaEvents.Base.Event;
import net.minecraft.util.math.BlockPos;


public class IsNormalCubeEvent extends Event {
    public BlockPos pos;

    public IsNormalCubeEvent(BlockPos pos) {
        this.pos = pos;
    }
}
