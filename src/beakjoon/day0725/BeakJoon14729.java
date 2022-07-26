package beakjoon.day0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 백준 문제 번호 : 14729
 * 백준 난이도 : 실버 5
 * TIP :
 * 작성자 :
 * 작성일 : 2022-07-25
**/

public class BeakJoon14729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Double> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            double data = Double.parseDouble(br.readLine());
            if (list.size() == 7) {
                //list 사이즈가 7보다 클 경우 들어오는 값과 리스트의 값들을 비교하여 작을 경우에 교환
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) >= data) {
                        list.remove(list.size() - 1);
                        list.add(data);
                        break;
                    }
                }
            } else {
                list.add(data);
            }
            Collections.sort(list); //리스트 정렬
//        list = list.stream().sorted().collect(Collectors.toList()); //리스트 정렬한것
        }
        for (double item : list) {
            System.out.printf("%.3f\n", item);
        }

    }
}
