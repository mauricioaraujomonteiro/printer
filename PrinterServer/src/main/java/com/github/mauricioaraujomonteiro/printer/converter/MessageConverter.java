package com.github.mauricioaraujomonteiro.printer.converter;

public class MessageConverter {
    public static String toAscII(String hexStr) {
        System.out.println(String.format("Converting %s to asc", hexStr));
        StringBuilder output = new StringBuilder("");

        for (int i = 0; i < hexStr.length(); i += 2) {
            String str = hexStr.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }

        return output.toString();
    }

}
