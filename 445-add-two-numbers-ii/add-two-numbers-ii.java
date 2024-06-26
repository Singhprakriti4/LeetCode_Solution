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
       l1= reverse(l1);
       l2=reverse(l2);
       ListNode ans=new ListNode(0);
       ListNode head=ans;
       ListNode ptr=head;
       int carry=0;
       while(l1!=null && l2!=null){
         ListNode node=new ListNode((l1.val+l2.val+carry)%10);
         ptr.next=node;
         ptr=ptr.next;
         carry=(l1.val+l2.val+carry)/10;
         l1=l1.next;
         l2=l2.next;
       }
       while(l1!=null){
        ListNode node=new ListNode((l1.val+carry)%10);
        ptr.next=node;
        ptr=ptr.next;
        carry=(l1.val+carry)/10;
        l1=l1.next;
       }
        while(l2!=null){
        ListNode node=new ListNode((l2.val+carry)%10);
        ptr.next=node;
        ptr=ptr.next;
        carry=(l2.val+carry)/10;
        l2=l2.next;
       }
    if(carry!=0){
        ListNode node=new ListNode(carry);
        ptr.next=node;
        ptr=ptr.next;
    }
    head=reverse(head.next);
    return head;   
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;       
        while(curr!=null){
         ListNode next=curr.next;
         curr.next=prev;
          prev=curr;
          curr=next;
        }
       return prev;
    }
}