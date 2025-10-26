package Lab_04_Stacks;
import java.util.Scanner;
public class RedundantParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        char[] stack = new char[100];
        int top = -1;
        for (char c : exp.toCharArray()) {
            if (c == ')') {
                boolean hasOp = false;
                while (top >= 0 && stack[top] != '(') {
                    char x = stack[top--];
                    if ("+-*/%^".indexOf(x) != -1) hasOp = true;
                }
                if (top < 0) { System.out.println("Invalid"); return; }
                top--; // pop '('
                if (!hasOp) { System.out.println("Redundant"); return; }
            } else {
                stack[++top] = c;
            }
        }
        System.out.println("OK");
    }
}
