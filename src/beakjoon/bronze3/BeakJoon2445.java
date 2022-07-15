package beakjoon.bronze3;
//첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
//첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.

public class BeakJoon2445 {
    public static void main(String[] args) {
        int number = 5;//(int)(Math.random() * 100) + 1;
//        System.out.println(number);

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < number / 2 ; j++) {

            }

        }
    }
}
