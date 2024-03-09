package org.example.structureEx;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueEx {
    // 큐의 맨 앞은 프런트(front)로 정하여 삭제 연산만 수행
    // 큐의 맨 뒤는 리어(rear)로 정하여 삽입 연산만 수행


    public void qEx(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(5);
        queue.offer(10);
        System.out.println(queue);
        System.out.println(queue.peek());       // 맨 앞에 데이터 조회 및 반환, Queue가 비어 있다면 null 반환
        System.out.println(queue.element());    // 맨 앞에 데이터 조회 및 반환, Queue가 비어 있다면 예외 발생
        System.out.println();

        for (int i:queue) {
            if (i == 10) {
                System.out.println(i);
            }else
                System.out.print(i +" ");
        }
        System.out.println();

        Iterator iter = queue.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() + " ");
            if (iter.hasNext()==false) System.out.println();
        }
        System.out.println();

        queue.stream().forEach(System.out::print);
        System.out.println();

        System.out.println();
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println();

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.peek());
        try{
            System.out.println(queue.element());
        }catch (NoSuchElementException e){
            //System.out.println("빈 큐 일때 element 메서드 사용시 예외가 발생합니다.");
            e.getStackTrace();
            // 예외가 발생된 부분만 출력하면 불필요한 로깅이 줄어들고 성능에도 이점이 생길 수 있음
        }finally {
            System.out.println("terminate.");
        }

    }
}
