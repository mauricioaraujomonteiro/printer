package com.github.mauricioaraujomonteiro.component2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class PrinterMultiClientHandler implements Runnable {

    private final Socket socket;

    public PrinterMultiClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (PrinterCommands.EXIT.equals(inputLine)) {
                    break;
                }
                System.out.println(inputLine);
            }
        } catch (IOException e) {


        }

    }
}
