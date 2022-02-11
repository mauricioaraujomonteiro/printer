package com.github.mauricioaraujomonteiro.port.spi;

public interface QueueManagerService {

    void sendMessage(String message);

    String read();
}
