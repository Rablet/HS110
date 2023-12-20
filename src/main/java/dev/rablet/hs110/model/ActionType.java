package dev.rablet.hs110.model;

public class ActionType {

    private int type;

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String toString() {
        return "{" +
                " type='" + getType() + "'" +
                "}";
    }
}
