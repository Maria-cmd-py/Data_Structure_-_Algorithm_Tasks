package Lab_2_and_3_Tasks;
import java.util.Scanner;
public class DLL_TrainManager {
    static class DNode { int data; DNode prev, next; DNode(int d){data=d;} }
    static DNode makeNode(int x){ return new DNode(x); }
    static void showFwd(DNode head){
        if(head==null){ System.out.println("Forward: [ empty ]"); return; }
        System.out.print("Forward: [ ");
        DNode p=head; while(p!=null){ System.out.print(p.data); if(p.next!=null) System.out.print(" <-> "); p=p.next; }
        System.out.println(" ]");
    }
    static void showBwd(DNode head){
        DNode tail=head; if(tail==null){ System.out.println("Backward: [ empty ]"); return; }
        while(tail.next!=null) tail=tail.next;
        System.out.print("Backward: [ ");
        DNode p=tail; while(p!=null){ System.out.print(p.data); if(p.prev!=null) System.out.print(" <-> "); p=p.prev; }
        System.out.println(" ]");
    }
    static DNode insertAtPos(DNode head,int pos,int x){
        if(pos<=0){ System.out.println("Invalid position."); return head; }
        DNode n=makeNode(x);
        if(pos==1){
            if(head!=null){ n.next=head; head.prev=n; } head=n; System.out.println("Inserted at position 1."); return head;
        }
        DNode p=head; int i=1;
        while(p!=null && i<pos-1){ p=p.next; i++; }
        if(p==null){ System.out.println("Position too big."); return head; }
        n.next = p.next; n.prev = p; p.next = n;
        if(n.next!=null) n.next.prev = n;
        System.out.println("Inserted "+x+" at position "+pos); return head;
    }
    static DNode deleteAtPos(DNode head,int pos){
        if(pos<=0){ System.out.println("Invalid position."); return head; }
        if(head==null){ System.out.println("List empty."); return head; }
        if(pos==1){ System.out.println("Deleted "+head.data+" from position 1."); head = head.next; if(head!=null) head.prev=null; return head; }
        DNode p=head; int i=1;
        while(p!=null && i<pos){ p=p.next; i++; }
        if(p==null){ System.out.println("Position too big."); return head; }
        System.out.println("Deleted "+p.data+" from position "+pos);
        if(p.prev!=null) p.prev.next = p.next;
        if(p.next!=null) p.next.prev = p.prev;
        return head;
    }
    static DNode insertAfterValue(DNode head,int v,int x){
        DNode p=head;
        while(p!=null && p.data!=v) p=p.next;
        if(p==null){ System.out.println("Value "+v+" not found."); return head; }
        DNode n=makeNode(x);
        n.next = p.next; n.prev = p; p.next = n;
        if(n.next!=null) n.next.prev = n;
        System.out.println("Inserted "+x+" after "+v); return head;
    }
    static DNode deleteByValue(DNode head,int x){
        DNode p=head;
        while(p!=null && p.data!=x) p=p.next;
        if(p==null){ System.out.println("Value not found."); return head; }
        System.out.println("Deleted first occurrence of "+x);
        if(p.prev!=null) p.prev.next = p.next; else head = p.next;
        if(p.next!=null) p.next.prev = p.prev;
        return head;
    }
    static void search(DNode head,int x){
        DNode p=head; int pos=1;
        while(p!=null){
            if(p.data==x){ System.out.println("Found at position "+pos); return; }
            p=p.next; pos++;
        }
        System.out.println("Not found");
    }
    static DNode clearAll(DNode head){
        head=null; System.out.println("Cleared train. Now empty."); return null;
    }
    static DNode updateAtPos(DNode head,int pos,int newX){
        if(pos<=0){ System.out.println("Invalid position."); return head; }
        DNode p=head; int i=1;
        while(p!=null && i<pos){ p=p.next; i++; }
        if(p==null){ System.out.println("Position too big."); return head; }
        p.data=newX; System.out.println("Updated pos "+pos+" to "+newX); return head;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        DNode head=null;
        int ch;
        do{
            System.out.println("\n[DLL TRAIN] 1.Fwd 2.Bwd 3.InsertPos 4.DeletePos 5.InsertAfterVal 6.DeleteByVal 7.Search 8.Clear 9.UpdatePos 0.Exit");
            System.out.print("Choose: "); ch=sc.nextInt();
            switch(ch){
                case 1 -> showFwd(head);
                case 2 -> showBwd(head);
                case 3 -> { System.out.print("Pos: "); int p=sc.nextInt(); System.out.print("Val: "); int x=sc.nextInt(); head=insertAtPos(head,p,x); }
                case 4 -> { System.out.print("Pos: "); int p=sc.nextInt(); head=deleteAtPos(head,p); }
                case 5 -> { System.out.print("After value: "); int v=sc.nextInt(); System.out.print("Insert value: "); int x=sc.nextInt(); 
                head=insertAfterValue(head,v,x); }
                case 6 -> { System.out.print("Value: "); int x=sc.nextInt(); head=deleteByValue(head,x); }
                case 7 -> { System.out.print("Value: "); int x=sc.nextInt(); search(head,x); }
                case 8 -> head = clearAll(head);
                case 9 -> { System.out.print("Pos: "); int p=sc.nextInt(); System.out.print("New val: "); int nx=sc.nextInt(); head=updateAtPos(head,p,nx); }
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid.");
            }
        } while(ch!=0);
        sc.close();
    }
}
