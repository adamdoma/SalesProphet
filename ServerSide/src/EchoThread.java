import com.google.gson.Gson;
import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;


public class EchoThread extends Thread {
    protected Socket socket;
    private boolean connected, userConnectd;

    private Gson gson =new Gson();
    private User user;
    private dbConnection dbConnection;
    private DataInputStream dis = null;
    private PrintWriter dos =null;
    private String line="";




    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
        this.userConnectd =false;
        this.connected = true;
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new PrintWriter(socket.getOutputStream(),true);

        } catch (IOException e) {
            return;
        }
    }

    public void run() {
        while (connected) {

            try {
                line = dis.readLine();
                if(line.contains("login")&& userConnectd == false)
                    dos.println(Login());

            } catch (IOException e) {
                System.out.println(socket.getInetAddress()+" Client Disconnected");
                try {
                    socket.close();
                    dos.close();
                    dis.close();
                    dbConnection.closeConnection();
                    connected =false;
                    userConnectd = false;
                } catch (IOException ex) {
                    System.out.println("system Disconnected");
                }
            }

        }//end while loop
    }

    private String Login(){
        user =new User(gson.fromJson(line, User.class));
        if(HelperClass.userEmailTest(user.getEmail())){
            dbConnection = new dbConnection();
            if(dbConnection.checkIfUserExists(user.getEmail(),user.getPassword(),this.user)) {
                System.out.println(socket.getInetAddress()+
                        " "
                        +user.getFirstName()+
                        " "+
                        user.getLastName()+
                        " is connected to database");
                userConnectd =true;
                return "true";
            }
            else {
                System.out.println("User do not exist");
                return "false";
            }
        }
        else {
            return "false";
        }
    }
}

