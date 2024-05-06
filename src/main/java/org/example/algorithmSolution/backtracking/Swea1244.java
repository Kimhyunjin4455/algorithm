package org.example.algorithmSolution.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Swea1244 {
    static int C;
    static int[] numsList;
    static int ans;
    static String number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc <= TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            number = String.valueOf(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            numsList = new int[number.length()];
            for(int i=0; i<number.length(); i++){
                numsList[i] = number.charAt(i) - '0'; // 문자형 숫자값에서 문자0을 빼면 정수값 구해짐
            }

            if(numsList.length < C){ //
                C = numsList.length;
            }   /** 자리수만큼 교환 기회가 주어진다면 선택 정렬에 의해서 무조건 내림차순으로 정렬하여 최대 상금을 획득 */
                /** 로직은 각 자리에 대해 dfs를 수행하는 것이므로 숫자길이만큼의 교환만 진행하면 됨*/
            ans = Integer.MIN_VALUE;
            dfs(0,0);
            //System.out.println("#"+ tc +" "+ans);

            bw.write("#"+tc+" "+ans);
            bw.newLine();

        }
        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int start, int idx) {
        if(idx == C){
            int result = 0;
            //  값을 합치고 현재값과 이번값중에 최댓값 구하기
            for(int i=0; i<number.length(); i++){
                result += (Math.pow(10,i) * numsList[numsList.length-i-1]); /** Math.pow(N,i): N의 i제곱 */
            }
            ans = Math.max(ans, result);
            return;
        }

//        for(int i = start; i< numsList.length; i++){
//            for (int j=i+1; j< numsList.length; j++){
//                if(numsList[i] <= numsList[j]) {
//                    int temp = numsList[j];
//                    numsList[j] = numsList[i];
//                    numsList[i] = temp;
//
//                    dfs(i, idx + 1);
//
//                    temp = numsList[j];
//                    numsList[j] = numsList[i];
//                    numsList[i] = temp;
//                }
//            }
//        }

        for(int i=start; i<numsList.length-1; i++){ // 선택정렬 이용
            int minIndex = start;
            for (int j= i+1; j<numsList.length; j++){
                if(numsList[j] > numsList[minIndex]){
                    minIndex = j;
                }
                int temp = numsList[j];
                numsList[j] = numsList[i];
                numsList[i] = temp;
                dfs(start, idx+1);
                temp = numsList[j];
                numsList[j] = numsList[i];
                numsList[i] = temp;
            }
        }

    }

}
