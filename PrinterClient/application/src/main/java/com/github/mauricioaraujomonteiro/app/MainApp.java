package com.github.mauricioaraujomonteiro.app;

import com.github.mauricioaraujomonteiro.infra.PrinterConnector;
import com.github.mauricioaraujomonteiro.port.api.PrinterUseCases;
import com.github.mauricioaraujomonteiro.port.spi.PrinterServerPort;
import com.github.mauricioaraujomonteiro.usecases.PrinterUseCaseImpl;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        PrinterServerPort printerServerPort = new PrinterConnector();
        PrinterUseCases printerUseCases = new PrinterUseCaseImpl(printerServerPort);
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        while(scanner.hasNext()) {
            final String text = scanner.next();

            if ("exit".equals(text)) {
                System.exit(0);
            }

            printerUseCases.write(text);



        }
    }
}
