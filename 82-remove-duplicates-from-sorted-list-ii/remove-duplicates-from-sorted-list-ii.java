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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr=head;
        ListNode prev=null;
        while(curr.next!=null){
            if(curr.next.val!=curr.val){
                curr=curr.next;
                prev=(prev==null)?head:prev.next;
            }
            else{
                while(curr.next!=null && curr.next.val==curr.val){
                    curr=curr.next;
                }
                if(curr.next==null){
                    if(prev==null){
                        return null;
                    }
                    else{
                    prev.next=null;
                    return head;}
                }
               else{ 
                curr=curr.next;
                if(prev!=null){
                prev.next=curr;}
                else{
                head=curr;}
                }
            }
        }
        return head;
    }
}