package Lab_04_Stacks;
import java.util.Scanner;
public class BackspaceSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] stack = new char[s.length()];
        int top = -1;
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (top >= 0) top--; // backspace
            } else {
                stack[++top] = c;
            }
        }
        for (int i = 0; i <= top; i++)
            System.out.print(stack[i]);
    }
}
