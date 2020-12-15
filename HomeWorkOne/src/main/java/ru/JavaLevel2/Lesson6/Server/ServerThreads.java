package ru.JavaLevel2.Lesson6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerThreads extends Thread {
   private int port;

    public ServerThreads(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Waitting for new connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client has been connected");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            while (true) {
                String message = in.readUTF();
                System.out.println("Client message"+message);
                if (message.equals("/exit")) break;
                out.writeUTF("Echo" + message);
            }
            System.out.println("Server has been closed");
        } catch (SocketException e){
            System.err.println("Server port is already opened!");
            //e.printStackTrace();
            //e.getCause();
        }
        catch (IOException e) {
            System.err.println("Connection has been closed!");
            e.printStackTrace();
            e.getCause();
        }
    }
}
