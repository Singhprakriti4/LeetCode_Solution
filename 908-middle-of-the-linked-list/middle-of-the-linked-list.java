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
    public ListNode middleNode(ListNode head) {
        ListNode a=head;
        ListNode b=head;
        int ptr=1;
        int c=1;
        while(b.next!=null){
          b=b.next; 
          ptr++;
        }
       ptr=ptr/2+1;
        while(c<ptr){
           a=a.next;
           c++;
        }
        return a;
    }
}