package org.example.algorithmSolution.problem;

import java.util.*;

public class ProcessManagement {
    // 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냄
    // 큐에 대기중인 프로세스 중 우선순위가 "더 높은" 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣음 (높은 게 없다면 방금 꺼낸 프로세스를 실행)
    // 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] priorities = new int[]{2, 1, 3, 2}; // 값이 3(2번째 인덱스)인 것의 우선순위가 가장 높음
        int location = 2;
//        System.out.println(sol.solution(priorities, location)); // merge 충돌로 인해 다시 쓰기
    }

    static class Solution {

//        SelectedProcess selectedProcess;
//        SelectedProcess answerProcess;
//        public int solution(int[] priorities, int location) {
//            int answer = 0;
//            // 하나 꺼내기
//            ArrayList<SelectedProcess> processList = new ArrayList<>();
//
//            for(int i=0; i<priorities.length; i++){
//                processList.add(new SelectedProcess(priorities[i], i)); /** 우선순위와 위치를 저장할 객체 배열 생성 */
//            }
//
//            while(!processList.isEmpty()){
//                // 우선순위가 높은 값이 존재한다면 삭제 후 뒤로 다시 넣기
//                SelectedProcess selectedProcess = processList.remove(0);
//                if(processList.stream().anyMatch(otherProcess -> selectedProcess.priority < otherProcess.priority)){ // for 을 통해 하나씩 꺼내어 값비교(가장 큰값인지) 가능
//                    // processList의 요소를 하나씩 꺼내어, anyMatch (조건 만족하는것이 하나라도 있는지)
//                    processList.add(selectedProcess);
//                }else{
//                    answer ++;
//                    if(location == selectedProcess.location){
//                        break;
//                    }
//                }
//
//            }
//
//            return answer;  // 해당 프로세스가 몇번째로 실행되는지
//        }
//        class SelectedProcess{
//            int priority;
//            int location;
//            SelectedProcess(int priority, int location){
//                this.priority = priority;
//                this.location = location;
//            }
//        }
    }
}
