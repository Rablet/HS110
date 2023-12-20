package dev.rablet.hs110.model;

import com.google.gson.annotations.SerializedName;

public class Emeter {
    @SerializedName("get_realtime")
    private Realtime realtime;

    public Realtime getRealtime() {
        return this.realtime;
    }

    public void setRealtime(Realtime realtime) {
        this.realtime = realtime;
    }

    @Override
    public String toString() {
        return "{" +
                " realtime='" + getRealtime() + "'" +
                "}";
    }

}
