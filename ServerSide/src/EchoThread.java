import java.io.*;
import java.net.Socket;

public class EchoThread extends Thread {
    protected Socket socket;
    private boolean connected;

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
        String line;
        while (true) {
            try {
                line = dis.readLine();
                System.out.println("From ip: "+socket.getLocalAddress()+" "+line);
                if(HelperClass.userEmailTest(line) && !connected){
                    dos.println("true");
                    connected = true;
                }
                else
                    dos.println("false");
            } catch (IOException e) {
                System.out.println(socket.getInetAddress()+" Client Disconnected");
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                return;
            }
        }
    }

    private  class df{

    }
}

