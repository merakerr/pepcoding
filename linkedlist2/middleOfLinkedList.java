//leetcode 876
/*
given a singly linked list with head node head, return a middle node of linked list.
if there is 2 mid node then return first mid node.
Input Format
1->2->3->4->5->6->7->null
1->2->3->4->5->6->null
Output Format
4->5->6->7->null
3->4->5->6->null
*/

//Note in even case, take second as a mid element.
    
import java.util.*;
public class middleOfLinkedList {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode midNode(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;

      while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
      }
      return slow;
     
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = midNode(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}