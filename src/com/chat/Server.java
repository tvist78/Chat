package com.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tvist on 23.08.16.
 */
public class Server { public static final int PORT = 1510;
    public static final int MAX_CLIENTS = 5;
    public static final int TIME_OUT = 50000;

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {

            System.out.println("Create new server socket at port " + PORT);
            ss = new ServerSocket(PORT, MAX_CLIENTS);
            ss.setSoTimeout(TIME_OUT);
            System.out.println("Waiting for a client...");
            while (true) {
                socket = ss.accept();
                System.out.println("Client accepted: " + socket);

                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                String userText;
                do {
                    userText = in.readUTF();
                    System.out.println(userText);
                    out.writeUTF(userText);
                    out.flush();
                    if (userText.equalsIgnoreCase("close server")) {
                        break;
                    }
                } while (true);

            }

        } catch (IOException ex) {
            System.err.println(ex);
            //System.exit(-1);
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                    System.out.println("Socket closed");
                }
                if (ss != null) {
                    ss.close();
                    System.out.println("Socket server closed");
                }
                if (in != null) {
                    in.close();
                    System.out.println("Datainput stream closed");
                }
                if (out != null) {
                    out.close();
                    System.out.println("Dataoutput stream closed");
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}


