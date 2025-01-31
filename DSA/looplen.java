package DSA;
import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        next=null;
    }
}
public class looplen {
  //detect loop
    public static int countNodesinLoop(Node head) {
        Node slow=head;
        Node fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            
            if(fast==slow)
            {
              return lengthofloop(slow,fast);
            }
        }
        return 0;
    }
    // detect length
    
    static int lengthofloop(Node slow, Node fast)
    {
        int c=1;
        fast=fast.next;
        while(slow!=fast)
        {
            c++;
            fast=fast.next;
        }
        System.out.println(c);
        return c;
    }
     public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter number of nodes");
        int n=sc.nextInt();
        Node head=new Node(sc.nextInt());
        Node cur=head;
        for(int i=1;i<n;i++)
        {
            Node newn =new Node(sc.nextInt());
            cur.next=newn;
            cur=newn;
        }
        countNodesinLoop(head);
    }
}