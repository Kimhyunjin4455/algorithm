package org.example.structureEx;

class Parent{
    String name = "Parent";
    public Parent(){
        System.out.print(this.name);
    }
}

class Child extends Parent{
    public Child(String name){
        System.out.print(this.name);
    }
}
public class Test000ex {
    public static void main(String[] args) {
        Child hj = new Child("Hj");
        System.out.println();
        for (int i=0; i<2; i++){
            System.out.println((int)(Math.random()*35)+1);
        }

    }
}
