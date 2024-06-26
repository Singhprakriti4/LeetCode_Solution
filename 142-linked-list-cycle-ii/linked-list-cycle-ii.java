/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       ListNode temp=head;
       boolean cond=true;
       do{
        if(temp==null || temp.next==null){
            cond=false;
            return null;
        }
        else{
           
            if(temp.next.val==Integer.MAX_VALUE){
                cond=false;
                return temp.next;
            }
             temp.val=Integer.MAX_VALUE;
            temp=temp.next;
        }
       }while(cond);
        return temp;
    }
}