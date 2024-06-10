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
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
      int pos=Integer.MIN_VALUE;
        boolean cond=true;
        while(cond){
          if(head.next==null ){
            cond=false;
            return false;
          }
          else{
            if(head.next.val==pos){
                cond=false; 
                return true;
            }
            head.val=pos;
            // pos++;
            head=head.next;
            
          }
        }
        return true;
    }
}