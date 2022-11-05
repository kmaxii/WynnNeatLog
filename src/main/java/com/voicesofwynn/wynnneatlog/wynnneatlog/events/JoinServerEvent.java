package com.voicesofwynn.wynnneatlog.wynnneatlog.events;

import com.voicesofwynn.wynnneatlog.wynnneatlog.Utils;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;


public class JoinServerEvent {


    private static final DecimalFormat df = new DecimalFormat("0.00");


    public static void run(String ip) {

        Timer timer = new Timer();

        timer.schedule(new SchedulerTask(), 10000L);
    }

    public static class SchedulerTask extends TimerTask {
        @Override
        public void run() {

            String message = "You are using the CleanLogMod. If you no longer need it then make sure to delete it, as the bigger the file gets, the heavier it will become on your pc";
            Utils.sendMessage(message);
        }
    }
}
