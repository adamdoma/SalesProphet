import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    static final int PORT = 5000;

    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Waiting for client");
        } catch (IOException e) {
            e.printStackTrace();

        }
        while (true) {
            try {
                socket = serverSocket.accept();
                System.out.println(socket.getInetAddress()+" Connected");
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            new EchoThread(socket).start();
        }
    }
}