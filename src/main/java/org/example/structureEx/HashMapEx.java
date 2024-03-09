package org.example.structureEx;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HashMapEx {
    // 빠른 검색이 필요한 데이터 구조( 검색 기능, 캐싱에 유용 )
    // 저장공간보다 값이 더 들어오면 저장공간을 약 두배로 늘림( 이 때 과부하 발생 ) -> 초기 용량 지정 추천
    // 삽입 순서 유지X( 키의 해시 함수에 따라 데이터가 저장되기 때문 )
    // null 키와 null 값이 허용( null 키는 단 하나만 존재 가능 )
    public void printMap(){

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("I'm",1);
        hashMap.put("kim",2);
        hashMap.put("hyun",3);
        hashMap.put("jin",4);
        System.out.println("hashMap = " + hashMap);
        System.out.println("key값 jin = " + hashMap.get("jin"));
        System.out.println();

        // key-value 쌍이 모두 필요한 경우에 사용
        // 많은 양의 데이터를 처리해야 할 경우 entrySet() 추천( key 값을 사용하여 value를 조회하는 과정에서 시간이 더 소요되기 때문 )
        System.out.println("use EntrySet()");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("[KEY]:" + entry.getKey() + ", [VALUE]:" + entry.getValue());
        }
        System.out.println();

        // key 값만 필요한 경우
        System.out.println("use KeySet()");
        for (String i: hashMap.keySet()) {
            System.out.println("[KEY]:" + i + ", [VALUE]:" + hashMap.get(i));
        }
        System.out.println();

        System.out.println("use forEach");
        hashMap.forEach((key, value) -> System.out.println("[KEY]:" + key + ", [VALUE]:" + value));
        System.out.println();

        // HashMap을 key를 기준으로 정렬
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);  // hashMap의 모든 값을 가진 treeMap 생성
        treeMap.forEach((key, value) -> System.out.println("KEY: " +key+ ", VALUE:" +value));
        System.out.println();


        // value 기준으로 오름차순 정렬
        Map<String, Integer> sortedMap = hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new
                ));

        sortedMap.forEach((key, value) -> System.out.println("KEY:" +key+ ", VALUE:" +value));

    }
}
