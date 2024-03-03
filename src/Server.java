import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        int clientCounter = 0;
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted: " + (++clientCounter));

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream())
            );

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );

            String request = reader.readLine();
            // Thread.sleep(5000);  //  Useful for testing multi-client
            String response = "#" + clientCounter + " request length " + request.length();

            writer.write(response);
            writer.newLine();
            writer.flush();

            writer.close();
            reader.close();
            clientSocket.close();
        }
    }
}
