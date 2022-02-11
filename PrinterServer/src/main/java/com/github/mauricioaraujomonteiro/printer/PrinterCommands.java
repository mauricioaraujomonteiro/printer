package com.github.mauricioaraujomonteiro.printer;

public enum PrinterCommands {
    EXIT("#EXIT#");

    private String command;

    PrinterCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }
}
