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
        ListNode t1 = l1;
        ListNode t2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;

        while(t1!=null || t2!=null){
            int sum = 0;

            if(t1!=null)sum += t1.val;
            if(t2!=null)sum += t2.val;
            sum += carry;

            if(sum >= 10){
                carry = 1;
            }else{
                carry = 0;
            }

            sum = sum % 10;
            ListNode curNode = new ListNode(sum);
            curr.next = curNode;
            curr = curr.next;

            if(t1!=null)t1 = t1.next;
            if(t2!=null)t2 = t2.next;

        } 

        if(carry == 1){
            ListNode carryNode = new ListNode(carry);
            curr.next = carryNode;
        }

        return dummy.next;
        
    }
}
