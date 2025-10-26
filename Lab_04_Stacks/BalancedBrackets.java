package Lab_04_Stacks;
import java.util.Scanner;
public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] stack = new char[s.length()];
        int top = -1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack[++top] = c;
            else if (c == ')' || c == ']' || c == '}') {
                if (top < 0) { System.out.println("Not balanced"); 
                return; 
                }
                char open = stack[top--];
                if ((c == ')' && open != '(') ||
                    (c == ']' && open != '[') ||
                    (c == '}' && open != '{')) {
                    System.out.println("Not balanced"); return;
                }
            }
        }
        System.out.println(top == -1 ? "Balanced" : "Not balanced");
    }
}
