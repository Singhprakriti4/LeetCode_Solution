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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head==null){
            return head;
        }
       Set<Integer> li=new HashSet<>();
       for (int num : nums) {
            li.add(num);
        }

      return deletenodes(head,li);
        
    }
     ListNode deletenodes(ListNode head,Set<Integer> li){
        ListNode curr=head;
        ListNode prev=null;
         if(li.contains(curr.val)){
        while(li.contains(curr.val)){
            curr=curr.next;
            head=head.next;
        }}
       
            prev=curr;
            curr=curr.next;
    

        while(curr!=null){
            if(li.contains(curr.val)){
              curr=curr.next;
              prev.next=curr;
            }
            else{
                curr=curr.next;
                prev=prev.next;
            }
        }
      return head;
    }
}