package org.example;

import org.example.input.ConsoleInputEx;
import org.example.input.FileInputEx;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        StringBufferEx sbe = new StringBufferEx();
//        sbe.stringBufferEx();

//        ConsoleInputEx inex = new ConsoleInputEx();
//        inex.inputEx();
        FileInputEx input = new FileInputEx();
        input.outputEx();
    }
}