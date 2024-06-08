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
    public int getDecimalValue(ListNode head) {

        ArrayList<Integer> list=new ArrayList<>();
        ListNode ptr=head;
        while(ptr.next!=null){
            list.add(ptr.val);
            ptr=ptr.next;
        }
        list.add(ptr.val);
        int n=list.size();
        int ans=0;
        int k=0;
        while(k<list.size()){
            ans+=list.get(k)*(int)Math.pow(2,n-1);
            n--;
            k++;
        }
        return ans;
    }
}