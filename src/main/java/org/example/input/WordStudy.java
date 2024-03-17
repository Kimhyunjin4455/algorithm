package org.example.input;

import java.io.*;

public class WordStudy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toUpperCase();

        int[] count = new int[26];

        int maxValue = 0;       // 최댓값이 얼마인지
        int maxChar = '?';      // 최댓값의 알파벳이 뭔지

        for(int i=0; i<str.length(); i++){
            int idx = str.charAt(i) - 'A';// 그 알파벳의 인덱스를 찾기 위함
            //++count[idx];
            // 전위: 증가된 값이 연산결과, 전위: 증가하기 전 값이 연산결과

            if(maxValue < ++count[idx]){
                maxValue = count[idx];
                maxChar = str.charAt(i);
            } else if (maxValue == count[idx]) {
                maxChar = '?';
            }
        }

        bw.write(maxChar);

        bw.close();
        br.close();

    }
}
