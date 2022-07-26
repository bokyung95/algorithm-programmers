package beakjoon.day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 문제 번호 : 10845
 * 백준 난이도 : 실버4
 * TIP : 큐 방식. ArrayList 이용하여 문제 풀기.
 * 작성자 :
 * 작성일 : 2022-07-20
**/

public class BeakJoon10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            if ("push".equals(temp)) {
                list.add(Integer.parseInt(st.nextToken()));
            } else if ("pop".equals(temp)) {
                if (list.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(list.get(0));
                    list.remove(0);
                }
            } else if ("size".equals(temp)) {
                System.out.println(list.size());
            } else if ("empty".equals(temp)) {
                if (list.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if ("front".equals(temp)) {
                if (list.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(list.get(0));
                }
            } else {
                if (list.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(list.get(list.size() - 1));
                }
            }
        }
    }
}
