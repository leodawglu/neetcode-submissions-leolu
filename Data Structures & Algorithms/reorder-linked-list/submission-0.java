/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode secondHalf = mid.next;
        mid.next = null;
        secondHalf = reverseList(secondHalf);
        mergeLists(head,secondHalf);
    }

    private ListNode findMid(ListNode head){
        if(head==null)return null;
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head){
        ListNode curr = head, prev = null;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private ListNode mergeLists(ListNode list1, ListNode list2){
        ListNode newHead = new ListNode();
        ListNode curr = newHead;
        while(list2!=null){
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }
        if(list1!=null)curr.next=list1;
        return newHead.next;
    }
}
