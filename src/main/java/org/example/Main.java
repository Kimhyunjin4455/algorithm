package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        StringBufferEx sbe = new StringBufferEx();
//        sbe.stringBufferEx();

//        ConsoleInputEx inex = new ConsoleInputEx();
//        inex.inputEx();

//        FileInputEx input = new FileInputEx();
//        input.outputEx();

//        HashMapEx hashMapEx = new HashMapEx();
//        hashMapEx.printMap();

//        LinkedListEx linkedListEx = new LinkedListEx();
//        linkedListEx.linkedListEx();

//        PriorityQueueEx pqEx = new PriorityQueueEx();
//        pqEx.priorityEx();

//        ListEx listEx = new ListEx();
//        listEx.listEx();

//        QueueEx queueEx = new QueueEx();
//        queueEx.qEx();

        ServiceEx.itemSave();
        ViewEx.nameInfoView();
        ViewEx.priceInfoView();
        ViewEx.itemInfoView();
        ViewEx.selectedPriceInfoView("아이폰14");
        ViewEx.selectedPriceInfoView("맥북프로M3Pro");


    }
}