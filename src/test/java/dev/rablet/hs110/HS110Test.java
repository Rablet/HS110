package dev.rablet.hs110;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import dev.rablet.hs110.model.Realtime;
import dev.rablet.hs110.model.RelayState;
import dev.rablet.hs110.model.SysInfo;

public class HS110Test {

    @Test
    public void testHS110Realtime() throws IOException {

        HS110Client client = new HS110Client("hs110airpurifier"); // Make this a config

        Realtime rt = client.getRealtime();
        System.out.println(rt);

        assertTrue("Current greater than zero", rt.getCurrent() > 0);
        assertTrue("Total greater than zero", rt.getTotal() > 0);
        assertTrue("Voltage greater than zero", rt.getVoltage() > 0);
        assertTrue("Power greater than zero", rt.getPower() >= 0);
    }

    @Test
    public void testHS110SystemInfo() throws IOException {

        HS110Client client = new HS110Client("hs110airpurifier");

        SysInfo rt = client.getSystemInfo();

        assertNotNull(rt.getDeviceId());
        assertNotNull(rt.getHwVer());
    }

    @Test
    public void testHS110TurnOn() throws IOException {

        HS110Client client = new HS110Client("hs110airpurifier");

        RelayState rs = client.turnOn();

        assertEquals(0, rs.getErrCode());
    }

    @Test
    public void testHS110TurnOff() throws IOException {

        HS110Client client = new HS110Client("hs110airpurifier");

        RelayState rs = client.turnOff();

        assertEquals(0, rs.getErrCode());
    }
}
