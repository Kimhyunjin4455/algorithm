package org.example.structureEx;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListEx {
    // 빈번한 삽입 및 삭제에 적합( 요소의 추가 및 제거가 빠름 )
    // 노드 포인터로 인한 더 많은 메모리 오버헤드
    // 중간에 있는 요소를 검색 또는 수정하는 데 느림 ( 인덱스x )
    public void linkedListEx(){
        // 초기의 크기를 미리 설정 불가
        // new LinkedList<>()와 같이 타입을 생략 가능 but 사용 타입을 명시해 주는 것이 좋음
        LinkedList list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        LinkedList<Integer> list3 = new LinkedList<>(); // 타입 선언 생략 가능
        LinkedList<Integer> list4 = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4));

        list1.add(0);
        list1.addFirst(100);
        list1.addLast(500);
        list1.add(0,1000);
        System.out.println(list1.contains(500));    // LinkedList에 500이 있으면 true, 없으면 false
        System.out.println(list1.indexOf(5));       // LinkedList에 Object가 있는 index 반환 , 없으면 -1 반환
        System.out.println();

        System.out.println(list1);
        System.out.println();

        System.out.print("반복문(get(i)): ");
        for (int i=0; i<list1.size(); i++){
            System.out.print(list1.get(i) + " ");
            if(i==list1.size()-1) System.out.println();
        }
        System.out.print("forEach: ");
        for (Object i: list1) {
            System.out.print(i + " ");
            if(i == list1.get(list1.size()-1)) System.out.println();
        }

        System.out.print("Iterator: ");
        Iterator iter = list1.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
            if (iter.hasNext() == false) System.out.println();
        }

        System.out.print("forEach(java8): ");
        list1.forEach(i-> {
            if(list1.get(list1.size()-1) == i){
                System.out.print(i+" ");
                System.out.println();
            }else
                System.out.print(i+" ");
        });
        System.out.println();

        list1.set(3,5000);
        System.out.println(list1);
        System.out.println();

        list1.remove(3);
        System.out.println(list1);
        list1.removeFirst();
        System.out.println(list1);
        list1.removeLast();
        System.out.println(list1);
        list1.clear();
        System.out.println("현재 리스트: " +list1);


    }
}
