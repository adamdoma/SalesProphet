import java.io.*;
import java.net.Socket;

public class EchoThread extends Thread {
    protected Socket socket;

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        InputStream inp = null;
        BufferedReader brinp = null;
        PrintWriter out = null;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
            out = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            return;
        }
        String line;
        while (true) {
            try {
                line = brinp.readLine();
                if ((line == null) || line.toLowerCase()=="quit") {
                    socket.close();
                    return;
                } else {
                    if(HelperClass.userEmailTest(line)){
                        out.println("Email ok");
                    }else{
                        out.println("Retype Email");
                    }
//                    out.println("HHHHHHHHH");
//                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
