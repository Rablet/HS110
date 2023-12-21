package dev.rablet.hs110.model;

import com.google.gson.annotations.SerializedName;

public class System {
    @SerializedName("get_sysinfo")
    private SysInfo sysinfo;

    @SerializedName("set_relay_state")
    private RelayState relayState;

    public SysInfo getSysinfo() {
        return this.sysinfo;
    }

    public void setSysinfo(SysInfo sysinfo) {
        this.sysinfo = sysinfo;
    }

    public RelayState getRelayState() {
        return this.relayState;
    }

    public void setRelayState(RelayState relayState) {
        this.relayState = relayState;
    }

    @Override
    public String toString() {
        return "{" +
                " sysinfo='" + getSysinfo() + "'" +
                ", relayState='" + getRelayState() + "'" +
                "}";
    }

}
