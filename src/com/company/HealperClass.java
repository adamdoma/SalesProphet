package com.company;

import java.io.*;
import java.net.Socket;


public class HealperClass {
    static Socket socket=null;
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


    public static void closeSocket(){
        try {
            if(socket != null)
                socket.close();
        } catch (IOException e) {
            System.out.println("Unable to close or already closed socket "+e.getMessage());
        }
    }

    /**
     * inner class for login
     */
    public static class Login{
        private String username;
        private String password;
        private final String TYPE = "Password";

        public Login(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTYPE() {
            return TYPE;
        }
    }
}
