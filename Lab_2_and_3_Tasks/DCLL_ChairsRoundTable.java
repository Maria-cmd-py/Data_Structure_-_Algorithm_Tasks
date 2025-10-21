package Lab_2_and_3_Tasks;
import java.util.Scanner;
public class DCLL_ChairsRoundTable {
    static class Node { int data; Node next, prev; Node(int d){data=d;} }
    static Node makeNode(int x){ return new Node(x); }
    static Node addFront(Node head,int x){
        Node n = makeNode(x);
        if(head==null){ n.next=n.prev=n; head=n; System.out.println("Added "+x+" as only chair."); return head; }
        Node tail = head.prev;
        n.next = head; n.prev = tail; tail.next = n; head.prev = n; head = n;
        System.out.println("Added "+x+" at front."); return head;
    }
    static Node addEnd(Node head,int x){
        Node n = makeNode(x);
        if(head==null){ n.next=n.prev=n; head=n; System.out.println("Added "+x+" as only chair."); return head; }
        Node tail = head.prev;
        tail.next = n; n.prev = tail; n.next = head; head.prev = n;
        System.out.println("Added "+x+" at end."); return head;
    }
    static Node insertAtPos(Node head,int pos,int x){
        if(pos<=0){ System.out.println("Invalid."); return head; }
        if(pos==1 || head==null) return addFront(head,x);
        Node p=head; int i=1;
        while(i<pos-1 && p.next!=head){ p=p.next; i++; }
        if(i<pos-1){ System.out.println("Position too big."); return head; }
        Node n=makeNode(x);
        n.next = p.next; n.prev = p; p.next.prev = n; p.next = n;
        System.out.println("Inserted "+x+" at pos "+pos); return head;
    }
    static Node removeFirst(Node head){
        if(head==null){ System.out.println("Empty."); return null; }
        if(head.next==head){ System.out.println("Removed "+head.data+"; now empty."); return null; }
        Node tail=head.prev; System.out.println("Removed first "+head.data);
        head = head.next; tail.next = head; head.prev = tail; return head;
    }
    static Node removeLast(Node head){
        if(head==null){ System.out.println("Empty."); return null; }
        if(head.next==head){ System.out.println("Removed "+head.data+"; now empty."); return null; }
        Node tail=head.prev; System.out.println("Removed last "+tail.data);
        Node newTail = tail.prev; newTail.next = head; head.prev = newTail; return head;
    }
    static void printClockwise(Node head){
        if(head==null){ System.out.println("Clockwise: [ empty ]"); return; }
        System.out.print("Clockwise: [ ");
        Node p=head;
        do{ System.out.print(p.data); p=p.next; if(p!=head) System.out.print(" -> "); }while(p!=head);
        System.out.println(" ]");
    }
    static void printCounter(Node head){
        if(head==null){ System.out.println("Counter-clockwise: [ empty ]"); return; }
        System.out.print("Counter-clockwise: [ ");
        Node tail = head.prev; Node p=tail;
        do{ System.out.print(p.data); p=p.prev; if(p!=tail) System.out.print(" -> "); }while(p!=tail);
        System.out.println(" ]");
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); Node head=null; int ch;
        do{
            System.out.println("\n[DCLL TABLE] 1.AddFront 2.AddEnd 3.InsertPos 4.RemoveFirst 5.RemoveLast 6.PrintClock 7.PrintCounter 0.Exit");
            System.out.print("Choose: "); ch=sc.nextInt();
            switch(ch){
                case 1 -> { System.out.print("Val: "); int x=sc.nextInt(); head=addFront(head,x); }
                case 2 -> { System.out.print("Val: "); int x=sc.nextInt(); head=addEnd(head,x); }
                case 3 -> { System.out.print("Pos: "); int p=sc.nextInt(); System.out.print("Val: "); int x=sc.nextInt(); 
                head=insertAtPos(head,p,x); }
                case 4 -> head = removeFirst(head);
                case 5 -> head = removeLast(head);
                case 6 -> printClockwise(head);
                case 7 -> printCounter(head);
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid.");
            }
        } while(ch!=0);
        sc.close();
    }
}
