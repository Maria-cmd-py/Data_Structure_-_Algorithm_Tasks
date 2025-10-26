package Lab_04_Stacks;
import java.util.*;
public class PostfixToInfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        Stack<String> st = new Stack<>();
        for (String t : tokens) {
            if ("+-*/%^".contains(t)) {
                if (st.size() < 2) { System.out.println("Invalid"); 
                return; 
                }
                String b = st.pop(), a = st.pop();
                st.push("(" + a + " " + t + " " + b + ")");
            } else st.push(t);
        }
        if (st.size() != 1) System.out.println("Invalid");
        else System.out.println(st.pop());
    }
}
