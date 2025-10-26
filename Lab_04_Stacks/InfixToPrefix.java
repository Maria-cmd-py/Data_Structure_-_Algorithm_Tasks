package Lab_04_Stacks;
import java.util.*;
public class InfixToPrefix {
    static int prec(String op) {
        if (op.equals("*") || op.equals("/")) return 2;
        if (op.equals("+") || op.equals("-")) return 1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        Collections.reverse(Arrays.asList(tokens));
        Stack<String> ops = new Stack<>();
        ArrayList<String> out = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (t.equals("(")) t = ")";
            else if (t.equals(")")) t = "(";
            if (t.matches("[A-Za-z0-9]+")) out.add(t);
            else if (t.equals("(")) ops.push(t);
            else if (t.equals(")")) {
                while (!ops.isEmpty() && !ops.peek().equals("("))
                    out.add(ops.pop());
                if (!ops.isEmpty()) ops.pop();
            } else { // operator
                while (!ops.isEmpty() && prec(ops.peek()) >= prec(t))
                    out.add(ops.pop());
                ops.push(t);
            }
        }
        while (!ops.isEmpty()) out.add(ops.pop());
        Collections.reverse(out);
        System.out.println(String.join(" ", out));
    }
}
