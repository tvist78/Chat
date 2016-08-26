package com.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    private int PORT;
    private boolean ActiveServer;
    private ArrayList<Socket> ClientsList;


    public Server() {
        this.PORT = 1501;

    }

    public Server(int port) {

        this.PORT = port;
    }

    public void Start (){
        ActiveServer = true;
        while (ActiveServer) {

            try {
                int i = 1;
                ServerSocket serverSocket = new ServerSocket(12345);

                while (true) {
                    Socket incoming = serverSocket.accept();
                    System.out.println("Spawning " + i);
                    Runnable r = new ThreadeEchoHandler(incoming);
                    Thread t = new Thread(r);
                    t.start();
                    i++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void Stop(){

    }
    /*
    private static final int PORT  = 9999;

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
    }*/
}


