package Lab_04_Stacks;
import java.util.*;
public class NextGreaterElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[i] > arr[s.peek()])
                ans[s.pop()] = arr[i];
            s.push(i);
        }
        while (!s.isEmpty()) ans[s.pop()] = -1;
        for (int i = 0; i < n; i++)
            System.out.println(arr[i] + " -> " + ans[i]);
    }
}
