package com.voicesofwynn.wynnneatlog.wynnneatlog.events.mixins;

import com.voicesofwynn.wynnneatlog.wynnneatlog.events.ReceiveChatEvent;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.MessageType;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class MixinChatListener {

    @Inject(at = @At("RETURN"), method = "onGameMessage")
    public void onMessage(GameMessageS2CPacket par1, CallbackInfo ci) {
        if (par1.getType() == MessageType.CHAT || par1.getType() == MessageType.SYSTEM) {
            String message = par1.getMessage().getString();
            if (!message.startsWith("§5[Voices of wynn]§r")) {
                ReceiveChatEvent.receivedChat(message);
            }
        }
    }
}
