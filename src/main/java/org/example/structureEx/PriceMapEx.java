package org.example.structureEx;

import java.util.HashMap;

public class PriceMapEx {
    // Entry: 키와 값의 쌍
    // 해시 함수를 사용하는 HashMap의 경우 검색 속도가 상대적으로 빠른 편
    // TreeMap, LinkedHashMap 등의 구현체
    // 동적으로 크기를 조절가능 -> 저장 공간을 효율적으로 활용 ( 메모리 사용량이 줄어들어 전체 성능 향상에 도움 )


    // TreeMap
    // 키(key)에 대한 정렬을 보장하는 이진 검색 트리(binary search tree)의 확장
    // 키(key)를 기준으로 오름차순
    // 키에 null 값을 사용할 수 없음( 값(value)는 null을 저장 가능 )
    // 사용자 정의 정렬 사용 시 Comparator / Comparable 구현 필요


    // LinkedHashMap
    // 키와 값 쌍을 저장한 순서대로 조회
    // 키-값 쌍의 삽입, 삭제 및 조회에 있어서 빠른 성능
    // 키와 값에 null 저장 가능


    public static HashMap<String, Integer> priceRepository = new HashMap<>();


}
