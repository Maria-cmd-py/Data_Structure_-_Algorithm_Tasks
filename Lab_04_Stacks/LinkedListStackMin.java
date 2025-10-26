package Lab_04_Stacks;
import java.util.Scanner;
class Node {
    int value, minSoFar;
    Node next;
    Node(int v, int m, Node n) { value = v; minSoFar = m; next = n; }
}
public class LinkedListStackMin {
    static Node top = null;
    public static void push(int x) {
        int min = (top == null) ? x : Math.min(x, top.minSoFar);
        top = new Node(x, min, top);
    }
    public static void pop() {
        if (top == null) System.out.println("Underflow");
        else {
            System.out.println("POP -> " + top.value);
            top = top.next;
        }
    }
    public static void top() {
        if (top == null) System.out.println("Underflow");
        else System.out.println("TOP -> " + top.value);
    }
    public static void min() {
        if (top == null) System.out.println("Underflow");
        else System.out.println("MIN -> " + top.minSoFar);
    }
    public static void show() {
        Node temp = top;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String cmd = sc.next();
            if (cmd.equalsIgnoreCase("PUSH")) push(sc.nextInt());
            else if (cmd.equalsIgnoreCase("POP")) pop();
            else if (cmd.equalsIgnoreCase("TOP")) top();
            else if (cmd.equalsIgnoreCase("MIN")) min();
            else if (cmd.equalsIgnoreCase("SHOW")) show();
            else break;
        }
    }
}
