package com.github.mauricioaraujomonteiro.infra;


import com.github.mauricioaraujomonteiro.infra.exception.RetryException;
import com.github.mauricioaraujomonteiro.port.spi.PrinterServerPort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class PrinterConnector implements PrinterServerPort {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void print(String message) throws RetryException {
        try {
            if (Objects.isNull(clientSocket) || clientSocket.isClosed()) {
                createConnection("localhost", 9090);
            }
            out.println(message);
        } finally {
            closeConnection();
        }

    }

    private void closeConnection() {
        try {
            System.out.println("Releasing connection");
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {

            //log something
        } catch (Exception ex) {
            //log something
        }

    }

    private void createConnection(String ip, Integer port) {
        try {
            System.out.println("Creating connection");
            clientSocket =  new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException ex) {
            throw new RetryException("Printer not available");
        }



    }
}
