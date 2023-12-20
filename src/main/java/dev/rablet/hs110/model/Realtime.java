package dev.rablet.hs110.model;

import com.google.gson.annotations.SerializedName;

public class Realtime {
    // V2 of the devices use this naming convention
    @SerializedName("voltage_mv")
    private Double voltageMv;
    @SerializedName("current_ma")
    private Double currentMa;
    @SerializedName("power_mw")
    private Double powerMw;
    @SerializedName("total_wh")
    private Double totalWh;

    // V1 of the devices uses this naming convention
    private Double voltage;
    private Double current;
    private Double power;
    private Double total;

    @SerializedName("err_code")
    private int errCode;

    /**
     * Returns the current in Amps
     * 
     * Special handling is needed here since devices with hw_ver >= 2 returns data
     * in mA
     * 
     * @return double the current in Amps
     */
    public double getCurrent() {
        if (this.current != null) {
            return this.current;
        } else {
            return this.currentMa / 1000.00;
        }
    }

    /**
     * Returns the voltage in Volts
     * 
     * Special handling is needed here since devices with hw_ver >= 2 returns data
     * in mV
     * 
     * @return double the voltage in Volts
     */
    public double getVoltage() {
        if (this.voltage != null) {
            return this.voltage;
        } else {
            return this.voltageMv / 1000.00;
        }
    }

    /**
     * Returns the power in Watts
     * 
     * Special handling is needed here since devices with hw_ver >= 2 returns data
     * in mW
     * 
     * @return double the power in Watts
     */
    public double getPower() {
        if (this.power != null) {
            return this.power;
        } else {
            return this.powerMw / 1000.00;
        }
    }

    /**
     * Returns the total consumption in kWh
     * 
     * Special handling is needed here since devices with hw_ver >= 2 returns data
     * in Wh
     * 
     * @return the total consumption in kWh
     */
    public double getTotal() {
        if (this.total != null) {
            return this.total;
        } else {
            return this.totalWh / 1000.00;
        }
    }

    public void setVoltageMv(Double voltageMv) {
        this.voltageMv = voltageMv;
    }

    public void setCurrentMa(Double currentMa) {
        this.currentMa = currentMa;
    }

    public void setPowerMw(Double powerMw) {
        this.powerMw = powerMw;
    }

    public void setTotalWh(Double totalWh) {
        this.totalWh = totalWh;
    }

    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }

    public void setCurrent(Double current) {
        this.current = current;
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
                " voltage='" + getVoltage() + "'" +
                ", current='" + getCurrent() + "'" +
                ", power='" + getPower() + "'" +
                ", total='" + getTotal() + "'" +
                ", errCode='" + getErrCode() + "'" +
                "}";
    }

}
