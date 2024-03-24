package org.example.binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BinarySearch2343 {
    // 영상의 길이의 합 기준
    // 0. mid에 대한 범위
    // 0-2. (최소 1개의 블루레이는 존재해야 함 그러므로 강의 리스트중 제일 큰값 한개들어갈 공간은 있어야 함)
    // 0-3. mid가 될 수 있는 값의 최댓값은 배열의 요소를 모두 더한 값(영상 길이의 합계)
    // 1. mid의 값을 구하고
    // 2. mid보다 작을때까지 값을 더해나감, 커지는순간 종료하고 블루레이 갯수+1
    // 3-1. 블루레이 개수가 M보다 크다면 start = mid+1
    // 3-2. 블루레이 개수가 M보다 작다면 end = mid-1
    // 3-3. 같다면 mid의 값이 답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] videoLengths = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        int longestLength = 0;
        int sumLength = 0;
        for(int i=0; i<N; i++){
            videoLengths[i] = Integer.parseInt(st.nextToken());
            longestLength = Math.max(longestLength, videoLengths[i]);
            sumLength += videoLengths[i];
        }

        int start = longestLength;
        int end = sumLength;
        int cnt = 0;

        while (start<=end){
            int mid = (start+end)/2;
            int blueray = 0;
            int resultLength = 0;

            for(int i = 0; i<N; i++){


                // blueray값이 21이 안되도록
                if(blueray + videoLengths[i] < mid){
                    blueray += videoLengths[i];
                }else{
                    cnt++;
                    resultLength = Math.max(resultLength, blueray);
                    System.out.println("blueray = " + blueray);
                    blueray = 0;
                }

            }

            if (cnt == M){
                bw.write(String.valueOf(resultLength));
            }
            else if (cnt < M) {
                end = mid-1;
            }else start = mid+1;
        }


        bw.flush();
        bw.close();
        br.close();

    }
}
