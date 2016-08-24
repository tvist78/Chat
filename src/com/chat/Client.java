package com.chat;

import java.net.Socket;

/**
 * Created by tvist on 19.05.16.
 */
public class Client {

    private String stringConnect;
    private int portConnect;


    public Client(){
         this("127.0.0.1",8888);
    }

    public Client(String stringConnect, int portConnect){
        this.stringConnect = stringConnect;
        this.portConnect = portConnect;
    }

    public void connect(){
        Socket socketClient = new Socket();
    }
}
