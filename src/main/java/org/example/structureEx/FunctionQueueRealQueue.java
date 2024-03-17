package org.example.structureEx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionQueueRealQueue {
    public static void main(String[] args) {
        int[] progress = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};
        int[] result = solution(progress, speeds);
        for(int i : result){
            System.out.print(i+ " ");
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=0; i<progresses.length; i++){
            //queue.add((int)Math.ceil((100.0 - progresses[i])/speeds[i]));
            double cntDay = (double) (100 - progresses[i]) / speeds[i];
            int originDay = (int)Math.ceil(cntDay);
            queue.add(originDay);
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int value = queue.poll(); // 제거하고 반환
            int cnt = 1;

            while (!queue.isEmpty() && value >= queue.peek()){ // value가 맨 앞 요소의 값 이상이라면
                cnt++;
                queue.poll();

            }
            result.add(cnt);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
