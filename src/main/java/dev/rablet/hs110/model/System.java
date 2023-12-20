package dev.rablet.hs110.model;

import com.google.gson.annotations.SerializedName;

public class System {
    @SerializedName("get_sysinfo")
    private SysInfo sysinfo;

    public SysInfo getSysinfo() {
        return this.sysinfo;
    }

    public void setSysinfo(SysInfo sysinfo) {
        this.sysinfo = sysinfo;
    }

    @Override
    public String toString() {
        return "{" +
                " sysinfo='" + getSysinfo() + "'" +
                "}";
    }

}
