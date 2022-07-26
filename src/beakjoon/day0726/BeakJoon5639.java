package beakjoon.day0726;

import java.util.Scanner;

/**
 * 문제 번호 : 5639
 * 문제 난이도 : 골드5
 * 문제 설명 : 이진 검색 트리는 다음과 같은 세 가지 조건을 만족하는 이진 트리이다.
 * 노드의 왼쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 작다.
 * 노드의 오른쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 크다.
 * 왼쪽, 오른쪽 서브트리도 이진 검색 트리이다.
 * 전위 순회 (루트-왼쪽-오른쪽)은 루트를 방문하고, 왼쪽 서브트리, 오른쪽 서브 트리를 순서대로 방문하면서 노드의 키를 출력한다.
 * 후위 순회 (왼쪽-오른쪽-루트)는 왼쪽 서브트리, 오른쪽 서브트리, 루트 노드 순서대로 키를 출력한다.
 * 예를 들어, 위의 이진 검색 트리의 전위 순회 결과는 50 30 24 5 28 45 98 52 60 이고, 후위 순회 결과는 5 28 24 45 30 60 52 98 50 이다.
 * 이진 검색 트리를 전위 순회한 결과가 주어졌을 때, 이 트리를 후위 순회한 결과를 구하는 프로그램을 작성하시오.
 *
 * 입력 : 트리를 전위 순회한 결과가 주어진다. 노드에 들어있는 키의 값은 106보다 작은 양의 정수이다. 모든 값은 한 줄에 하나씩 주어지며, 노드의 수는 10,000개 이하이다. 같은 키를 가지는 노드는 없다.
 * 출력 : 입력으로 주어진 이진 검색 트리를 후위 순회한 결과를 한 줄에 하나씩 출력한다.
 * 입력 예제
 * 50
 * 30
 * 24
 * 5
 * 28
 * 45
 * 98
 * 52
 * 60
 * 출력 예제
 * 5
 * 28
 * 24
 * 45
 * 30
 * 60
 * 52
 * 98
 * 50
 * 문제 Tip : 이진탐색트리(후위순회)
 * 작성일 : 2022-07-26
 **/
class Node {
    int key;
    Node left;
    Node right;

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    public Node head;

    public void add(int key) {
        Node newNode = new Node(key, null, null);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node cur = this.head;
            while (cur != null) {
                if (key < cur.key) {
                    if (cur.left == null) {
                        cur.left = newNode;
                        break;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if (cur.right == null) {
                        cur.right = newNode;
                        break;
                    } else {
                        cur = cur.right;
                    }
                }
            }
        }
    }
    
    public void postOrder(Node node) {
//        System.out.println(node.key); // 전위순회 (현왼오)
        if (node.left != null) {
            postOrder(node.left);
        }
        
//        System.out.println(node.key); //중위순회 (왼현오)
        
        if (node.right != null) {
            postOrder(node.right);
        }

        System.out.println(node.key); //후위순회 (왼오현)
    }

}

public class BeakJoon5639 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String input = sc.nextLine();
            int val = Integer.parseInt(input);
            bst.add(val);
        }

        bst.postOrder(bst.head);

//        bst.add(50);
//        bst.add(30);
//        bst.add(24);
//        bst.add(5);
//        bst.add(28);
//        bst.add(45);
//        bst.add(98);
//        bst.add(52);
//        bst.add(60);
//
//        bst.postOrder(bst.head);


    }
}
