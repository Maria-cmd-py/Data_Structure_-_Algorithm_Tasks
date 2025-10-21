package Lab_2_and_3_Tasks;
import java.util.Scanner;
public class SLL_LibraryQueue {
    static class Node { int data; Node next; Node(int d){data=d;} }
    static Node makeNode(int x){ return new Node(x); }
    static void show(Node head){
        if(head==null){ System.out.println("List: [ empty ]"); return; }
        System.out.print("List: [ ");
        Node p = head;
        while(p!=null){ System.out.print(p.data); if(p.next!=null) System.out.print(" | "); p=p.next; }
        System.out.println(" ]");
    }
    static Node insertAtPos(Node head,int pos,int x){
        if(pos<=0){ System.out.println("Invalid position."); return head; }
        Node n = makeNode(x);
        if(pos==1){ n.next=head; head=n; System.out.println("Inserted at position 1."); return head; }
        Node p=head; int i=1;
        while(p!=null && i<pos-1){ p=p.next; i++; }
        if(p==null){ System.out.println("Position too big."); return head; }
        n.next=p.next; p.next=n; System.out.println("Inserted at position "+pos+".");
        return head;
    }
    static Node deleteAtPos(Node head,int pos){
        if(pos<=0){ System.out.println("Invalid position."); return head; }
        if(head==null){ System.out.println("List empty."); return head; }
        if(pos==1){ System.out.println("Deleted "+head.data+" from position 1."); return head.next; }
        Node p=head; int i=1;
        while(p.next!=null && i<pos-1){ p=p.next; i++; }
        if(p.next==null){ System.out.println("Position too big."); return head; }
        System.out.println("Deleted "+p.next.data+" from position "+pos+".");
        p.next = p.next.next;
        return head;
    }
    static Node deleteByValue(Node head,int x){
        if(head==null){ System.out.println("List empty."); return head; }
        if(head.data==x){ System.out.println("Deleted value "+x+" from head."); return head.next; }
        Node p=head;
        while(p.next!=null && p.next.data!=x) p=p.next;
        if(p.next==null){ System.out.println("Value not found."); return head; }
        System.out.println("Deleted first occurrence of value "+x+".");
        p.next = p.next.next;
        return head;
    }
    static void search(Node head,int x){
        Node p=head; int pos=1;
        while(p!=null){
            if(p.data==x){ System.out.println("Found at position "+pos); return; }
            p=p.next; pos++;
        }
        System.out.println("Not found");
    }
    static int count(Node head){ int c=0; Node p=head; while(p!=null){ c++; p=p.next; } return c; }
    static Node reverseIterative(Node head){
        System.out.print("Before reverse: "); show(head);
        Node prev=null, cur=head;
        while(cur!=null){
            Node nxt=cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        System.out.println("After reverse:");
        show(prev);
        return prev;
    }
    static Node updateAtPos(Node head,int pos,int newX){
        if(pos<=0){ System.out.println("Invalid position."); return head; }
        Node p=head; int i=1;
        while(p!=null && i<pos){ p=p.next; i++; }
        if(p==null){ System.out.println("Position too big."); return head; }
        p.data = newX;
        System.out.println("Updated position "+pos+" to "+newX+".");
        return head;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int ch;
        do{
            System.out.println("\n[SLL LIBRARY] 1.Show 2.InsertPos 3.DeletePos 4.DeleteByValue 5.Search 6.Count 7.Reverse 8.UpdatePos 0.Exit");
            System.out.print("Choose: "); ch = sc.nextInt();
            switch(ch){
                case 1 -> show(head);
                case 2 -> { System.out.print("Pos: "); int p=sc.nextInt(); System.out.print("Ticket#: "); int x=sc.nextInt(); 
                head = insertAtPos(head,p,x); }
                case 3 -> { System.out.print("Pos: "); int p=sc.nextInt(); head = deleteAtPos(head,p); }
                case 4 -> { System.out.print("Value: "); int x=sc.nextInt(); head = deleteByValue(head,x); }
                case 5 -> { System.out.print("Value: "); int x=sc.nextInt(); search(head,x); }
                case 6 -> System.out.println("Total tickets = "+count(head));
                case 7 -> head = reverseIterative(head);
                case 8 -> { System.out.print("Pos: "); int p=sc.nextInt(); System.out.print("New value: "); int nx=sc.nextInt(); 
                head = updateAtPos(head,p,nx); }
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid.");
            }
        } while(ch!=0);
        sc.close();
    }
}
