package beakjoon.day0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호 : 1991번
 * 문제 난이도 : 실버1
 * 문제 설명 : 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
 * 예를 들어 위와 같은 이진 트리가 입력되면,
 * 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
 * 중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
 * 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
 * 입력 : 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
 * 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현한다.
 * 출력 : 첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
 * 입력 예제
 * 7
 * A B C
 * B D .
 * C E F
 * E . .
 * F . G
 * D . .
 * G . .
 * 출력 예제
 * ABDCEFG
 * DBAECFG
 * DBEGFCA
 * 문제 Tip :
 * 작성일 : 2022-07-26
 **/

class Node1 {
    char alpha;
    Node1 left;
    Node1 right;

    public Node1(char alpha, Node1 left, Node1 right) {
        this.alpha = alpha;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree {
    Node1 head;

    Node1[] arr;

    public BinaryTree(int size) {
        arr = new Node1[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Node1((char) ('A' + i), null, null);
        }
    }

    public void add(char parent, char left, char right) {
        Node1 parentNode = findNode(parent);
        Node1 leftNode = findNode(left);
        Node1 rightNode = findNode(right);

        if (this.head == null) {
            this.head = parentNode;
        }
        if (parentNode != null) {
            parentNode.left = leftNode;
            parentNode.right = rightNode;
        }
    }

    public Node1 findNode(char data) {
        if (data == '.') {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            if (data == arr[i].alpha) {
                return arr[i];
            }
        }
        return null; //찾는 값이 없을경우
    }

    public void preOrder(Node1 node) {
        System.out.print(node.alpha);
        if (node.left != null) {
            this.preOrder(node.left);
        }
        if (node.right != null) {
            this.preOrder(node.right);
        }
    }

    public void inOrder(Node1 node) {
        if (node.left != null) {
            this.inOrder(node.left);
        }
        System.out.print(node.alpha);
        if (node.right != null) {
            this.inOrder(node.right);
        }
    }

    public void postOrder(Node1 node) {
        if (node.left != null) {
            this.postOrder(node.left);
        }
        if (node.right != null) {
            this.postOrder(node.right);
        }
        System.out.print(node.alpha);
    }
}
public class BeakJoon1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BinaryTree bt = new BinaryTree(n);
        StringTokenizer st;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            bt.add(parent, left, right);
        }

        bt.preOrder(bt.head);
        System.out.println();
        bt.inOrder(bt.head);
        System.out.println();
        bt.postOrder(bt.head);
        System.out.println();

    }
}
