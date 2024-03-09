package org.example;

import org.example.structureEx.PriceMapEx;

import java.util.HashMap;
import java.util.Map;

public class ViewEx {

    public void priceInfoView(HashMap priceRepository){


        System.out.println("맥북프로 M3Pro 모랙의 가격은 얼마인가요?: " + priceRepository.get("맥북프로M3Pro"));

    }
}
