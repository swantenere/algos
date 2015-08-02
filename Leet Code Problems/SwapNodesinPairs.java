import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 02-08-2015.
 */
public class SwapNodesinPairs {

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

        ListNode head=swapPairs(list);
        System.out.print("after swapping");
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
    public static ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode n1=new ListNode(1);
        n1.next=head;
        ListNode new_head=head.next;
        while(true)
        {
            if(n1.next==null||n1.next.next==null)
                return new_head;

            ListNode node1=n1.next;
            ListNode node2=node1.next;
            n1.next=node2;
            node1.next=node2.next;
            node2.next=node1;
            n1=n1.next.next;
        }
    }
}