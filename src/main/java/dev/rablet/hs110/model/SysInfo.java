package dev.rablet.hs110.model;

import com.google.gson.annotations.SerializedName;

public class SysInfo {
    @SerializedName("sw_ver")
    private String swVer;
    @SerializedName("hw_ver")
    private String hwVer;
    private String type;
    private String model;
    private String mac;
    @SerializedName("dev_name")
    private String devName;
    private String alias;
    @SerializedName("relay_state")
    private int relayState;
    @SerializedName("on_time")
    private int onTime;
    @SerializedName("active_mode")
    private String activeMode;
    private String feature;
    private int updating;
    @SerializedName("icon_hash")
    private String iconHash;
    private int rssi;
    @SerializedName("led_off")
    private int ledOff;
    @SerializedName("longitute_i")
    private int longituteI;
    @SerializedName("latitude_i")
    private int latitudeI;
    private String hwId;
    private String fwId;
    private String deviceId;
    private String oemId;
    @SerializedName("next_action")
    private ActionType nextAction;
    @SerializedName("ntc_state")
    private int ntcState;
    @SerializedName("err_code")
    private int errCode;

    public String getSwVer() {
        return this.swVer;
    }

    public void setSwVer(String swVer) {
        this.swVer = swVer;
    }

    public String getHwVer() {
        return this.hwVer;
    }

    public void setHwVer(String hwVer) {
        this.hwVer = hwVer;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMac() {
        return this.mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getDevName() {
        return this.devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getRelayState() {
        return this.relayState;
    }

    public void setRelayState(int relayState) {
        this.relayState = relayState;
    }

    public int getOnTime() {
        return this.onTime;
    }

    public void setOnTime(int onTime) {
        this.onTime = onTime;
    }

    public String getActiveMode() {
        return this.activeMode;
    }

    public void setActiveMode(String activeMode) {
        this.activeMode = activeMode;
    }

    public String getFeature() {
        return this.feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public int getUpdating() {
        return this.updating;
    }

    public void setUpdating(int updating) {
        this.updating = updating;
    }

    public String getIconHash() {
        return this.iconHash;
    }

    public void setIconHash(String iconHash) {
        this.iconHash = iconHash;
    }

    public int getRssi() {
        return this.rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getLedOff() {
        return this.ledOff;
    }

    public void setLedOff(int ledOff) {
        this.ledOff = ledOff;
    }

    public int getLongituteI() {
        return this.longituteI;
    }

    public void setLongituteI(int longituteI) {
        this.longituteI = longituteI;
    }

    public int getLatitudeI() {
        return this.latitudeI;
    }

    public void setLatitudeI(int latitudeI) {
        this.latitudeI = latitudeI;
    }

    public String getHwId() {
        return this.hwId;
    }

    public void setHwId(String hwId) {
        this.hwId = hwId;
    }

    public String getFwId() {
        return this.fwId;
    }

    public void setFwId(String fwId) {
        this.fwId = fwId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOemId() {
        return this.oemId;
    }

    public void setOemId(String oemId) {
        this.oemId = oemId;
    }

    public ActionType getNextAction() {
        return this.nextAction;
    }

    public void setNextAction(ActionType nextAction) {
        this.nextAction = nextAction;
    }

    public int getNtcState() {
        return this.ntcState;
    }

    public void setNtcState(int ntcState) {
        this.ntcState = ntcState;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    @Override
    public String toString() {
        return "{" +
                " swVer='" + getSwVer() + "'" +
                ", hwVer='" + getHwVer() + "'" +
                ", type='" + getType() + "'" +
                ", model='" + getModel() + "'" +
                ", mac='" + getMac() + "'" +
                ", devName='" + getDevName() + "'" +
                ", alias='" + getAlias() + "'" +
                ", relayState='" + getRelayState() + "'" +
                ", onTime='" + getOnTime() + "'" +
                ", activeMode='" + getActiveMode() + "'" +
                ", feature='" + getFeature() + "'" +
                ", updating='" + getUpdating() + "'" +
                ", iconHash='" + getIconHash() + "'" +
                ", rssi='" + getRssi() + "'" +
                ", ledOff='" + getLedOff() + "'" +
                ", longituteI='" + getLongituteI() + "'" +
                ", latitudeI='" + getLatitudeI() + "'" +
                ", hwId='" + getHwId() + "'" +
                ", fwId='" + getFwId() + "'" +
                ", deviceId='" + getDeviceId() + "'" +
                ", oemId='" + getOemId() + "'" +
                ", nextAction='" + getNextAction() + "'" +
                ", ntcState='" + getNtcState() + "'" +
                ", errCode='" + getErrCode() + "'" +
                "}";
    }

}
