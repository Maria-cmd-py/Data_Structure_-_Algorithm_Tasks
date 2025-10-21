package Lab_2_and_3_Tasks;
import java.util.Scanner;
public class CSLL_EasyMenu {
    static class CNode {
        int data;
        CNode next;
        CNode(int d) { data = d; next = this; }
    }
    static CNode makeNode(int x) { return new CNode(x); }
    static CNode tailOf(CNode head) {
        if (head == null) return null;
        CNode t = head;
        while (t.next != head) t = t.next;
        return t;
    }
    static void show(CNode head) {
        if (head == null) {
            System.out.println("Circle: [ empty ]");
            return;
        }
        System.out.print("Circle: [ ");
        CNode p = head;
        do {
            System.out.print(p.data);
            p = p.next;
            if (p != head) System.out.print(" -> ");
        } while (p != head);
        System.out.println(" -> back to " + head.data + " ]");
    }
    static void addFront(CNode[] headRef, int x) {
        CNode n = makeNode(x);
        if (headRef[0] == null) {
            headRef[0] = n;
            System.out.println("Added " + x + " (first kid).");
            return;
        }
        CNode tail = tailOf(headRef[0]);
        n.next = headRef[0];
        tail.next = n;
        headRef[0] = n;
        System.out.println("Added " + x + " at FRONT.");
    }
    static void insertPos(CNode[] headRef, int pos, int x) {
        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1 || headRef[0] == null) {
            addFront(headRef, x);
            return;
        }
        CNode p = headRef[0];
        int i = 1;
        while (i < pos - 1 && p.next != headRef[0]) {
            p = p.next;
            ++i;
        }
        if (i < pos - 1) {
            System.out.println("Invalid position (too big).");
            return;
        }
        CNode n = makeNode(x);
        n.next = p.next;
        p.next = n;
        System.out.println("Inserted " + x + " at position " + pos + ".");
    }
    static void addEnd(CNode[] headRef, int x) {
        if (headRef[0] == null) {
            headRef[0] = makeNode(x);
            System.out.println("Added " + x + " (first kid).");
            return;
        }
        CNode tail = tailOf(headRef[0]);
        CNode n = makeNode(x);
        n.next = headRef[0];
        tail.next = n;
        System.out.println("Added " + x + " at END.");
    }
    static void removeFirst(CNode[] headRef) {
        if (headRef[0] == null) {
            System.out.println("Circle empty.");
            return;
        }
        if (headRef[0].next == headRef[0]) {
            System.out.println("Removed " + headRef[0].data + ". Circle empty now.");
            headRef[0] = null;
            return;
        }
        CNode tail = tailOf(headRef[0]);
        CNode old = headRef[0];
        headRef[0] = headRef[0].next;
        tail.next = headRef[0];
        System.out.println("Removed first " + old.data + ". New first " + headRef[0].data + ".");
    }
    static void clearAll(CNode[] headRef) { headRef[0] = null; }
    static int runCSLL(Scanner sc) {
        CNode[] head = new CNode[]{null};
        while (true) {
            System.out.println("\n[CSLL] 1.Show 2.AddFront 3.InsertPos 4.AddEnd 5.RemoveFirst 0.Exit");
            System.out.print("Choose: ");
            if (!sc.hasNextInt()) return 0;
            int ch = sc.nextInt();
            if (ch == 0) break;
            if (ch == 1) show(head[0]);
            else if (ch == 2) {
                System.out.print("Value: ");
                int x = sc.nextInt();
                addFront(head, x);
                show(head[0]);
            } else if (ch == 3) {
                System.out.print("Pos: ");
                int p = sc.nextInt();
                System.out.print("Value: ");
                int x = sc.nextInt();
                insertPos(head, p, x);
                show(head[0]);
            } else if (ch == 4) {
                System.out.print("Value: ");
                int x = sc.nextInt();
                addEnd(head, x);
                show(head[0]);
            } else if (ch == 5) {
                removeFirst(head);
                show(head[0]);
            } else System.out.println("Invalid.");
        }
        clearAll(head);
        System.out.println("Goodbye!");
        return 0;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            runCSLL(sc);
        }
    }
}