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
    public ListNode removeNthFromEnd(ListNode head, int n) {
     int k=0;
     ListNode temp=head;
    ListNode prev=head;

    while(temp!=null){
        if(k>n){
            prev=prev.next;
        }
        temp=temp.next;
        k++;
    }
    if(k==n){
        head=head.next;
        return head;
    }
    if(prev.next!=null){
    prev.next=prev.next.next;
    }
    
    return head;
        
    }
}