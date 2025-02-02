package com.qteam.Quasar.api.FIs;

//import com.ferra13671.BThack.api.Interfaces.Mc;
import com.qteam.Quasar.impl.Mc;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public interface PlayerController extends Mc {


    boolean breakBlock(BlockPos pos);

    boolean startBlockBreaking(BlockPos pos, Direction direction);

    boolean updateBlockBreaking(BlockPos pos, Direction direction);

    void cancelBlockBreaking();

    void tick();

    void sendPacket(Packet<?> packet);

    void onDisconnect(String reason);

    void syncSelectedSlot();

    ActionResult interactBlock(ClientPlayerEntity player, Hand hand, BlockHitResult hitResult);

    ActionResult interactItem(PlayerEntity player, Hand hand);

    void attackEntity(PlayerEntity player, Entity target);

    ActionResult interactEntity(PlayerEntity player, Entity entity, Hand hand);

    ActionResult interactEntityAtLocation(PlayerEntity player, Entity entity, EntityHitResult hitResult, Hand hand);

    void clickSlot(int syncId, int slotId, int button, SlotActionType actionType, PlayerEntity player);

    void stopUsingItem(PlayerEntity player);

    boolean isBreakingBlock();

    int getBlockBreakingProgress();

    void closeScreen();
}
