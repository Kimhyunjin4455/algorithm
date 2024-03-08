package org.example.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInputEx {
    public void inputEx() throws IOException {
        InputStream in = System.in;

// InputStream: byte를 읽는다.
// ascii 값으로 변환
//        int a;

//        a = in.read();
//        System.out.println("a = " + a);

// ---------------------------------------------
//        byte[] a = new byte[3];
//        in.read(a);
//
//        System.out.println("a[0] = " + a[0]);
//        System.out.println("a[1] = " + a[1]);
//        System.out.println("a[2] = " + a[2]);
// ---------------------------------------------

// 입력한 값 그대로 출력 (길이 제한, 배열의 크기)
// InputStreamReader: character(문자)를 읽는다.
//        InputStreamReader inputStreamReader = new InputStreamReader(in);
//        char[] arrEx = new char[2];
//        inputStreamReader.read(arrEx);
//
//        System.out.println("arrEx = " + arrEx[0]);
// ---------------------------------------------

// 길이에 상관없이 사용자가 입력한 값을 모두 받아들임
// BufferedReader: String(문자열)을 읽는다.
//        InputStreamReader reader = new InputStreamReader(in);
//        BufferedReader br = new BufferedReader(reader);
//
//        String a = br.readLine();
//        System.out.println("a = " + a);
// ---------------------------------------------

// 콘솔 입력을 보다 쉽게 처리
        Scanner sc = new Scanner(in);
        System.out.println("sc = " + sc.nextInt());



    }
}
