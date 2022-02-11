package com.github.mauricioaraujomonteiro.listener;

import com.github.mauricioaraujomonteiro.converter.MessageConverter;
import com.github.mauricioaraujomonteiro.port.spi.PrinterServerPort;
import com.github.mauricioaraujomonteiro.service.queue.QueueService;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

import static com.github.mauricioaraujomonteiro.converter.MessageConverter.toAscII;

public class QueueListenerService implements PropertyChangeListener {

    private final QueueService queueService;
    private final PrinterServerPort printerServerPort;

    public QueueListenerService(QueueService queueService, PrinterServerPort printerServerPort) {
        this.queueService = queueService;
        this.printerServerPort = printerServerPort;
        queueService.registerListener(this);
    }

    public void read() {
        String message = queueService.read();
        final String converted = MessageConverter.toHex(message.getBytes());
        if (Objects.isNull(converted)) {
            //some logs
            return;
        }
        sentToPrinter(converted);
    }

    private void sentToPrinter(String message) {
        System.out.println("sending to printer");

        // todo - checks the exceptions, if necessary back the message to the queue
        try {
            printerServerPort.print(message);
        } catch (Exception ex) {
            //Add the exception in a common project to evaluate if it should retry
            message = toAscII(message);
            queueService.send(message);
        }


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("add".equals(evt.getNewValue())) {
            read();
        }
    }
}
