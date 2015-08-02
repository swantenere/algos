import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Annam on 02-08-2015.
 */
public class MergeSortedLists {
    public static void main(String args[]) throws Exception {

        System.out.println("Enter the number of elements in the list 1");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements in the list1");
        int value = Integer.parseInt(br.readLine());
        ListNode list1 = new ListNode(value);
        list1.next = null;
        for (int i = 1; i < num; i++) {
            System.out.println("Enter value");
            value = Integer.parseInt(br.readLine());
            insertIntoList(list1, value);
        }
        System.out.println("Enter the number of elements in the list 2");
        br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements in the list 2");
        value = Integer.parseInt(br.readLine());
        ListNode list2 = new ListNode(value);
        list2.next = null;
        for (int i = 1; i < num; i++) {
            System.out.println("Enter value");
            value = Integer.parseInt(br.readLine());
            insertIntoList(list2, value);
        }
        System.out.println("List 1");
        printList(list1);
        System.out.println("List 2");
        printList(list2);
        ListNode mergedList = mergeTwoLists(list1, list2);
        System.out.println("Merged List");
        printList(mergedList);
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
        if (n1 == start)
            System.out.println();
        while (n1 != null) {
            System.out.print(n1.val);
            if (n1.next != null)
                System.out.print("-> ");
            n1 = n1.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
                return null;

        ListNode mergeHead=null;
        ListNode p=null;
        while(l1!=null&&l2!=null)
        {
            if(mergeHead==null) {
                if (l1.val < l2.val) {
                    mergeHead = l1;
                    l1=l1.next;
                    mergeHead.next=null;
                }
                else {
                    mergeHead = l2;
                    l2 = l2.next;
                    mergeHead.next=null;
                }
                p=mergeHead;
            }
            else
            {

                if(l1.val<l2.val)
                {
                    p.next=l1;
                    l1=l1.next;
                    p.next.next=null;
                }
                else
                {
                    p.next=l2;
                    l2=l2.next;
                    p.next.next=null;

                }
              p=p.next;
            }

        }
        if(l1!=null) {
            p.next = l1;
            if(mergeHead==null)
                mergeHead=l1;
        }
        if(l2!=null) {
            p.next = l2;
            if(mergeHead==null)
                mergeHead=l2;
        }
        return mergeHead;
    }
}