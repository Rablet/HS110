package dev.rablet.hs110;

import java.io.IOException;

import dev.rablet.hs110.model.Realtime;

public class Main {
    public static void main(String[] args) {
        HS110Client hs110 = new HS110Client("hs110airpurifier");
        HS110Client hs110deHum = new HS110Client("hs110dehumidifier");
        try {
            Realtime hs110Realtime = hs110.getRealtime();
            System.out.println(hs110Realtime);

            hs110.getSystemInfo();
            hs110deHum.getRealtime();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Hello world!");
    }
}