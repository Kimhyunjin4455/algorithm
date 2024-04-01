package org.example.algorithmSolution.dfs;


import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon14888 {
    static int N;
    static Integer maxValue = Integer.MIN_VALUE;
    static Integer minValue = Integer.MAX_VALUE;
    static int addCnt, subCnt, mulCnt, divCnt;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        // 연산자의 수가 남아있을때, 그 연산을 하며 전체 횟수 +1, 전체횟수가 N-1이 되었을 때 종료
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int basedValue = nums[0]; // dfs 호출할때 마다 연산할 기준이 되는 값

        st = new StringTokenizer(br.readLine(), " ");
        addCnt = Integer.parseInt(st.nextToken());
        subCnt = Integer.parseInt(st.nextToken());
        mulCnt = Integer.parseInt(st.nextToken());
        divCnt = Integer.parseInt(st.nextToken());

        // 백트래킹(연산을 하거나 말거나, dfs 후 값 원복 필요)
        dfs(0,basedValue);

        System.out.println(maxValue);
        System.out.println(minValue);

        bw.flush();
        bw.close();
        br.close();


    }

    private static void dfs(int idx, int basedValue) {
        if (idx == N-1){
            maxValue = Math.max(maxValue, basedValue); // 백트래킹을 통해 여러번의 결과 중 제일 큰값이 저장될 것
            minValue = Math.min(minValue, basedValue);
        }
        else {
            if (addCnt > 0) {
                addCnt--;
                dfs(idx + 1, basedValue + nums[idx+1]); // + 연산자 줄어든채로 다음 dfs, 다음 요소를 연산해야 해서 idx+1
                addCnt++; // 위의 dfs를 끝내도 인자값 basedValue의 값은 변경안됨, 다음 연산자를 먼저 실행하기 위해 원복시킴
            }
            if (subCnt > 0){
                subCnt --;
                dfs(idx+1, basedValue - nums[idx+1]);
                subCnt ++;
            }
            if (mulCnt > 0){
                mulCnt --;
                dfs(idx+1, basedValue * nums[idx+1]);
                mulCnt ++;
            }
            if (divCnt > 0){
                divCnt --;
                dfs(idx+1, Math.round(basedValue / nums[idx+1]));
                divCnt ++;
            }

        }
    }
}


