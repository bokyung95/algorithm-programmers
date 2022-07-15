package beakjoon.day0715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//실버5
public class BaekJoon2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 1;
        int count = 1;

        int startIdx = 1;
        int endIdx = 1;

        while (endIdx != n) {
            if (sum < n) {
                endIdx++;
                sum = sum + endIdx;
            } else if (sum == n) {
                endIdx++;
                sum = sum + endIdx;
                count++;
                System.out.println(startIdx + " " + endIdx);
            } else if (sum > n) {
                sum = sum - startIdx;
                startIdx++;
            }

        }

        System.out.println("count = " + count);

    }
}
