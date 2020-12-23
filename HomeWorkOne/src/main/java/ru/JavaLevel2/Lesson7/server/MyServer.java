package ru.JavaLevel2.Lesson7.server;

import ru.JavaLevel2.Lesson7.server.Handler.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyServer {

    private final List<ClientHandler> clients = new ArrayList<>();
    private final AuthService authService;

    public MyServer() {
        this.authService = new BaseAuthService();
    }

    public void start(int port) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер был запущен");
            runServerMessageThread();
            authService.start();
            //noinspection InfiniteLoopStatement
            while (true) {
                waitAndProcessNewClientConnection(serverSocket);
            }
        } catch (IOException e) {
            System.err.println("Failed to accept new connection");
            e.printStackTrace();
        } finally {
            authService.stop();
        }
    }

    private void runServerMessageThread() {
        Thread serverMessageThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String serverMessage = scanner.next();
                try {
                    broadcastMessage("Сервер: " + serverMessage, null);
                } catch (IOException e) {
                    System.err.println("failed to process serverMessage");
                    e.printStackTrace();
                }
            }
        });
        serverMessageThread.setDaemon(true);
        serverMessageThread.start();
    }

    private void waitAndProcessNewClientConnection(ServerSocket serverSocket) throws IOException {
        System.out.println("Ожидание нового подключения....");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Клиент подключился");// /auth login password
        processClientConnection(clientSocket);
    }

    private void processClientConnection(Socket clientSocket) throws IOException {
        ClientHandler clientHandler = new ClientHandler(this, clientSocket);
        clientHandler.handle();
    }

    public synchronized void broadcastMessage(String message, ClientHandler sender) throws IOException {
        for (ClientHandler client : clients) {
            if (client == sender) {
                continue;
            }

            client.sendMessage(message);
        }
    }
    //Метод отправки приватного сообщения
    public synchronized void recipientMeaasge(String message,ClientHandler sender, String recipient) throws IOException {
        // Проверка на отправку самаому себе
        if (sender.getNickname().equals(recipient)) sender.sendMessage("(Server:) Вы пытаетесь отправить сообщение самому себе!");
        boolean isMessageSend = false;//Флаг было ли отправлено сообщение приватному пользователю

        for (ClientHandler client : clients) {
            if (client == sender) {//Пропустить самого себя
               continue;
            }
            if (client.getNickname().equals(recipient)) {//Если найдено совподение, то
                isMessageSend = true;//Установить флаг отправки сообщения
                client.sendMessage(message);//Послать приватное сообщение
                sender.sendMessage("(Private message to " + client.getNickname() + ") message: " + message);//Сообщение себе, что приватное сообщенеи ушло пользователю
            }
        }
        if(!isMessageSend) sender.sendMessage("(Сервер:) Ошибка, нет такого пользователя!");//Если пользователь не найден, то отправить сообщение об ошибке
    }

    public synchronized void subscribe(ClientHandler handler) {
        clients.add(handler);
    }

    public synchronized void unsubscribe(ClientHandler handler) {
        clients.remove(handler);
    }

    public AuthService getAuthService() {
        return authService;
    }

    public synchronized boolean isNickBusy(String nickname) {
        for (ClientHandler client : clients) {
            if (client.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }
}
