package com.lilyfena.NUBClient.mixins;

import com.lilyfena.NUBClient.DY;
import com.lilyfena.NUBClient.api.Events.HITLEREvents.PlayerMoveEvent;
import com.lilyfena.NUBClient.api.Events.HITLEREvents.UpdateInputEvent;
import com.lilyfena.NUBClient.api.MegaEvents.Base.Event;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class MixinClientPlayerEntity extends AbstractClientPlayerEntity {

    @Shadow @Final protected MinecraftClient client;

    @Shadow public float prevNauseaIntensity;

    @Shadow public float nauseaIntensity;

    @Shadow public Input input;

    @Shadow @Final public ClientPlayNetworkHandler networkHandler;

    @Shadow protected int ticksLeftToDoubleTapSprint;

    @Unique
    public int tempTicksLeftToDoubleTapSprint;

    public MixinClientPlayerEntity(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

//    @Override
//    protected boolean clipAtLedge() {
//        return super.clipAtLedge() || (ModuleList.safeWalk.isEnabled() && !SafeWalk.mode.getValue().equals("Legit Shift"));
//    }

//    @Override
//    protected Vec3d adjustMovementForSneaking(Vec3d movement, MovementType type) {
//        Vec3d result = super.adjustMovementForSneaking(movement, type);
//
//        if(movement != null) {
//            ModuleList.safeWalk.onClipAtLedge(!movement.equals(result));
//        }
//
//        return result;
//    }

//    @Inject(method = "updateNausea", at = @At("HEAD"), cancellable = true)
//    @SuppressWarnings("ConstantConditions")
//    public void modifyUpdateNausea(CallbackInfo ci) {
//        if (ModuleList.portalGod.isEnabled()) {
//            ci.cancel();
//
//            prevNauseaIntensity = nauseaIntensity;
//            float f = 0.0F;
//            if (inNetherPortal) {
//
//                if (nauseaIntensity == 0.0F) {
//                    client.getSoundManager().play(PositionedSoundInstance.ambient(SoundEvents.BLOCK_PORTAL_TRIGGER, random.nextFloat() * 0.4F + 0.8F, 0.25F));
//                }
//
//                f = 0.0125F;
//                inNetherPortal = false;
//            } else if (hasStatusEffect(StatusEffects.NAUSEA) && !getStatusEffect(StatusEffects.NAUSEA).isDurationBelow(60)) {
//                f = 0.006666667F;
//            } else if (this.nauseaIntensity > 0.0F) {
//                f = -0.05F;
//            }
//
//            nauseaIntensity = MathHelper.clamp(nauseaIntensity + f, 0.0F, 1.0F);
//            tickPortalCooldown();
//        }
//    }

    @Inject(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/tutorial/TutorialManager;onMovement(Lnet/minecraft/client/input/Input;)V"))
    public void modifyTickMovementPreItemSlow(CallbackInfo ci) {
        tempTicksLeftToDoubleTapSprint = ticksLeftToDoubleTapSprint;
    }

    @Inject(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/input/Input;tick(ZF)V", shift = At.Shift.AFTER))
    public void modifyTickMovementAfterInputTick(CallbackInfo ci) {
        DY.EVENT_BUS.activate(new UpdateInputEvent());
    }

//    @Inject(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;canStartSprinting()Z"))
//    public void modifyTickMovementPostItemSlow(CallbackInfo ci) {
//        if (ModuleList.noSlow.isEnabled() && NoSlow.useItems.getValue()) {
//            input.movementSideways *= 5;
//            input.movementForward *= 5;
//            ticksLeftToDoubleTapSprint = tempTicksLeftToDoubleTapSprint;
//        }
//    }
//
//    @Inject(method = "tickMovement", at = @At("HEAD"))
//    @SuppressWarnings("ConstantConditions")
//    public void modifyTickMovement(CallbackInfo ci) {
//        if (ModuleList.elytraFlight.isEnabled() && ElytraFlight.mode.equals("1.12.2 Control")) {
//            if (ModuleList.elytraFlight.travelPacket != null) {
//                if (ModuleList.elytraFlight.travelPacket.rotate()) {
//                    client.getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.LookAndOnGround(ModuleList.elytraFlight.travelPacket.rot().x, ModuleList.elytraFlight.travelPacket.rot().y, client.player.isOnGround()));
//                }
//                client.player.ticksSinceLastPositionPacketSent++;
//            }
//        }
//    }
//
//    @Inject(method = "pushOutOfBlocks", at = @At("HEAD"), cancellable = true)
//    public void modifyPushOutOfBlocks(double x, double z, CallbackInfo ci) {
//        if (ModuleList.noPush.isEnabled())
//            if (NoPush.blocks.getValue())
//                ci.cancel();
//    }
//
    @Inject(method = "move", at = @At("HEAD"), cancellable = true)
    public void modifyMove(MovementType movementType, Vec3d movement, CallbackInfo ci) {
        if (((Object) this) == client.player) {
            Event event = new PlayerMoveEvent();
            DY.EVENT_BUS.activate(event);
            if (event.isCancelled())
                ci.cancel();
        }
    }
}
