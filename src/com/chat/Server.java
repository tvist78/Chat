package com.chat;

import com.sun.org.apache.xml.internal.utils.StringToStringTableVector;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Server {
    private int PORT;
    private boolean ActiveServer;
    private ArrayList<Socket> ClientsList;


    public Server() {
        this.PORT = 1501;

    }

    public Server(int port) {

        this.PORT = port;
        ClientsList = new ArrayList<Socket>();
    }

    public void Start (){
        ActiveServer = true;


            try {

                ServerSocket serverSocket = new ServerSocket(PORT);
                while (ActiveServer) {
                    Socket incoming = serverSocket.accept();
                    if(!ActiveServer) break;

                    Runnable r = new ThreadClient(incoming);
                    Thread t = new Thread(r);
                    t.start();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public void Stop(){
    ActiveServer = false;
        try {
            new Socket("localhost",PORT);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private class ThreadClient implements Runnable {
        private Socket incoming;
        private String nameClient;

        Scanner in;
        PrintWriter out;

        ThreadClient(Socket incoming) {

        this.incoming = incoming;
            //System.out.println("qwertt");

        }

        private void setNameClient(String name) {
            if(name !=  null) {
                this.nameClient = name;

            } else this.nameClient = "Anonymous";
        }

     @Override
    public void run(){
         try {
             try{

             boolean done = false;

                 out = new PrintWriter(incoming.getOutputStream(), true);
                 out.println("Please, get your name ->");

                 in = new Scanner(incoming.getInputStream());
                 String name =  in.nextLine();
                 setNameClient(name);
                 out.println("Hello " + this.nameClient + " from Server");
             while (!done && in.hasNextLine()){
                 String line = in.nextLine();
                 out.println("**" + line + "**");
                 if (line.trim().equals("bye")) done = true;
                 if (line.trim().equals("time")) {
                     Date now = new Date();
                     out.write(now.toString() + "\r\n");
                     out.flush();
                 }
             }
             } finally {
                 incoming.close();
             }

         } catch (IOException e) {
             e.printStackTrace();
         }
     }
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


