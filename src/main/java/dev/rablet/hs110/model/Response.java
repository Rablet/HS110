package dev.rablet.hs110.model;

public class Response {
    private Emeter emeter;
    private System system;

    public Emeter getEmeter() {
        return this.emeter;
    }

    public void setEmeter(Emeter emeter) {
        this.emeter = emeter;
    }

    public System getSystem() {
        return this.system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    @Override
    public String toString() {
        return "{" +
                " emeter='" + getEmeter() + "'" +
                ", system='" + getSystem() + "'" +
                "}";
    }
}
