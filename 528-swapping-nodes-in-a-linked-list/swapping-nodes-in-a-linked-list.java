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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode beg=head;
        ListNode end=head;
        ListNode last=head;
        int n=1; int s=1;
        
        while(last.next!=null){
            if(n>=k){
                end=end.next;
            }
            last=last.next;
            n++;
        }
       
        while(s!=k){
            beg=beg.next;
            s++;
        }

        int temp=beg.val;
        beg.val=end.val;
        end.val=temp;
        return head;
    }
}