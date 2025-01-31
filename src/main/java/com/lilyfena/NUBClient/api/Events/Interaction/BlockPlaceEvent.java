package com.lilyfena.NUBClient.api.Events.HITLEREvents.Interaction;

import com.lilyfena.NUBClient.api.MegaEvents.Base.Event;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;

public class BlockPlaceEvent extends Event {
    private final ItemPlacementContext itemPlacementContext;
    private final BlockState blockState;

    public BlockPlaceEvent(ItemPlacementContext itemPlacementContext, BlockState blockState) {
        this.itemPlacementContext = itemPlacementContext;
        this.blockState = blockState;
    }

    public BlockState getBlockState() {
        return blockState;
    }

    public BlockPos getBlockPos() {
        return itemPlacementContext.getBlockPos();
    }

    public ItemPlacementContext getItemPlacementContext() {
        return itemPlacementContext;
    }
}
