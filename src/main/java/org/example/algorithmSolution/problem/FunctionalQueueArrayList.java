package org.example.algorithmSolution;

import java.util.ArrayList;
import java.util.List;

public class FunctionalQueueArrayList {
    public static void main(String[] args) {
        int[] progress = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};
        int[] result = solution(progress, speeds);
        for(int i : result){
            System.out.print(i+ " ");
        }

    }
    // option cmd L: 코드 정

    // 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발 가능
    // 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포 (선입선출 -> Queue 이용)

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<progresses.length; i++){
            // 한개 기능 개발 시 필요한 날짜 계산
            double days = (100-progresses[i]) / (double)speeds[i];
            int ceilDays = (int)Math.ceil(days);    // 올림

            // 함께 배포할 기능의 index 찾기
            int j = i+1;
            for(; j<progresses.length; j++){
                if (progresses[j] + (ceilDays * speeds[j]) < 100){
                    break;
                }
            }

            // 이번에 배포할 기능의 개수 추가
            answer.add(j-i);
            i = j-1;


        }
//        int[] answerArr = new int[answer.size()];
//        for(int i=0; i< answer.size(); i++){
//            answerArr[i] = answer.get(i);
//        }
//        return answerArr;

        return answer.stream().mapToInt(i -> i.intValue()).toArray();   // int[] 형태로 반환
        // 스트림은 컬렉션 혹은 배열 요소를 하나씩 참조하는 동작
        // ArrayList<Integer> answer의 각 Integer 객체를 꺼냄
        // mapToInt 를 통해 Integer -> int
        // Integer 객체가 i라는 변수라면 그 변수의 intValue() 통해 int 값 가져옴
        // int값들을 toArray를 통해 배열로 변환
    }

}
