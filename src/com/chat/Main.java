package com.chat;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) throws IOException {

       Server server = new Server(8888);
       server.Start();
/*

       
        try {
            int i = 1;
            ServerSocket serverSocket = new ServerSocket(12345);
            
            while (true)
            {
                Socket incoming = serverSocket.accept();
                System.out.println("Spawning " + i);
                Runnable r = new ThreadeEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private static class ThreadeEchoHandler implements Runnable {
        Socket incoming;

        public ThreadeEchoHandler(Socket in) {
            incoming = in;
        }

        @Override
        public void run() {
            try
            {
                try
                {
                    InputStream inputStream = incoming.getInputStream();
                    OutputStream outputStream = incoming.getOutputStream();

                    Scanner in = new Scanner(inputStream);

                    PrintWriter out = new PrintWriter(outputStream, true);

                    boolean done = false;
                    while (!done && in.hasNextLine()){
                        String line = in.nextLine();
                        out.println("Hello from port:12345 -> " + line);
                        if (line.trim().equals("bye")) done = true;
                    }

                } finally {
                    incoming.close();
                }
            }catch (IOException e) {
                e.printStackTrace();

            }

        }*/
    }


}

