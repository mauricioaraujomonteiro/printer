package com.github.mauricioaraujomonteiro.usecases;

import com.github.mauricioaraujomonteiro.listener.QueueListenerService;
import com.github.mauricioaraujomonteiro.port.api.PrinterUseCases;
import com.github.mauricioaraujomonteiro.port.spi.PrinterServerPort;
import com.github.mauricioaraujomonteiro.service.queue.QueueService;

import java.util.Objects;

public class PrinterUseCaseImpl implements PrinterUseCases {

    private final QueueService queueManagerService;

    public PrinterUseCaseImpl(PrinterServerPort printerServerPort){
        this.queueManagerService = new QueueService();
        new QueueListenerService(queueManagerService, printerServerPort);
    }

    public void write(String message) {
        if (Objects.nonNull(message)) {
            queueManagerService.send(message);
        }
    }
}
