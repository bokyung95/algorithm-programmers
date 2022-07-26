package beakjoon.day0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 1920
 * 문제 난이도 : 실버 4
 * 문제 설명 : N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
 *        다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -2의31승 보다 크거나 같고 2의31승보다 작다.
 * 출력 : M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 * 입력 예제
 * 5
 * 4 1 5 2 3
 * 5
 * 1 3 7 9 5
 * 출력 예제
 * 1
 * 1
 * 0
 * 0
 * 1
 * 문제 Tip : 이분탐색(Binary Search) 방식을 사용하여 문제 풀기
 * https://st-lab.tistory.com/261 사이트 참고
 * 작성일 : 2022-07-26
 **/
public class BeakJoon1920 {
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        // 배열은 반드시 정렬되어있어야한다.
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {

            // 찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력해야한다.
            if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append('\n');
            }
            else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static int binarySearch(int key) {

        int lo = 0;					// 탐색 범위의 왼쪽 끝 인덱스
        int hi = arr.length - 1;	// 탐색 범위의 오른쪽 끝 인덱스

        // lo가 hi보다 커지기 전까지 반복한다.
        while(lo <= hi) {

            int mid = (lo + hi) / 2;	// 중간위치를 구한다.

            // key값이 중간 위치의 값보다 작을 경우
            if(key < arr[mid]) {
                hi = mid - 1;
            }
            // key값이 중간 위치의 값보다 클 경우
            else if(key > arr[mid]) {
                lo = mid + 1;
            }
            // key값과 중간 위치의 값이 같을 경우
            else {
                return mid;
            }
        }

        // 찾고자 하는 값이 존재하지 않을 경우
        return -1;

    }

//        시간초과
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] arr = new int[n];
//        Deque deque = new LinkedList();
//        boolean isTrue = false;
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(arr);
//
//        int m = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < m; i++) {
//            deque.add(Integer.parseInt(st.nextToken()));
//        }
//
//        int size = deque.size();
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                if ((int)deque.peek() == arr[j]) {
//
//                    isTrue = true;
//                    break;
//                } else {
//                    isTrue = false;
//                }
//            }
//            deque.removeFirst();
//            if (isTrue) {
//                System.out.println("1");
//            } else {
//                System.out.println("0");
//            }
//        }
//    }

}
