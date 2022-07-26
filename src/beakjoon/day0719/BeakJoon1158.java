package beakjoon.day0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 백준 문제 번호 : 1158 (요세푸스 문제)
 * 백준 난이도 : 실버4
 * TIP : 큐를 이용하여 문제 접근
 * 작성자 : 박보경
 * 작성일 : 2022-07-19
**/
public class BeakJoon1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[n];

        IntStream.range(1, n + 1).forEach(queue::add); //반복문 대신

        int idx = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
//            System.out.println(queue.peek());
            result[idx] = queue.poll();
            idx++;
        }
//        System.out.println(Arrays.toString(result));

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                sb.append(String.valueOf(result[i]));
            } else if (i < result.length) {
                sb.append(", " + String.valueOf(result[i]));
            }

        }
        sb.append(">");
        System.out.println(sb.toString());

    }
}
