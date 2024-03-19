package org.example.algorithmSolution.problem;

import java.util.ArrayList;
import java.util.List;

public class ProcessManagementQueue {
    public static void main(String[] args) {
        ProcessManagement.Solution sol = new ProcessManagement.Solution();
//        int[] priorities = new int[]{2, 1, 3, 2}; // 값이 3(2번째 인덱스)인 것의 우선순위가 가장 높음
//        int location = 2;
        int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(sol.solution(priorities, location));
    }

    static class Solution {
        public int solution(int[] priorities, int location){
            /** location의 값을 줄여나가며 answer 계산 */
            int answer = 0;
            List<Integer> processList = new ArrayList<>();

            for(int num: priorities){
                processList.add(num);
            }

            while (!processList.isEmpty()){
                int removingProcess = processList.remove(0);    // 삭제
                for(int process : processList){
                    if(removingProcess < process){
                        processList.add(removingProcess);
                    }else {         // 제일 큰값이라면 다시 추가하지 않음
                        answer++;   // 실행횟수 +1
                        if(location == 0) break;
                    }
                }
                location --;
                if(location < 0) location = processList.size()-1;

            }

            return answer;
        }
    }
}
