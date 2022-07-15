package beakjoon.day0712;

import java.util.Scanner;

//22.07.12
public class BeakJoon1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] score = new int[cnt];
        double max = 0;
        double avg = 0;
        double sum = 0;

        for (int i = 0; i < cnt; i++) {
            score[i] = sc.nextInt();
        }

        for (int i = 0; i < score.length; i++) {
            if (score[i] > max) {
                max = score[i];
            }
        }

        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }
//        System.out.println("sum = " + sum);
//        System.out.println("max = " + max);

        avg = sum * 100 / max / cnt;
        System.out.println(avg);

    }
}
