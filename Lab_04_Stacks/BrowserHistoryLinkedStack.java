package Lab_04_Stacks;
import java.util.Scanner;
public class BrowserHistoryLinkedStack {
    static class LinkedStack {
        private static class Node {
            String data; // page title
            Node next;   // pointer to next node
            Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }
        }
        private Node head; // top of stack (most recent page)
        public boolean isEmpty() {
            return head == null;
        }
        public void push(String pageTitle) {
            head = new Node(pageTitle, head);
            System.out.println("Visited: " + pageTitle);
        }
        public void pop() {
            if (isEmpty()) {
                System.out.println("No history (at Home)");
                return;
            }
            String lastPage = head.data;
            head = head.next;
            System.out.println("Back to " + lastPage + ". (Now use CURRENT to see where you are)");
        }
        public void peek() {
            if (isEmpty()) System.out.println("Current page: Home");
            else System.out.println("Current page: " + head.data);
        }
        public void show() {
            if (isEmpty()) {
                System.out.println("[empty]");
                return;
            }
            StringBuilder sb = new StringBuilder();
            Node cur = head;
            while (cur != null) {
                if (sb.length() > 0) sb.append(" ");
                sb.append(cur.data);
                cur = cur.next;
            }
            System.out.println("History (top->bottom): " + sb);
        }
    }
    private static void printMenu() {
        System.out.println("\n== Browser Back History (Linked List) ==");
        System.out.println("1) Visit page");
        System.out.println("2) Back");
        System.out.println("3) Current page");
        System.out.println("4) Show history");
        System.out.println("5) Help (show menu)");
        System.out.println("0) Exit");
        System.out.print("Choose: ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedStack history = new LinkedStack();
        System.out.println("Scenario: Unlimited page visits; use a linked-list stack for Back history.");
        printMenu();
        while (true) {
            String choice = sc.nextLine().trim();
            if (choice.isEmpty()) { System.out.print("Choose: "); continue; }
            char c = choice.charAt(0);
            if (c == '0') break;
            else if (c == '1') {
                System.out.print("Enter page title: ");
                String title = sc.nextLine().trim();
                if (title.isEmpty()) System.out.println("Please type a page title.");
                else history.push(title);
            } else if (c == '2') {
                history.pop();
            } else if (c == '3') {
                history.peek();
            } else if (c == '4') {
                history.show();
            } else if (c == '5') {
                printMenu();
            } else {
                System.out.println("Invalid choice. Press 5 for help.");
            }
            System.out.print("Choose: ");
        }
        System.out.println("Goodbye!");
        sc.close();
    }
}
