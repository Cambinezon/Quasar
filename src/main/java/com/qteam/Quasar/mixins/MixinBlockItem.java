package com.qteam.Quasar.mixins;

import com.qteam.Quasar.Q;
import com.qteam.Quasar.api.Events.HITLEREvents.Interaction.BlockPlaceEvent;
import com.qteam.Quasar.api.MegaEvents.Base.Event;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public class MixinBlockItem {

    @Inject(method = "place(Lnet/minecraft/item/ItemPlacementContext;Lnet/minecraft/block/BlockState;)Z", at = @At("HEAD"), cancellable = true)
    private void modifyPlaceBlock(ItemPlacementContext itemPlacementContext, BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        Event event = new BlockPlaceEvent(itemPlacementContext, blockState);
        Q.EVENT_BUS.activate(event);

        if (event.isCancelled()) {
            cir.cancel();
        }
    }
}
