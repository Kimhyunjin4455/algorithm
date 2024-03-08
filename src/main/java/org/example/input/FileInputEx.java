package org.example.input;

import java.io.*;

public class FileInputEx {
    public void outputEx() throws IOException {

//        //  OutputStream 역시 byte 단위로 데이터를 처리하는 클래스
//        // FileOutputStream은 OutputStream 클래스를 상속받아 만든 클래스이므로 역시 byte 단위로 데이터를 처리
//        FileOutputStream output = new FileOutputStream("/Users/kimhj/Desktop/study/out.txt");
//        for (int i =1; i<11; i++){
//            String data = i+"번째 테스트 입니다.    \r\n";
//            output.write(data.getBytes());  // String을 byte 배열로 바꾸어 주는 메서드
//        }
//        output.close(); // 사용한 파일 객체를 닫음, 사용했던 파일을 닫지 않고 다시 사용하면 오류 발생
// ------------------------------------------------

// 파일 쓰기 + 추가로 이어 쓰기
//        FileWriter fw = new FileWriter("/Users/kimhj/Desktop/study/out.txt");
//        for (int i = 1; i<11; i++){
//            String data = i+"번째 입력 테스트 입니다.\r\n";
//            fw.write(data);
//        }
//        fw.close();
//
//
//        FileWriter fw2 = new FileWriter("/Users/kimhj/Desktop/study/out.txt", true);
//        for (int i = 11; i<21; i++){
//            String data = i+"번째 입력 테스트 입니다.\r\n";
//            fw2.write(data);
//        }
//        fw2.close();


// ------------------------------------------------

// 파일 쓸때 줄바꿈 생략 가능
//        PrintWriter pw = new PrintWriter("/Users/kimhj/Desktop/study/out.txt");
//        for (int i = 1; i<11; i++){
//            String data = i+"번째 입력 테스트중 입니다.";
//            pw.println(data);
//        }
//        pw.close();
//
//        PrintWriter pw2 = new PrintWriter(new FileWriter("/Users/kimhj/Desktop/study/out.txt", true));
//        for (int i = 11; i<21; i++){
//            String data = i+"번째 입력 테스트 입니다.";
//            pw2.write(data);
//        }
//        pw2.close();

// ------------------------------------------------

// 파일 전체 읽기
//        byte[] b = new byte[1024];
//        FileInputStream input = new FileInputStream("/Users/kimhj/Desktop/study/out.txt");
//        input.read(b);  //  입력 스트림에서 데이터 바이트를 읽고, 데이터의 다음 바이트를 반환하거나 파일 끝에 도달하면 -1을 반환
//
//        System.out.println(new String(b)); // byte가 문자열로 변경됨
//        input.close();

// 파일을 줄 단위로 읽기
// readLine 메서드는 더 이상 읽을 라인이 없을 경우 null을 반환
        BufferedReader br = new BufferedReader(new FileReader("/Users/kimhj/Desktop/study/out.txt"));
        while (true){
            String line = br.readLine();
            if (line == null){
                break;
            }
            System.out.println(line);
        }
        br.close();


    }
}
