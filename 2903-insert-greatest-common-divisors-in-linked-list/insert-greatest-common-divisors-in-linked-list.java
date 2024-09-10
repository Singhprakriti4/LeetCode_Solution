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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr=head.next;
        ListNode prev=head;

        while(curr!=null){
          int divisor=gcd(curr.val,prev.val);
          ListNode node=new ListNode();
          node.val=divisor;
          prev.next=node;
          node.next=curr;
          prev=curr;
          curr=curr.next;
        }

        return head;
    }
    public int gcd(int a, int b){
        int start=(a>=b)?a:b;
        int end=(a>=b)?b:a;
        for(int i=start;i>1;i--){
            if(a%i==0 && b%i==0){
                return i;
            }
        }
        return 1;
    }
}