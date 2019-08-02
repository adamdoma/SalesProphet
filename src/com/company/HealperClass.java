package com.company;

import java.io.*;
import java.net.Socket;


public class HealperClass {
    static Socket socket=null;
    static String line=null;
//    static ObjectInputStream ois=null;
//    static ObjectOutputStream oop =null;
    static PrintWriter dos =null;
    static  DataInputStream dis=null;

    /**
     * Connects the user to the server
     * @return socket
     */
    public static Socket Connect(){
        if (socket==null){
            try {
                socket = new Socket("127.0.0.1",5000);
                dis = new DataInputStream(socket.getInputStream());
                dos = new PrintWriter(socket.getOutputStream(),true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return socket;
    }
}
