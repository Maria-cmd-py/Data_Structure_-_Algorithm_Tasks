package Lab_04_Stacks;
import java.util.*;
public class PathSimplifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        String[] parts = path.split("/");
        Stack<String> st = new Stack<>();
        for (String p : parts) {
            if (p.equals("") || p.equals(".")) continue;
            else if (p.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else st.push(p);
        }
        if (st.isEmpty()) System.out.println("/");
        else {
            StringBuilder sb = new StringBuilder();
            for (String dir : st) sb.append("/").append(dir);
            System.out.println(sb);
        }
    }
}
