package beakjoon.day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 백준 문제 번호 : 10828
 * 백준 난이도 : 실버4
 * TIP : 스택이용하여 문제 풀기. StringTokenizer 미리 변수에 선언해서 비교하기.
 * 작성자 :
 * 작성일 : 2022-07-20
**/

public class BeakJoon10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack stack = new Stack();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();

            if ("push".equals(temp)) {
//                System.out.println(st.nextToken());
                stack.push(Integer.parseInt(st.nextToken()));
            } else if ("pop".equals(temp)) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.pop());
                }
            } else if ("size".equals(temp)) {
                System.out.println(stack.size());
            } else if ("empty".equals(temp)) {
                if (stack.isEmpty()) {
                    System.out.println("1");
                }else {
                    System.out.println("0");
                }
            } else {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.peek());
                }
            }
        }

    }
}
