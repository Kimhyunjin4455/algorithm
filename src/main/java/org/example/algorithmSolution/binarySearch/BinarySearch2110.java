package org.example.algorithmSolution.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch2110 {
    public static void main(String[] args) throws IOException {
        // 거리 기준 -> 최소 거리에 따라 설치할 수 있는 공유기의 개수가 달라짐
        // '설치 해야 할 공유기의 개수(C)'와 같은 거리 중 최대로 가질 수 있는 '최소 거리' == '최소 거리에 대해 설치 가능한 공유기'
        // mid 거리에 대해 설치 가능한 공유기 개수가 C 개수에 못미치면 거리를 좁혀야 하기 때문에 end 를 줄인다.
        // 설치 가능한 공유기 개수가 C 개수보다 크거나 같으면 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를 찾음

        // 최소거리에 따라 설치할 수 있는 공유기 수가 정해지게 되는데, 최소 거리중 최대일 때를 찾아내는 것
        // 최소거리의 값을 갱신해나가며 답 찾기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];

        for(int i=0; i<N; i++){
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        // 최소거리 설정
        // 최소거리 이상 중 첫번째 집에 공유기 설 그리고 현재 위치에 대해 다시 계산
        // 최종 공유기 갯수로 비교

        int start = 1; // 최소 간격
        int end = houses[N-1] - houses[0]; //  입력 된 집의 최대 간격



        while (start <= end){
            int mid = (start + end)/2; // 최소 거리에 대한 기준
            int cnt = 1; // 맨 처음 1에 공유기 설치된것 가정
            int standardPosition = 0;

            for(int i=1; i<N; i++){
                if(houses[i] - houses[standardPosition] >= mid){
                    cnt++;
                    standardPosition = i;
                }
            }

            if(cnt < C){
                end = mid-1;
            }
            else { // cnt == C 라 해도, 최댓값을 찾기 위해 while(start <= end) 범위 동안 진행
                // 정렬이 되어있기에 이 다음으로 진행했을때 start는 같거나 커질 수 밖에 없음
                start = mid+1;
            }
        }

        bw.write(String.valueOf(start-1));
        //bw.write(String.valueOf(end));

        bw.flush();
        bw.close();
        br.close();
    }
}
