package beakjoon.day0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//22.07.12
public class BeakJoon11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String m = br.readLine();
        char[] chars = m.toCharArray();
        int sumResult = 0;

        for (int i = 0; i < n; i++) {
//            sum += chars[i] - '0';
            sumResult += Character.getNumericValue(chars[i]);
        }

        System.out.println(sumResult);
    }

}
