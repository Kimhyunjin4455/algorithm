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

/**
    길이에 상관없이 사용자가 입력한 값을 모두 받아들임
    BufferedReader: String(문자열)을 읽는다.
    데이터를 한번에 읽어와 버퍼에 보관한 후 버퍼에서 데이터를 읽어오는 방식으로 동작 ( 사용자가 입력한 문자 스트림을 읽는 것 )
    데이터를 파싱하지 않고 String으로만 읽고 가져옴
    버퍼가 가득차거나 개행문자가 나타나면 버퍼의 내용을 한번에 프로그램으로 전달하기에 Scanner보다 소요되는 시간을 절약
    Checked Exception (예외 처리 필요)

    ** 멀티스레드 환경에서도 안전
 */
//        InputStreamReader reader = new InputStreamReader(in);
//        BufferedReader br = new BufferedReader(reader);
//
//        String a = br.readLine();
//        System.out.println("a = " + a);
// ---------------------------------------------

/**
    콘솔 입력을 보다 쉽게 처리
    공백(띄어쓰기) 및 개행(줄 바꿈)을 기준으로 읽음( ' ', '\t', '\r', '\n' )
    원하는 타입으로 읽을 수 있음
    UnChecked(Runtime) Exception ( 예외 처리 명시 필요 x )
    데이터를 입력받을 경우 즉시 사용자에게 전송, 입력받을 때마다 전송 -> 많은 시간 소요

    **멀티스레드 환경에서 문제가 발생할 수 있다.
 */
//        Scanner sc = new Scanner(in);
//        System.out.println("sc = " + sc.nextInt());


/**
    BufferedWriter
    많은 양의 출력을 할 때는, 입력과 동일하게 버퍼를 사용하는 것이 좋음
    출력과 개행을 동시해 해주지 않기 때문에, 개행을 위해선 따로 newLine(); 혹은 bw.write("\n");을 사용해야 함
    BufferedWriter의 경우 버퍼를 잡아 놓았기 때문에 반드시 사용한 후에, flush()/ close()를 해주어야 함
    close()를 하게되면, 출력 스트림을 아예 닫아버리기 때문에 한번 출력후, 다른 것도 출력하고자 한다면 flush()를 사용
 */


    }
}
