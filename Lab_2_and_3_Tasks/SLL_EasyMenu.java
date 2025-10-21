package Lab_2_and_3_Tasks;
import java.util.Scanner;
public class SLL_EasyMenu {
    // Node class for Singly Linked List
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }
    // Function to create a new node
    static Node makeNode(int x) {
        return new Node(x);
    }
    // Function to display the linked list
    static void show(Node head) {
        if (head == null) {
            System.out.println("Line: [ empty ]");
            return;
        }
        System.out.print("Line: [ ");
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.data);
            if (p.next != null)
                System.out.print(" | ");
        }
        System.out.println(" ]");
    }
    // Add element at front
    static void addFront(Node[] headRef, int x) {
        Node n = makeNode(x);
        n.next = headRef[0];
        headRef[0] = n;
        System.out.println("Added " + x + " at FRONT.");
    }
    // Add element at end
    static void addEnd(Node[] headRef, int x) {
        Node n = makeNode(x);
        if (headRef[0] == null) {
            headRef[0] = n;
            System.out.println("Added " + x + " (first).");
            return;
        }
        Node p = headRef[0];
        while (p.next != null)
            p = p.next;
        p.next = n;
        System.out.println("Added " + x + " at END.");
    }
    // Insert element at a specific position
    static void insertPos(Node[] headRef, int pos, int x) {
        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            addFront(headRef, x);
            return;
        }
        Node p = headRef[0];
        int i = 1;
        while (p != null && i < pos - 1) {
            p = p.next;
            ++i;
        }
        if (p == null) {
            System.out.println("Invalid position (too big).");
            return;
        }
        Node n = makeNode(x);
        n.next = p.next;
        p.next = n;
        System.out.println("Inserted " + x + " at position " + pos + ".");
    }
    // Remove the first node
    static void removeFirst(Node[] headRef) {
        if (headRef[0] == null) {
            System.out.println("Line already empty.");
            return;
        }
        Node old = headRef[0];
        headRef[0] = headRef[0].next;
        System.out.println("Removed " + old.data + " from FRONT.");
    }
    // Clear the entire list
    static void clearAll(Node[] headRef) {
        while (headRef[0] != null)
            removeFirst(headRef);
    }
    // Run the menu
    static int runSLL(Scanner sc) {
        Node[] head = new Node[]{null};
        while (true) {
            System.out.println("\n[SLL MENU]");
            System.out.println("1. Show");
            System.out.println("2. Add Front");
            System.out.println("3. Add End");
            System.out.println("4. Insert at Position");
            System.out.println("5. Remove First");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            if (!sc.hasNextInt()) return 0;
            int ch = sc.nextInt();
            if (ch == 0) break;
            else if (ch == 1) show(head[0]);
            else if (ch == 2) {
                System.out.print("ID: ");
                int x = sc.nextInt();
                addFront(head, x);
                show(head[0]);
            } else if (ch == 3) {
                System.out.print("ID: ");
                int x = sc.nextInt();
                addEnd(head, x);
                show(head[0]);
            } else if (ch == 4) {
                System.out.print("Position: ");
                int p = sc.nextInt();
                System.out.print("ID: ");
                int x = sc.nextInt();
                insertPos(head, p, x);
                show(head[0]);
            } else if (ch == 5) {
                removeFirst(head);
                show(head[0]);
            } else {
                System.out.println("Invalid choice.");
            }
        }
        clearAll(head);
        System.out.println("Goodbye!");
        return 0;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            runSLL(sc);
        }
    }
}
