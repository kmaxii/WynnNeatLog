package com.voicesofwynn.wynnneatlog.wynnneatlog;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Utils {

    public static void sendMessage(String text) {
        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of("§5[NeatLogger]§r " + text));
    }

}
