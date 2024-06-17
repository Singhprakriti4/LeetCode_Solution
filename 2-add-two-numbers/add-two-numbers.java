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
       ListNode i=l1;
       ListNode j=l2;
       ListNode head=new ListNode();
       ListNode k=head;
       int carry=0,sum=0;
       while(i!=null && j!=null){
         sum=i.val+j.val+carry;
          ListNode node=new ListNode(sum%10);
          carry=sum/10;
          k.next=node;
          k=k.next;
          i=i.next;
          j=j.next;
       } 
       while(i!=null){
        sum=i.val+carry;
        ListNode node=new ListNode(sum%10);
        carry=sum/10;
        k.next=node;
        k=k.next;
        i=i.next;
       }
        while(j!=null){
        sum=j.val+carry;
        ListNode node=new ListNode(sum%10);
        carry=sum/10;
        k.next=node;
        k=k.next;
        j=j.next;
       }
       if(carry !=0){
        ListNode node=new ListNode(carry);
        k.next=node;
        k=k.next;
       }
       return head.next;
    }
}