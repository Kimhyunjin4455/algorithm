package org.example.algorithmSolution.problem;

import java.io.IOException;
import java.util.Scanner;


public class ChickenCoupon {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int temp = n;
            int bonusCoupon = 0;

            while (temp >= k){
                bonusCoupon += (temp / k);
                temp = (temp/k) + temp%k;
            }

            int result = n + bonusCoupon;
            System.out.println(result);
        }



    }
}
