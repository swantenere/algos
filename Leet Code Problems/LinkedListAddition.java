import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by Annam on 18-07-2015.
 */
// Two lists representing two numbers in reversed format and each node has a single digit of the number
 class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
 }
 public class LinkedListAddition {

     public static void main(String args[]) throws Exception {
         System.out.println("Enter the number of elements in the list 1");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int num = Integer.parseInt(br.readLine());
         System.out.println("Enter the elements in the list1");
         int value=Integer.parseInt(br.readLine());
         ListNode list1 =new ListNode(value) ;
         list1.next=null;
         for(int i=1;i<num;i++) {
            System.out.println("Enter value");
            value=Integer.parseInt(br.readLine());
            insertIntoList(list1,value);
         }
         System.out.println("Enter the number of elements in the list 2");
         br = new BufferedReader(new InputStreamReader(System.in));
         num = Integer.parseInt(br.readLine());
         System.out.println("Enter the elements in the list 2");
         value=Integer.parseInt(br.readLine());
         ListNode list2 =new ListNode(value) ;
         list2.next=null;
         for(int i=1;i<num;i++) {
             System.out.println("Enter value");
             value=Integer.parseInt(br.readLine());
             insertIntoList(list2,value);
         }
         System.out.println("List 1");
         printList(list1);
         System.out.println("List 2");
         printList(list2);
         ListNode sumList=addTwoNumbers(list1,list2);
         System.out.println("Sum List");
         printList(sumList);
     }

     public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         int sum = 0, carry = 0;
         if ((l1 == null) || (l2 == null))
             return null;
         ListNode sumList = null;
         while ((l1 != null) && (l2 != null)) {
             sum = (l1.val + l2.val+carry) % 10;
             carry=(l1.val+l2.val+carry)/10;
             if (sumList == null) {
                 sumList=new ListNode(sum);
                 sumList.next = null;
             } else {
                 insertIntoList(sumList, sum);
             }
             l1 = l1.next;
             l2 = l2.next;
         }
         while((l2!=null)&&(l1==null))
         {
             sum = (l2.val + carry) % 10;
             insertIntoList(sumList,sum);
             carry = (l2.val+carry) / 10;
             l2=l2.next;
         }
         while((l1!=null)&&(l2==null))
         {
             sum = (l1.val + carry) % 10;
             insertIntoList(sumList,sum);
             carry = (l1.val+carry) / 10;
             l1=l1.next;
         }
         if(carry!=0)
             insertIntoList(sumList,carry);

         return sumList;
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
 }





