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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr=new int[m][n];
        int top=0;
        int bottom=m-1;
        int left=0;
        int right=n-1;
        ListNode curr=head;
        
        while(top<=bottom && left<=right){
          for(int i=left;i<=right;i++){
            arr[top][i]=curr!=null?curr.val:-1;
             if(curr!=null)curr=curr.next;
          }
          
          top++;
          if(top<=bottom && left<=right){
            for(int j=top;j<=bottom;j++){
                arr[j][right]=curr!=null?curr.val:-1;
                 if(curr!=null)curr=curr.next;
            }
          }
        
         right--;
         if(right>=left && top<=bottom){
           for(int k=right;k>=left;k--){
            arr[bottom][k]=curr!=null?curr.val:-1;
                 if(curr!=null)curr=curr.next;
           }
         }
           
           bottom--;
           if(bottom>=top && left<=right){
           for(int l=bottom;l>=top;l--){
            arr[l][left]=curr!=null?curr.val:-1;
                 if(curr!=null)curr=curr.next;
           }
           }
           left++;
        }

        return arr;
    }
}