package org.example.algorithmSolution.binarySearch;

import java.io.*;
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


        while (start<=end){
            int mid = (start+end)/2;
            int sum = 0;
            int cnt = 0;

            for(int i = 0; i<N; i++){
                if(sum + videoLengths[i] > mid){
                    sum = 0;
                    cnt++;
                    // sum += videoLengths[i];

                }
                /** else 사용 시 틀림 -> else를 사용하면 'sum + videoLengths[i] > mid' 때 sum에 현재 인덱스값이 더해지지 않음 */
                /** 위 if문의 주석 해제하고 아래의 else 적용은 가능 but 가독성 떨어지는 코드*/
                sum += videoLengths[i];
                //else{
                //    sum += videoLengths[i];
                //}

            }
            if(sum != 0) cnt++; // 위 반복문 후반부에 'sum + videoLengths[i] > M' 만족없이 'sum += videoLengths[i];' 만 진행하면 cnt +1 필요

            if (cnt <= M) { // M 개수내로 가능한 블루레이의 크기 중 최소를 구하기 위해
                end = mid-1;
            }else {
                start = mid + 1;
            }

        }

        bw.write(String.valueOf(start));



        bw.flush();
        bw.close();
        br.close();

    }
}
