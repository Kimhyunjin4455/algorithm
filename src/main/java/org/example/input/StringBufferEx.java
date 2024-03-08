package org.example.input;

public class StringBufferEx {
    void stringBufferEx(){
        StringBuffer sb = new StringBuffer();
        sb.append("Kim");
        sb.append(" Hyun jin");
        String result = sb.toString();
        System.out.println("result = " + result);

        result += " ";
        result += "2";
        System.out.println("result = " + result);
    }

}
