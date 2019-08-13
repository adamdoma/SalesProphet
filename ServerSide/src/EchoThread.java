import com.google.gson.Gson;
import java.io.*;
import java.net.Socket;


public class EchoThread extends Thread {
    protected Socket socket;
    private boolean connected;
    private Gson gson =new Gson();
    private HelperClass.Login login;
    private User user;
    private dbConnection dbConnection;




    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
        this.connected = false;
    }

    public void run() {
        DataInputStream dis = null;
        PrintWriter dos =null;
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new PrintWriter(socket.getOutputStream(),true);

        } catch (IOException e) {
            return;
        }
        String line="";
        while (true) {
            try {
                line = dis.readLine();
                login =gson.fromJson(line, HelperClass.Login.class);
                System.out.println("From ip: "+socket.getLocalAddress()+" "+login.getUsername());
                if(HelperClass.userEmailTest(login.getUsername()) && !connected){
                    dbConnection = new dbConnection();
                    if(dbConnection.checkIfUserExists(login.getUsername())) {
                        System.out.println(socket.getInetAddress() + " is connected to database");
                        dos.println("true");
                        connected = true;
                    }
                    else {
                        System.out.println("User do not exist");
                        dos.println("false");
                    }
                }
                else {
                    dos.println("false");

                }
            } catch (IOException e) {
                System.out.println(socket.getInetAddress()+" Client Disconnected");
                try {
                    socket.close();
                } catch (IOException ex) {
                    System.out.println("system Disconnected");

                }
                return;
            }
        }
    }
}

