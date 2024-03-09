package org.example;

import org.example.structureEx.PriceMapEx;

import java.util.HashMap;
import java.util.Map;

public class ViewEx {

    static HashMap<String, Integer> priceRepository = PriceMapEx.priceRepository;
    static int lastHashMapPrice = 1350000;
    static String lastKey = "아이폰14";

    public static void nameInfoView(){
        System.out.print("제픔명(순서 없음): ");
        for (String name : priceRepository.keySet()) {
            if (name == lastKey){
                System.out.print(name);
                System.out.println();
            }else System.out.print(name + " ");
        }
        System.out.println();

    }

    public static void priceInfoView(){
        System.out.print("제품의 가격(순서 없음): ");
        for (Integer price:priceRepository.values()) {
            if (price == lastHashMapPrice){
                System.out.print(price);
                System.out.println();
            }else System.out.print(price+ " ");
        }
        System.out.println();
    }

    public static void itemInfoView(){
        for(Map.Entry<String, Integer> entry : priceRepository.entrySet()){
            System.out.println("제품 정보: " + entry.getKey() +" / "+entry.getValue());
        }
        System.out.println();

    }

    public static void selectedPriceInfoView(String keyName){

        System.out.println(keyName + " 모델의 가격은 얼마인가요?: " + priceRepository.get(keyName));
    }
}
