package com.chat;

import java.net.Socket;


public class Client {

    private String stringConnect;
    private int portConnect;


    public Client(){
         this("127.0.0.1",1501);
    }

    public Client(String stringConnect, int portConnect){
        this.stringConnect = stringConnect;
        this.portConnect = portConnect;
    }

    public void connect(){
        Socket socket = new Socket();
    }
}
