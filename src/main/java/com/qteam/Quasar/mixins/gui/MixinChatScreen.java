package com.qteam.Quasar.mixins.gui;

//import com.ferra13671.BThack.Core.Client;
//import com.ferra13671.BThack.api.CommandSystem.manager.CommandManager;
//import com.ferra13671.BThack.api.Interfaces.Mc;
import com.qteam.Quasar.impl.Mc;
import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ChatScreen.class)
public abstract class MixinChatScreen implements Mc {

    @Shadow public abstract String normalize(String chatText);
//
//    @Inject(method = "sendMessage", at = @At("HEAD"), cancellable = true)
//    public void modifySendMessage(String chatText, boolean addToHistory, CallbackInfoReturnable<Boolean> cir) {
//        if (normalize(chatText).startsWith(Quasar.ChatPrefix)) {
//            CommandManager.parseCommand(chatText.replace(Quasar.ChatPrefix, ""));
//            mc.inGameHud.getChatHud().addToMessageHistory(chatText);
//
//            cir.setReturnValue(true);
//            cir.cancel();
//        }
//    }
}
