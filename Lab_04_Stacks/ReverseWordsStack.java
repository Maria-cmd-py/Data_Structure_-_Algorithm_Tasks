package Lab_04_Stacks;
import java.util.Scanner;
public class ReverseWordsStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        String[] stack = new String[words.length];
        int top = -1;
        for (String w : words) stack[++top] = w;
        while (top >= 0) {
            System.out.print(stack[top--]);
            if (top >= 0) System.out.print(" ");
        }
    }
}
