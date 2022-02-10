package com.github.mauricioaraujomonteiro.component2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PrinterServer {

    private ServerSocket serverSocket;



    public void start(Integer port) {
        try {
            serverSocket = new ServerSocket(port);
            while(true){
                final PrinterMultiClientHandler printerMultiClientHandler = new PrinterMultiClientHandler(serverSocket.accept());
                new Thread(printerMultiClientHandler)
                        .run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        PrinterServer server = new PrinterServer();
        server.start(9090);
    }
}
