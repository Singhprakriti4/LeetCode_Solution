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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
      ListNode p=head;
      int size=1;
      while(p.next!=null){
        p=p.next;
        size++;
      }
      int t=k%size;
      if(t==0){
        return head;
      }
      ListNode curr=head;
      int curr_ptr=1;
      int prev_ptr=0;
      ListNode prev=null;
      while(curr.next!=null){
        if(curr_ptr-prev_ptr>=t){
            curr=curr.next;
            prev=(prev_ptr==0)?head:prev.next;
            curr_ptr++;
            prev_ptr++;
        }
        else{
            curr=curr.next;
            curr_ptr++;
        }
      }
     ListNode q=prev.next;
     prev.next=null;
     ListNode r=q;
     while(q.next!=null){
        q=q.next;
     }
     q.next=head;
     head=r;
      return head;

    }
}