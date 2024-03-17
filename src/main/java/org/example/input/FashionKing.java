package org.example.input;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FashionKing {
    // ex: 두 종류의 아우터와, 한 종류의 바지
    // 아무것도 안 입을 수는 없음(한가지는 무조건 착용)
    // (종류+1)*(종류+1)*... -1(아무것도 안입은 경우), +1은 선택을 하지 않을수도 있기에 1을 더한 것
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            HashMap<String, Integer> clothesMap = new HashMap<>();
            int result = 1; // 더하는게 아니라 곱하기에 1로 설정
            int clothes = Integer.parseInt(br.readLine());
            for (int j=0; j<clothes; j++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String type = st.nextToken();
                clothesMap.put(type, clothesMap.getOrDefault(type,0)+1);
                // 해쉬맵에 값이 있으면 그 값에+1, 없으면 디폴트 설정값(0)에 +1
            }
            for (int val:clothesMap.values()) {
                result *= (val+1);
            }

            bw.write(String.valueOf(result-1));   // 나체의 경우 -1
            bw.newLine();                           // 출력과 개행을 동시해 해주지 않기 때문에, 개행을 위해선 따로 newLine(); 혹은 bw.write("\n");을 사용해야 함

        }
        bw.flush();                                 // 버퍼를 잡아 놓았기 때문에 반드시 사용한 후에, flush()/ close()를 해주어야 함
        bw.close();
        br.close();

    }
}
