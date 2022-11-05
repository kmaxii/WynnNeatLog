package com.voicesofwynn.wynnneatlog.wynnneatlog.events;

import com.voicesofwynn.wynnneatlog.wynnneatlog.NeatLog.LineData;
import com.voicesofwynn.wynnneatlog.wynnneatlog.NeatLog.LineFormatter;
import com.voicesofwynn.wynnneatlog.wynnneatlog.Wynnneatlog;
import net.minecraft.client.MinecraftClient;

public class ReceiveChatEvent {


    public static void receivedChat(String msg) {

        //Replace player Name with "soldier"
        String name = GetPlayerName(msg);
        if (msg.contains(name)) {
            msg = msg.replace(name, "soldier");
        }


        LineData lineData = LineFormatter.formatToLineData(msg);

        String message = lineData.getRealLine();

        if (!LineFormatter.isNPCSentLine(message) && !msg.contains("Press SHIFT to continue")){
            return;
        }

        Wynnneatlog.neatLogger.ReceivedChat(message);
    }



    private static String GetPlayerName(String eventMessageToString) {

        String realName = MinecraftClient.getInstance().player.getEntityName();

        String segments[] = eventMessageToString.split("hoverEvent=HoverEvent\\{action=SHOW_TEXT, value='TextComponent\\{text='");
        if (segments.length <= 1) return realName;

        String name = segments[segments.length - 1].split("',")[0];
        if (name.contains("Previous")) return realName;
        return name.split("'")[0];

    }

}


