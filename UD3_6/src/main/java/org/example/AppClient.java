package org.example;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;

public class AppClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 49154;

        try (Socket socket = new Socket(InetAddress.getLocalHost(), port)){
            new AppClientHandler(socket).sendCommand();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
