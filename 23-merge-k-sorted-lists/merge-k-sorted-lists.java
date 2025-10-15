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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minheap=new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
            minheap.offer(lists[i]);
            }
        }

        ListNode head=null;
        ListNode curr=null;

        while(!minheap.isEmpty()){
            ListNode currmin=minheap.poll();
            if(head==null && curr==null){
                head=currmin;
                curr=currmin;
            }
            else{
                curr.next=currmin;
                curr=currmin;
            }
            if(currmin.next!=null){
            minheap.add(currmin.next);
            }
        }
        return head;
    }
   
}