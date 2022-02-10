package com.github.mauricioaraujomonteiro.component1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SenderConverter {
    private final QueueService queueService;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    public SenderConverter(QueueService queueService ){
        this.queueService = queueService;
    }
    public void read() throws IOException {
        final String read = queueService.read();
        createConnection("localhost", 9090);
        out.println(read);
        closeConnection();
    }

    private void closeConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createConnection(String ip, Integer port) throws IOException  {
        clientSocket =  new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    }
}
