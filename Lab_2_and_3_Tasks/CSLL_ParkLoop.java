package Lab_2_and_3_Tasks;
import java.util.Scanner;
public class CSLL_ParkLoop {
    static class CNode{ int data; CNode next; CNode(int d){data=d; next=this;} }
    static CNode makeNode(int x){ return new CNode(x); }
    static CNode tailOf(CNode head){
        if(head==null) return null;
        CNode t=head; while(t.next!=head) t=t.next; return t;
    }
    static void show(CNode head){
        if(head==null){ System.out.println("Circle: [ empty ]"); return; }
        System.out.print("Circle: [ ");
        CNode p=head; do{ System.out.print(p.data); p=p.next; if(p!=head) System.out.print(" -> "); }while(p!=head);
        System.out.println(" ]");
    }
    static CNode insertAtPos(CNode head,int pos,int x){
        if(pos<=0){ System.out.println("Invalid position."); return head; }
        if(head==null || pos==1){
            CNode n=makeNode(x);
            if(head==null){ head=n; System.out.println("Inserted as first post."); return head; }
            CNode tail=tailOf(head);
            n.next = head; tail.next = n; head = n; System.out.println("Inserted at position 1."); return head;
        }
        CNode p=head; int i=1;
        while(i<pos-1 && p.next!=head){ p=p.next; i++; }
        if(i<pos-1){ System.out.println("Position too big."); return head; }
        CNode n=makeNode(x); n.next = p.next; p.next = n; System.out.println("Inserted at position "+pos); return head;
    }
    static CNode deleteAtPos(CNode head,int pos){
        if(pos<=0){ System.out.println("Invalid position."); return head; }
        if(head==null){ System.out.println("Circle empty."); return head; }
        if(pos==1){
            if(head.next==head){ System.out.println("Deleted "+head.data+"; circle now empty."); return null; }
            CNode tail=tailOf(head); System.out.println("Deleted "+head.data+" from pos1."); head=head.next; tail.next=head; return head;
        }
        CNode p=head; int i=1;
        while(i<pos-1 && p.next!=head){ p=p.next; i++; }
        if(p.next==head){ System.out.println("Position too big."); return head; }
        System.out.println("Deleted "+p.next.data+" from position "+pos);
        p.next = p.next.next; return head;
    }
    static CNode insertEnd(CNode head,int x){
        if(head==null){ head=makeNode(x); System.out.println("Inserted as first post."); return head; }
        CNode tail=tailOf(head); CNode n=makeNode(x); n.next = head; tail.next = n; System.out.println("Inserted at end."); return head;
    }
    static CNode deleteLast(CNode head){
        if(head==null){ System.out.println("Circle empty."); return head; }
        if(head.next==head){ System.out.println("Deleted last "+head.data+"; circle empty."); return null; }
        CNode p=head;
        while(p.next.next!=head) p=p.next;
        System.out.println("Deleted last "+p.next.data);
        p.next = head;
        return head;
    }
    static void search(CNode head,int x){
        if(head==null){ System.out.println("Circle empty."); return; }
        CNode p=head; int pos=1;
        do{
            if(p.data==x){ System.out.println("Found at position "+pos); return; }
            p=p.next; pos++;
        } while(p!=head);
        System.out.println("Not found");
    }
    static int count(CNode head){
        if(head==null) return 0;
        int c=0; CNode p=head;
        do{ c++; p=p.next; }while(p!=head);
        return c;
    }
    static CNode updateAtPos(CNode head,int pos,int newX){
        if(head==null || pos<=0){ System.out.println("Invalid."); return head; }
        CNode p=head; int i=1;
        do{
            if(i==pos){ p.data=newX; System.out.println("Updated pos "+pos+" to "+newX); return head; }
            p=p.next; i++;
        }while(p!=head);
        System.out.println("Position too big.");
        return head;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        CNode head=null; int ch;
        do{
            System.out.println("\n[CSLL PARK] 1.Show 2.InsertPos 3.DeletePos 4.InsertEnd 5.DeleteLast 6.Search 7.Count 8.UpdatePos 9.Clear 0.Exit");
            System.out.print("Choose: "); ch=sc.nextInt();
            switch(ch){
                case 1 -> show(head);
                case 2 -> { System.out.print("Pos: "); int p=sc.nextInt(); System.out.print("Val: "); int x=sc.nextInt(); 
                head=insertAtPos(head,p,x); }
                case 3 -> { System.out.print("Pos: "); int p=sc.nextInt(); head=deleteAtPos(head,p); }
                case 4 -> { System.out.print("Val: "); int x=sc.nextInt(); head=insertEnd(head,x); }
                case 5 -> head = deleteLast(head);
                case 6 -> { System.out.print("Val: "); int x=sc.nextInt(); search(head,x); }
                case 7 -> System.out.println("Total posts = "+count(head));
                case 8 -> { System.out.print("Pos: "); int p=sc.nextInt(); System.out.print("New val: "); int nx=sc.nextInt(); 
                head=updateAtPos(head,p,nx); }
                case 9 -> { head=null; System.out.println("Cleared circle."); }
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid.");
            }
        } while(ch!=0);
        sc.close();
    }
}
