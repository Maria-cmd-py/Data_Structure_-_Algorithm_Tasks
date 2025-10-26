package Lab_04_Stacks;
import java.util.Scanner;
public class TrayStackArray {
    // Inner class to represent the Stack
    static class TrayStack {
        private final String[] data;  // array to store tray IDs
        private int top;              // index of top tray
        public TrayStack(int capacity) {
            data = new String[capacity];
            top = -1;
        }
        // Check if stack is empty
        public boolean isEmpty() {
            return top == -1;
        }
        // Check if stack is full
        public boolean isFull() {
            return top == data.length - 1;
        }
        // Push (Add tray)
        public void push(String value) {
            if (isFull()) {
                System.out.println("Overflow (stack full)");
                return;
            }
            data[++top] = value; // move top up and insert value
            System.out.println("Added tray " + value);
        }
        // Pop (Take tray)
        public void pop() {
            if (isEmpty()) {
                System.out.println("Underflow (no trays)");
                return;
            }
            System.out.println("Gave tray " + data[top--]);
        }
        // Peek (Show top tray without removing)
        public void peek() {
            if (isEmpty()) System.out.println("Stack empty");
            else System.out.println("Top tray: " + data[top]);
        }
        // Show all trays from top → bottom
        public void show() {
            if (isEmpty()) {
                System.out.println("[empty]");
                return;
            }
            System.out.print("Stack (top->bottom): ");
            for (int i = top; i >= 0; i--)
                System.out.print(data[i] + (i == 0 ? "" : " "));
            System.out.println();
        }
    }
    // Menu printer
    private static void printMenu() {
        System.out.println("\n== Cafeteria Tray Stack (Array) ==");
        System.out.println("1) Add tray");
        System.out.println("2) Take tray");
        System.out.println("3) Show top");
        System.out.println("4) Show all");
        System.out.println("0) Exit");
        System.out.print("Choose: ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter capacity K: ");
        int k = sc.nextInt();
        sc.nextLine(); // consume newline
        TrayStack stack = new TrayStack(k);
        printMenu();
        while (true) {
            String choice = sc.nextLine().trim();
            if (choice.isEmpty()) {
                System.out.print("Choose: ");
                continue;
            }
            char c = choice.charAt(0);
            if (c == '0') break;
            else if (c == '1') {
                System.out.print("Enter tray id (e.g., T1): ");
                String id = sc.next();
                sc.nextLine();
                stack.push(id);
            } else if (c == '2') {
                stack.pop();
            } else if (c == '3') {
                stack.peek();
            } else if (c == '4') {
                stack.show();
            } else {
                System.out.println("Invalid choice. Press 5 for help.");
            }
            System.out.print("Choose: ");
        }

        System.out.println("Goodbye!");
        sc.close();
    }
}
