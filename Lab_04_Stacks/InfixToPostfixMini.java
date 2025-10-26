package Lab_04_Stacks;
import java.util.*;
public class InfixToPostfixMini {
    static int prec(String op) {
        switch (op) {
            case "^": return 3;
            case "*": case "/": case "%": return 2;
            case "+": case "-": return 1;
            default: return -1;
        }
    }
    static boolean isOp(String t) { // Check if token is operator
        return "+-*/%^".contains(t);
    }
    static boolean leftAssoc(String t) { // ^ is right associative; others are left
        return !t.equals("^");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter infix (space-separated):");
        String[] tok = sc.nextLine().trim().split("\\s+");
        Stack<String> ops = new Stack<>();
        List<String> out = new ArrayList<>();
        try {
            for (String t : tok) {
                if (t.equals("(")) {
                    ops.push(t);
                } else if (t.equals(")")) {
                    while (!ops.isEmpty() && !ops.peek().equals("("))
                        out.add(ops.pop());
                    if (ops.isEmpty()) throw new RuntimeException("Mismatched ( )");
                    ops.pop(); // remove '('
                } else if (isOp(t)) {
                    while (!ops.isEmpty() && isOp(ops.peek())) {
                        String top = ops.peek();
                        int pt = prec(top), pc = prec(t);
                        if (pt > pc || (pt == pc && leftAssoc(t)))
                            out.add(ops.pop());
                        else break;
                    }
                    ops.push(t);
                } else {
                    out.add(t);
                }
            }
            while (!ops.isEmpty()) {
                String op = ops.pop();
                if (op.equals("(")) throw new RuntimeException("Mismatched ( )");
                out.add(op);
            }
            System.out.println("Postfix: " + String.join(" ", out));

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
