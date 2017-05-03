package com.acseed.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by caohongchen on 17-3-11.
 */
public class TimeClient {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("QUERY TIME ORDER");
            System.out.println("send order to server succeed.");
            String resp = in.readLine();
            System.out.println("Now is " + resp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                in.close();
            }
            if (null != out) {
                out.close();
            }

            if (null != socket) {
                socket.close();
            }
        }
    }
}
