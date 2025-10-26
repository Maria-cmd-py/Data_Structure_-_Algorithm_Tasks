package Lab_04_Stacks;
import java.util.*;
public class EvaluatePostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        Stack<Integer> st = new Stack<>();
        for (String t : tokens) {
            if (t.matches("-?\\d+")) st.push(Integer.parseInt(t));
            else if ("+-*/".contains(t)) {
                if (st.size() < 2) { System.out.println("Invalid"); 
                return; 
                }
                int b = st.pop(), a = st.pop(), res = 0;
                switch (t) {
                    case "+": res = a + b; break;
                    case "-": res = a - b; break;
                    case "*": res = a * b; break;
                    case "/": res = a / b; break;
                }
                st.push(res);
            } else { System.out.println("Invalid token: " + t); 
            return; 
            }
        }
        if (st.size() == 1) System.out.println("Value: " + st.pop());
        else System.out.println("Invalid expression");
    }
}
