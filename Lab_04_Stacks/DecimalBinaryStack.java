package Lab_04_Stacks;
import java.util.Scanner;
public class DecimalBinaryStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("Binary: 0");
            System.out.println("Reconstructed: 0");
            return;
        }
        int[] stack = new int[32];
        int top = -1, temp = n;
        while (temp > 0) { // Decimal → Binary
            if (top == 31) { System.out.println("Overflow"); return; }
            stack[++top] = temp % 2;
            temp /= 2;
        }
        System.out.print("Binary: ");
        for (int i = top; i >= 0; i--) System.out.print(stack[i]);
        System.out.println();
        int ans = 0; // Binary → Decimal
        for (int i = top; i >= 0; i--) ans = ans * 2 + stack[i];
        System.out.println("Reconstructed: " + ans);
    }
}