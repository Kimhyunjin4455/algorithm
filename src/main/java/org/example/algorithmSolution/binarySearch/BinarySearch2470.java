package org.example.algorithmSolution.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int[] solutions = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);
        int minValue = Integer.MAX_VALUE; // 반복을 돌며 이분 탐색 후 0에 가까운 값들을 갱신하기 위한 값
        int res1 = 0;
        int res2 = 0;


        for(int i=0; i<N; i++){
            int current = solutions[i];
            int find = solutions[0];                // 두값의 차이가 최소일때의 solution[mid]를 저장하기 위함
            int smallestAbs = Integer.MAX_VALUE; // 현재 인덱스의 수와 다른 수의 차이가 최소인 값을 저장하기 위함
            int start = i+1;
            int end = N-1;
            int mid = 0;
            while (start <= end){
                mid = (start+end)/2;
                int sum = current + solutions[mid];
                int sumAbs = Math.abs(sum);
//                if(i==3){
//                    System.out.println(current+" "+solutions[mid]);
//                }

                if (sumAbs < smallestAbs){
                    smallestAbs = sumAbs;
                    find = solutions[mid];
                }

                if (sum ==0){
                    find = solutions[mid];
                    break;
                }

                if (sum<0){
                    start = mid+1;
                }else end = mid-1;
            }
            if(Math.abs(current+find) < minValue){  // find대신 solutions[mid] 사용 불가, 마지막 반복아 끝났을때의 mid값이라 두 값의 차이가최소를 만족했던 mid가 아님
                minValue = Math.abs(current+find);
                res1 = Math.min(current, find);
                res2 = Math.max(current, find);
            }

        }








        bw.write(String.valueOf(res1)+" "+String.valueOf(res2));

        bw.flush();
        bw.close();
        br.close();



    }
}
