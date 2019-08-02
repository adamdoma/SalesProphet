import java.io.*;
import java.net.Socket;

public class EchoThread extends Thread {
    protected Socket socket;

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
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
                System.out.println(line);
                dos.println("hi there");
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}