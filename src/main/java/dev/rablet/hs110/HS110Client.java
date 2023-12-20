package dev.rablet.hs110;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringJoiner;

import com.google.gson.Gson;

import dev.rablet.hs110.model.Realtime;
import dev.rablet.hs110.model.Response;
import dev.rablet.hs110.model.SysInfo;

public class HS110Client {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(HS110Client.class);

    private String host;
    private int port;

    /**
     * The default port to use for connections
     */
    private static final int DEFAULT_PORT = 9999;

    /**
     * The initial keys to use for encryption and decryption
     */
    private static final byte INITIAL_KEY = (byte) 171;

    /**
     * Creates an HS110Client with a specified host and port
     * 
     * @param host the hostname to connect to
     * @param port the port to connect to
     */
    public HS110Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * Creates an HS110Client with a specified host using the default port
     * (DEFAULT_PORT)
     * 
     * @param host the host to connect to
     */
    public HS110Client(String host) {
        this(host, DEFAULT_PORT);
        LOG.debug("Using default port: {}", DEFAULT_PORT);
    }

    /**
     * Internal helper function to create a String from a byte array
     * 
     * @param bArray the byte array to stringify
     * @return the string representation of the byte array
     */
    private String printBytes(byte[] bArray) {
        StringJoiner sj = new StringJoiner(" ");

        for (byte b : bArray) {
            sj.add(b + "");
        }
        return sj.toString();
    }

    /**
     * Sends a command to the HS110 and returns a decrypted response
     * 
     * @param command the command to send
     * @return the decrypted response
     * @throws IOException
     */
    private String sendCommand(String command) throws IOException {
        String decryptedResponse = null;
        LOG.debug("Creating new socket to {}:{}", host, port);
        try (Socket clientSocket = new Socket(host, port)) {
            OutputStream out = clientSocket.getOutputStream();
            InputStream stream = clientSocket.getInputStream();
            LOG.debug("Sending Command: {}", command);
            out.write(encryptMessage(command));
            out.flush();
            byte[] data = new byte[4096];
            int count = stream.read(data);
            data = Arrays.copyOf(data, count);

            LOG.debug("Bytes read = {}", count);
            decryptedResponse = decryptMessage(data);
        } catch (IOException e) {
            throw e;
        }
        return decryptedResponse;
    }

    /**
     * Get the current realtime stats from the HS110
     * 
     * @return the stats
     * @throws IOException
     */
    public Realtime getRealtime() throws IOException {
        String command = """
                {
                    "emeter": {
                      "get_realtime": ""
                    }
                  }""";

        String decryptedResponse = sendCommand(command);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Decrypted response to get_realtime command: {}", decryptedResponse);
        }

        Gson gson = new Gson();

        Response emeter = gson.fromJson(decryptedResponse, Response.class);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Parsed object from get_realtime response: {}", emeter);
        }
        return emeter.getEmeter().getRealtime();
    }

    /**
     * Gets the system info from the HS110
     * 
     * @return the system info
     * @throws IOException
     */
    public SysInfo getSystemInfo() throws IOException {
        String command = """
                {
                    "system": {
                      "get_sysinfo": {}
                    }
                  }""";
        String decryptedResponse = sendCommand(command);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Decrypted response to get_sysinfo command: {}", decryptedResponse);
        }
        Gson gson = new Gson();

        Response system = gson.fromJson(decryptedResponse, Response.class);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Parsed object from get_sysinfo response: {}", system);
        }
        return system.getSystem().getSysinfo();
    }

    /**
     * Encrypts the command to send to the HS110
     * 
     * @param msg the plaintext command
     * @return the encrypted command
     */
    private byte[] encryptMessage(String msg) {
        LOG.debug("Encrypting: {}", msg);
        byte[] plainMsg = msg.getBytes();
        byte[] encryptedMsg = new byte[plainMsg.length + 4];

        int length = plainMsg.length;

        encryptedMsg[0] = (byte) (length >> 24);
        encryptedMsg[1] = (byte) (length >> 16);
        encryptedMsg[2] = (byte) (length >> 8);
        encryptedMsg[3] = (byte) length;

        byte key = INITIAL_KEY;

        for (int i = 0; i < plainMsg.length; i++) {
            byte encryptedByte = (byte) (key ^ plainMsg[i]);
            key = encryptedByte;
            encryptedMsg[i + 4] = encryptedByte;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Encrypted message: {}", printBytes(encryptedMsg));
        }

        return encryptedMsg;
    }

    /**
     * Decrypts a response from HS110
     * 
     * @param encryptedMsg the encrypted response
     * @return the plaintext response
     */
    private String decryptMessage(byte[] encryptedMsg) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Decrypting message: {}", printBytes(encryptedMsg));
        }
        byte[] plainMsg = new byte[encryptedMsg.length - 4];

        byte key = INITIAL_KEY;

        for (int i = 4; i < encryptedMsg.length; i++) {
            byte decryptedByte = (byte) (key ^ encryptedMsg[i]);
            key = encryptedMsg[i];
            plainMsg[i - 4] = decryptedByte;
        }

        String decryptedMessage = new String(plainMsg, StandardCharsets.UTF_8);
        LOG.debug("Decrypted message: {}", decryptedMessage);

        return decryptedMessage;
    }

}
