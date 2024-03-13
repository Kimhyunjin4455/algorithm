package org.example.algorithmSolution.dfs;

public class TargetNumber {
    static int[] numbers;
    static int answer;
    static int target;

    static void dfs(int index, int sum){
        // 2. 탈출 조건 설정
        if(index == numbers.length){
            if(sum == target)answer++;
            return;
        }

        // 1. 수행동작 구현
        dfs(index+1, sum+numbers[index]);
        dfs(index+1, sum-numbers[index]);

        // 3.재귀의 흐름 생각해보기
    }

    public static int solution(int[] numbers, int target){
        answer = 0;
        TargetNumber.numbers = numbers;
        TargetNumber.target=target;

        dfs(0,0);

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args){
        TargetNumber.solution(new int[]{1,1,1,1,1},3);
    }
}
