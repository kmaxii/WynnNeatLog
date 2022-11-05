package com.voicesofwynn.wynnneatlog.wynnneatlog.NeatLog;


public class LineData {

    private String soundLine;
    private String realLine;

    public String getSoundLine() {
        return soundLine;
    }

    public void setSoundLine(String soundLine) {
        this.soundLine = soundLine;
    }

    public String getRealLine() {
        return realLine;
    }

    public void setRealLine(String realLine) {
        this.realLine = realLine;
    }

    public String getNPCName(){
        String[] split = realLine.split(": ");
        return split[0].trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "").replaceAll("[0-9]", "");
    }

}
