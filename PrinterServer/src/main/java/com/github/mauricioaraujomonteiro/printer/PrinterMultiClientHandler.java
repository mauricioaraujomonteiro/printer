package com.github.mauricioaraujomonteiro.printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import static com.github.mauricioaraujomonteiro.printer.converter.MessageConverter.toAscII;

public class PrinterMultiClientHandler implements Runnable {

    private final Socket socket;

    public PrinterMultiClientHandler(Socket socket) {
        this.socket = socket;
    }


    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String text;
            while ((text = in.readLine()) != null) {
                text = toAscII(text);
                if (PrinterCommands.EXIT.getCommand().equals(text)) {
                    System.out.println("exit printer");
                    break;
                }
                System.out.println("printing message "+ text);
            }
        } catch (IOException e) {
            //log something

        }

    }
}
