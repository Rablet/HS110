package dev.rablet.hs110.model;

import com.google.gson.annotations.SerializedName;

public class RelayState {
    @SerializedName("err_code")
    private int errCode;

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    @Override
    public String toString() {
        return "{" +
                " errCode='" + getErrCode() + "'" +
                "}";
    }
}
