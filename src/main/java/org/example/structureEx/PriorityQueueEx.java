package org.example.structureEx;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueEx {
    // 선입선출 + 요소정렬 + 우선순위 높은 요소 먼저 처리
    // 힙 이용해 구현( Max Heap(최대 힙) : 최대 값이 우선순위인 큐, Min Heap(최소 힙) : 최소 값이 우선순위인 큐 ), 이진트리 구조
    // 우선순위에 따라 자동 정렬, 정렬된 상태를 유지하면서 데이터를 빠르게 추가
    // 크기가 고정되어 있지 않음
    // 시간 복잡도는 O(log n) 상대적으로 느림
    // 저장할 객체는 필수적으로 Comparable 인터페이스를 구현해야 함

    public class Age implements Comparable<Age>{
        private String name;
        private int age;
        public Age(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Age otherAge){
            return Integer.compare(this.age, otherAge.age);
        }
        // 객체를 비교할 수 있도록 만듬
        // compareTo() 메소드가 바로 우리가 객체를 비교할 기준을 정의해주는 부분
        // 선행 원소가 후행 원소보다 작으면, 반환값이 음수 -> 두 원소는 오름차순 상태라는 의미이므로 두 원소가 교환되지 않음
        // 선행 원소가 후행원소보다 크면, 반환값이 양수 -> 정렬 알고리즘에서는 두 원소를 비교할 때 두 원소는 내림차순 상태라는 의미이므로 두 원소가 교환됨
        // * 내림차순 시 반환값의 부호를 반대로 설정
        // Comparable: compareTo, Comparator: compare

        @Override
        public String toString(){
            return name + " (Age: "+age+")";
        }
    }
    
    public void priorityEx(){
        PriorityQueue<Integer> pqLowest = new PriorityQueue<>();    // 최소 힙
        PriorityQueue<Integer> pqHighest = new PriorityQueue<>(Collections.reverseOrder());

        pqLowest.add(0);    // 큐가 꽉 찬 경우 에러 발생
        pqLowest.add(1);
        pqLowest.add(100);
        pqLowest.add(5);
        pqLowest.offer(1000); // 값 추가 실패 시 false를 반환
        pqLowest.add(2);
        // 데이터를 추가한 순서와 상관없이 우선순위 큐만의 정렬 방식으로 출력
        System.out.println(pqLowest);
        System.out.println();

        System.out.println(pqLowest.size());
        System.out.println();

        System.out.println(pqLowest.peek()); // 0이 우선순위 제일 높음, 큐가 비어있으면 null 반환 (반환은 wrapper 타입)
        System.out.println();

        for (Integer i:pqLowest) {
            System.out.print(i + " ");
        }
        System.out.println();

        Iterator<Integer> iter = pqLowest.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next()+" ");
        }
        System.out.println();

        pqLowest.stream().forEach(System.out::print);
        System.out.println();

        System.out.println();
        // 루트 노드 기준으로 삭제 진행
        pqLowest.poll();
        System.out.println(pqLowest);   // 우선 순위가 가장 높은 값 삭제, 비어있다면 null
        System.out.println();

        pqLowest.remove();
        System.out.println(pqLowest);   // 우선순위가 가장 높은 값을 삭제, 비어있다면 예외 발생
        System.out.println();


        pqLowest.clear();
        System.out.println(pqLowest);
        System.out.println();


        PriorityQueue<Age> pq = new PriorityQueue<>();
        pq.add(new Age("Kim", 27));
        pq.add(new Age("hyun", 25));
        pq.add(new Age("jin", 23));

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
}
