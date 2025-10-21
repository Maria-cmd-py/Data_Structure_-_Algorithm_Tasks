package Lab_2_and_3_Tasks;
import java.util.Scanner;
public class DLL_EasyMenu {
    // Node class for Doubly Linked List
    static class DNode {
        int data;
        DNode prev, next;
        DNode(int d) {
            data = d;
        }
    }
    // Create a new node
    static DNode makeNode(int x) {
        return new DNode(x);
    }
    // Show list forward
    static void showFwd(DNode head) {
        if (head == null) {
            System.out.println("Forward: [ empty ]");
            return;
        }
        System.out.print("Forward: [ ");
        for (DNode p = head; p != null; p = p.next) {
            System.out.print(p.data);
            if (p.next != null)
                System.out.print(" <-> ");
        }
        System.out.println(" ]");
    }
    // Find tail (last node)
    static DNode tailOf(DNode head) {
        if (head == null) return null;
        DNode p = head;
        while (p.next != null)
            p = p.next;
        return p;
    }
    // Show list backward
    static void showBwd(DNode tail) {
        if (tail == null) {
            System.out.println("Backward: [ empty ]");
            return;
        }
        System.out.print("Backward: [ ");
        for (DNode p = tail; p != null; p = p.prev) {
            System.out.print(p.data);
            if (p.prev != null)
                System.out.print(" <-> ");
        }
        System.out.println(" ]");
    }
    // Add at start
    static void addStart(DNode[] headRef, DNode[] tailRef, int x) {
        DNode n = makeNode(x);
        if (headRef[0] == null) {
            headRef[0] = tailRef[0] = n;
        } else {
            n.next = headRef[0];
            headRef[0].prev = n;
            headRef[0] = n;
        }
        System.out.println("Added " + x + " at START.");
    }
    // Add at end
    static void addEnd(DNode[] headRef, DNode[] tailRef, int x) {
        DNode n = makeNode(x);
        if (tailRef[0] == null) {
            headRef[0] = tailRef[0] = n;
        } else {
            tailRef[0].next = n;
            n.prev = tailRef[0];
            tailRef[0] = n;
        }
        System.out.println("Added " + x + " at END.");
    }
    // Insert at specific position
    static void insertPos(DNode[] headRef, DNode[] tailRef, int pos, int x) {
        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            addStart(headRef, tailRef, x);
            return;
        }
        DNode p = headRef[0];
        int i = 1;
        while (p != null && i < pos - 1) {
            p = p.next;
            ++i;
        }
        if (p == null) {
            System.out.println("Invalid position (too big).");
            return;
        }
        if (p.next == null) {
            addEnd(headRef, tailRef, x);
            return;
        }
        DNode n = makeNode(x);
        n.next = p.next;
        n.prev = p;
        p.next.prev = n;
        p.next = n;
        System.out.println("Inserted " + x + " at position " + pos + ".");
    }
    // Remove first node
    static void removeFirst(DNode[] headRef, DNode[] tailRef) {
        if (headRef[0] == null) {
            System.out.println("Playlist empty.");
            return;
        }
        DNode old = headRef[0];
        if (headRef[0] == tailRef[0]) {
            headRef[0] = tailRef[0] = null;
        } else {
            headRef[0] = headRef[0].next;
            headRef[0].prev = null;
        }
        System.out.println("Removed " + old.data + " from START.");
    }
    // Remove last node
    static void removeLast(DNode[] headRef, DNode[] tailRef) {
        if (tailRef[0] == null) {
            System.out.println("Playlist empty.");
            return;
        }
        DNode old = tailRef[0];
        if (headRef[0] == tailRef[0]) {
            headRef[0] = tailRef[0] = null;
        } else {
            tailRef[0] = tailRef[0].prev;
            tailRef[0].next = null;
        }
        System.out.println("Removed " + old.data + " from END.");
    }
    // Delete node at position
    static void deletePos(DNode[] headRef, DNode[] tailRef, int pos) {
        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (headRef[0] == null) {
            System.out.println("Playlist empty.");
            return;
        }
        if (pos == 1) {
            removeFirst(headRef, tailRef);
            return;
        }
        DNode p = headRef[0];
        int i = 1;
        while (p != null && i < pos) {
            p = p.next;
            ++i;
        }
        if (p == null) {
            System.out.println("Invalid position (too big).");
            return;
        }
        if (p == tailRef[0]) {
            removeLast(headRef, tailRef);
            return;
        }
        p.prev.next = p.next;
        p.next.prev = p.prev;
        System.out.println("Deleted " + p.data + " at position " + pos + ".");
    }
    // Clear entire list
    static void clearAll(DNode[] headRef, DNode[] tailRef) {
        while (headRef[0] != null)
            removeFirst(headRef, tailRef);
    }
    // Run the menu
    static int runDLL(Scanner sc) {
        DNode[] head = new DNode[]{null};
        DNode[] tail = new DNode[]{null};
        while (true) {
            System.out.println("\n[DLL MENU]");
            System.out.println("1. Show Forward");
            System.out.println("2. Show Backward");
            System.out.println("3. Add at Start");
            System.out.println("4. Add at End");
            System.out.println("5. Insert at Position");
            System.out.println("6. Remove First");
            System.out.println("7. Remove Last");
            System.out.println("8. Delete at Position");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            if (!sc.hasNextInt()) return 0;
            int ch = sc.nextInt();
            if (ch == 0) break;
            else if (ch == 1) showFwd(head[0]);
            else if (ch == 2) showBwd(tailOf(head[0]));
            else if (ch == 3) {
                System.out.print("Value: ");
                int x = sc.nextInt();
                addStart(head, tail, x);
                showFwd(head[0]);
            } else if (ch == 4) {
                System.out.print("Value: ");
                int x = sc.nextInt();
                addEnd(head, tail, x);
                showFwd(head[0]);
            } else if (ch == 5) {
                System.out.print("Position: ");
                int p = sc.nextInt();
                System.out.print("Value: ");
                int x = sc.nextInt();
                insertPos(head, tail, p, x);
                showFwd(head[0]);
            } else if (ch == 6) {
                removeFirst(head, tail);
                showFwd(head[0]);
            } else if (ch == 7) {
                removeLast(head, tail);
                showFwd(head[0]);
            } else if (ch == 8) {
                System.out.print("Position: ");
                int p = sc.nextInt();
                deletePos(head, tail, p);
                showFwd(head[0]);
            } else {System.out.println("Invalid choice.");}}
        clearAll(head, tail);
        System.out.println("Goodbye!");
        return 0;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            runDLL(sc);
        }
    }
}
