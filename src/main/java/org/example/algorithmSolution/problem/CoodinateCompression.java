package org.example.algorithmSolution.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CoodinateCompression {
    public static void main(String[] args) throws IOException {
        // BufferedReader 는 문자열을 한 줄로 읽기 때문에 두 번째 라인을 구분하기 위해 공백을 기준으로 문자열을 분리해주어야  -> StringTokenizer 필요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] origin = new int[n];
        int[] sortedArr = new int[n];
        HashMap<Integer, Integer> rankMap = new HashMap<>(); // 등수 매길 용도

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++){
            sortedArr[i] = origin[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(sortedArr);

        int rank = 0;
        for (int v:sortedArr) {
            if(!rankMap.containsKey(v)){
                rankMap.put(v,rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key:origin) {
            Integer ranking = rankMap.get(key);
            sb.append(ranking).append(' ');
        }

        System.out.println(sb);



//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//
//        int[] origin = new int[n];
//        int[] sortedArr = new int[n];
//
//        HashMap<Integer, Integer> rankHashMap = new HashMap<>();
//
//        for (int i=0; i<n; i++){
//            sortedArr[i] = origin[i] = sc.nextInt();
//        }
//
//        Arrays.sort(sortedArr);
//
//        int rank = 0;
//        for(int v: sortedArr){
//            if(!rankHashMap.containsKey(v)){    // 중복되지 않을 때만
//                rankHashMap.put(v, rank);
//                rank++;                         // 다음 순위 위해 1증가
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int key:origin) {
//            int ranking = rankHashMap.get(key);
//            sb.append(ranking).append(' ');
//        }
//
//        System.out.println(sb);
    }
}
