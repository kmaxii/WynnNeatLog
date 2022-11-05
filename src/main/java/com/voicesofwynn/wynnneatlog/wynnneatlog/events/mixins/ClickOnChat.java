package com.voicesofwynn.wynnneatlog.wynnneatlog.events.mixins;

import com.voicesofwynn.wynnneatlog.wynnneatlog.NeatLog.LineFormatter;
import com.voicesofwynn.wynnneatlog.wynnneatlog.Wynnneatlog;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.Style;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Screen.class)

public class ClickOnChat {


    @Inject(at = @At("RETURN"), method = "handleTextClick")
    public void OnChatClick(Style style, CallbackInfoReturnable<Boolean> cir) {
        if (style == null)
            return;

        ClickEvent clickEvent = style.getClickEvent();
        if (clickEvent == null || !clickEvent.getValue().contains("/dialogue ")) return;

        int dialogueClicked = Integer.parseInt(clickEvent.getValue().replace("/dialogue ", ""));

        Wynnneatlog.neatLogger.AddEmptyLineIfTrue();
        Wynnneatlog.neatLogger.write("//" + LineFormatter.dialogueChoices.get(dialogueClicked));


    }

}
