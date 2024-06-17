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
    public ListNode reverseBetween(ListNode head, int left, int right) {   
        ListNode l=head;
        ListNode r=head;
         ListNode start=head;
        int diff=right-left;
        int k=1;
        while(k!=right){
            if(k==right-1){
               start=l;
            }
            if(k-1>=diff){
              l=l.next;
            }
          r=r.next;
          k++;
        }
        ListNode end=r.next;
        r.next=null;
         if(left==1){
            int s=0;
            while(s!=right-1){
                head=head.next;
                s++;
            }
        }
        reverse(l,r);
        start.next=r;
        l.next=end;
       
        return head;
    }
    void reverse(ListNode l,ListNode r){
        ListNode back=null;
        ListNode curr=l;
        ListNode f=l.next;
        while(curr!=null){
           curr.next=back;
           back=curr;
           curr=f;
           if(f!=null){
           f=f.next;}
        }
    }
}