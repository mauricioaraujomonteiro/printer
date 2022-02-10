package com.github.mauricioaraujomonteiro.component1;


import com.github.mauricioaraujomonteiro.component1.converter.HexConverter;

public class InputFrame {

    private final QueueService queueService;

    public InputFrame(QueueService queueService) {
        this.queueService = queueService;
    }
    public void write(String message) {
        queueService.add(HexConverter.toHexString(message));
    }
}
