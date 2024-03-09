package org.example;

import org.example.structureEx.PriceMapEx;

public class ServiceEx {
    public static void itemSave(){
        PriceMapEx.priceRepository.put("아이폰14", 1350000);
        PriceMapEx.priceRepository.put("아이폰15Pro", 1550000);
        PriceMapEx.priceRepository.put("아이폰15ProMax", 1900000);
        PriceMapEx.priceRepository.put("맥북프로M3Pro", 2990000);
    }
}
