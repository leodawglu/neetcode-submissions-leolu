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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode res = new ListNode(0);
        ListNode runner = res;
        int carryOver =0;
        while(l1!=null && l2!=null){
            int total = l1.val + l2.val + carryOver;
            carryOver = total>9? 1:0;
            runner.next = new ListNode(total%10);
            runner = runner.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            int total = l1.val + carryOver;
            carryOver = total>9? 1:0;
            runner.next = new ListNode(total%10);
            runner = runner.next;
            l1 = l1.next;
        }

        while(l2!=null){
            int total = l2.val + carryOver;
            carryOver = total>9? 1:0;
            runner.next = new ListNode(total%10);
            runner = runner.next;
            l2 = l2.next;
        }
        if(carryOver!=0){
            runner.next = new ListNode(carryOver);
            runner =runner.next;
        }

        return res.next;
    }
}
