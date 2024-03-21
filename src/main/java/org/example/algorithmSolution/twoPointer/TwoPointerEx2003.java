package org.example.algorithmSolution.twoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class TwoPointerEx2003 {
    // 투포인터는 연속적인 값들을 이용해 푸는 문제에 적합
    // 배열의 하나의 인덱스를 가리키는 Start 점과 End 점 생성하기
    // 처음 start와 end는 0으로 초기화
    // start 점부터 end점까지의 합을 구해서 sum에 저장, 처음 sum은 0에서 0까지니까 배열의 0번째 인덱스 값이 저장
    // 배열 반복시 아래의 조건
    //      1. sum == 찾고자 하는 값 -> 값을 만족하는 구간을 찾았으니 cnt(카운트 개수)를 하나 늘려주고,
    //                              sum의 값에서 start인덱스의 값을 빼주고 1을 늘려줌 그리고 end값을 1을 더한 후 그 인덱스의 값을 sum에 더함
    //      2. sum < 찾고자 하는 값 -> sum이 더 작으니까 값을 늘려주어야 함, start 값은 그대로 두고, end 값을 1 늘려주고 그 end 인덱스의 값을 sum에 더힘
    //      3. sum > 찾고자 하는 값 -> sum이 더 크니까 값을 줄여주어야 함, end 값은 그대로 두고, start 인덱스 값을 sum에서 빼주고 start값을 1 늘려서 갱신
    static int N,M;
    static int[] arr;
    static int start, end;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        start = 0;
        end = 0;
        sum = 0;
        int cnt =0;

// #1
//        while(start < N){
//            if(sum > M || end == N){
//                sum -= arr[end];
//                end++;
//            } else{
//                sum += arr[start];
//                start++;
//            }
//
//            if (sum==M) cnt++;
//        }

// #2
//        while(true){
            // 포인터가 배열의 끝(N)에 도착했을 때
            // sum>= m이면 아직 탐색할 구간이 남았으므로 s의 값을 이동해주면서 구간 탐색 더함
            // sum<m이면 더 이상 탐색해봤자 sum보다 큰 값은 안나오므로 반복문을 종료
//            if(sum >= M){
//                sum -= arr[start];
//                start ++;
//            } else if (end == N) {
//                break;
//            }else {
//                sum += arr[end];
//                end++;
//            }
//
//            if(sum == M) cnt++;
//        }

// #3
        while (start<N){
            if(sum > M || end == N){
                sum -= arr[start];
                start++;
            }else {
                sum += arr[end];
                end++;
            }

            if(sum == M) cnt++;
        }


        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
        br.close();
    }

}
