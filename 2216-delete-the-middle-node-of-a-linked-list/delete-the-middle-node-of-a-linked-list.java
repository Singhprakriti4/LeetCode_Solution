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
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=null;
        if(head==null){
            return head;
        }
        if(head.next==null){
            return null;
        }

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(prev==null){
                prev=head;
            }
            else{
                prev=prev.next;
            }
        }
        prev.next=slow.next;

        return head;
    }
}