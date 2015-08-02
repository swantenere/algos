import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 02-08-2015.
 */

class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
public class RemoveNthNodeFromEnd {

    public static void main(String args[])throws Exception
    {
        System.out.println("Enter the number of elements in the list ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements in the list");
        int value=Integer.parseInt(br.readLine());
        ListNode list =new ListNode(value) ;
        list.next=null;
        for(int i=1;i<num;i++) {
            System.out.println("Enter value");
            value=Integer.parseInt(br.readLine());
            insertIntoList(list,value);
        }
        System.out.println("Enter the element position to be deleted");
        int position=Integer.parseInt(br.readLine());
        ListNode head=removeNthFromEnd(list,position);
        printList(head);
    }
    public static void insertIntoList(ListNode start, int value) {
        ListNode n1 = start;
        while (n1.next != null) {
            n1 = n1.next;
        }
        ListNode n2 = new ListNode(value);
        n2.next = null;
        n1.next = n2;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return head;
        ListNode fast=head,slow=head;
        for(int i=0;i<n;i++)
        {
            fast=fast.next;
        }
        if(fast==null)//means remove the first node which is nth from end
        {
            head=head.next;
            return head;
        }
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }
    public static void printList(ListNode start) {
        ListNode n1 = start;
        if(n1==start)
            System.out.println();
        while (n1 != null) {
            System.out.print(n1.val);
            if(n1.next!=null)
                System.out.print("-> ");
            n1 = n1.next;
        }
        System.out.println();
    }
}
