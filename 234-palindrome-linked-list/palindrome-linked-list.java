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
    public boolean isPalindrome(ListNode head) {
        
        StringBuilder a=new StringBuilder();

         while(head!=null){
            a.append(head.val);
            head=head.next;
        }
        String c=a.toString();
        String b=a.reverse().toString();
        return b.equals(c); 
    }
}