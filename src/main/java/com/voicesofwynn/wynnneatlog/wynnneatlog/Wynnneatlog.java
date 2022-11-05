package com.voicesofwynn.wynnneatlog.wynnneatlog;

import com.voicesofwynn.wynnneatlog.wynnneatlog.NeatLog.NeatLogger;
import net.fabricmc.api.ModInitializer;

public class Wynnneatlog implements ModInitializer {


    public static NeatLogger neatLogger;

    @Override
    public void onInitialize() {
        neatLogger = new NeatLogger();

    }
}
