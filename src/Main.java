import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int client = 0;
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted: " + (client++));
            OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());

            osw.write("HTTP/1.1 200 OK\r\n");
            osw.write("Content-Type: text/html\r\n");
            osw.write("\r\n");

            osw.write("<h2>Hello</h2>");

            osw.flush();
            osw.close();
            clientSocket.close();
        }
    }
}
