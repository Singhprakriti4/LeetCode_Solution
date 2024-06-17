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
    //     ListNode beg=head;
    //     ListNode end=head;
    //     int n=1; int s=1;

    //      while(s!=k){
    //         beg=beg.next;
    //         s++;
    //     }

    //    ListNode newbeg=beg;
    //    while(beg.next!=null){
    //        end=end.next;
    //        beg=beg.next;
    //    }
    //     int temp=newbeg.val;
    //     beg.val=end.val;
    //     end.val=temp;
    //     return head;
     ListNode beg=head;
        ListNode end=head;
         int s=1;

         while(s!=k){
            beg=beg.next;
            s++;
        }

       ListNode newbeg=beg;
       while(beg.next!=null){
           end=end.next;
           beg=beg.next;
       }
        int temp=newbeg.val;
        newbeg.val=end.val;
        end.val=temp;
        return head;
    }
}