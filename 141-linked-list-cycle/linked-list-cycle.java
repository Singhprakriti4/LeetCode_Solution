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

        ListNode s=head,f=head;   
        do{
            if(s==null){
                return false;
            }
              s=s.next;
            if(f==null || f.next==null){
                return false;
            }
              f=f.next.next;
        }while(s!=f);

        return true;
    }
}