package com.github.mauricioaraujomonteiro;

import com.github.mauricioaraujomonteiro.component1.InputFrame;
import com.github.mauricioaraujomonteiro.component1.QueueService;
import com.github.mauricioaraujomonteiro.component1.SenderConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class App {



    public static void main(String[] args) throws IOException {
        final QueueService queueService = new QueueService();
        InputFrame inputFrame = new InputFrame(queueService);
        SenderConverter senderConverter = new SenderConverter(queueService);
        Scanner scanner = new Scanner(System.in);


        while(scanner.hasNext()) {
            final String text = scanner.next();



            if ("exit".equals(text)) {
                System.exit(0);
            }
            inputFrame.write(text);
            System.out.println(text);
            senderConverter.read();


            System.out.println("Message read -> " + queueService.read());
            System.out.println("Message read -> " + queueService.read());



        }
    }
}
