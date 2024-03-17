package org.example.structureEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class ListEx {
    public void listEx(){
        ArrayList<String> myArrList = new ArrayList<>();
        ArrayList<Integer> numArrList = new ArrayList<>(10);// 초기 사이즈 지정


        // ArrayList와 유사하지만 동기화되어 스레드로부터 안전
        // 추가된 동기화 오버헤드로 인해 성능이 느려짐
        // 다중 스레드 환경에 적합
        // 동기화가 필요하지 않은 경우 일반적으로 ArrayList가 선호
        Vector<String> myVector = new Vector<>();   //  빈 벡터 생성
        myVector.add("kim0");
        myVector.add("kim1");
        myVector.add("kim2");

        myVector.remove("kim0");
        myVector.remove(1);

        System.out.println(myVector.get(0));

        int lastIndex = myVector.size() - 1;
        System.out.println(myVector.get(lastIndex));

        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person("kim", 20,175));
        personArrayList.add(new Person("hyun", 15, 180));
        personArrayList.add(new Person("jin", 27, 178));


        Collections.sort(personArrayList);
        for (Person p: personArrayList) {
            System.out.println(p);
        }


    }
}

class Person implements Comparable<Person>{
    private String name;
    private int age;
    private int height;

    public Person(String name, int age, int height){
        this.name=name;
        this.age=age;
        this.height=height;

    }

    @Override
    public int compareTo(Person newP) {

        //return Integer.compare(this.age, newP.age);
        //return Integer.compare(this.height, newP.height);
        return this.name.compareTo(newP.name);


    }

    @Override
    public String toString(){
        return name + " (Age: "+age+")" +" (height: "+height+")";
    }
}
