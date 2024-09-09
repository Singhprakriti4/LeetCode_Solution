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
        int r=0;
        int c=0;


        while(top<=bottom && left<=right){
          
          while(c<=right){
            if(curr!=null){
                arr[r][c]=curr.val;
            }
            else{
                arr[r][c]=-1;
            }
            if(curr!=null)curr=curr.next;
            c++;
          }
          c--;
          
          top++;
          if(top<=bottom && left<=right){
            r++;
            while(r<=bottom){
                if(curr!=null){
                    arr[r][c]=curr.val;
                }
                else{
                    arr[r][c]=-1;
                }
                 if(curr!=null)curr=curr.next;
                r++;
            }
             r--;
          }
        
         right--;
         if(right>=left && top<=bottom){
            c--;
            while(c>=left){
                if(curr!=null){
                    arr[r][c]=curr.val;
                }
                else{
                    arr[r][c]=-1;
                }
                 if(curr!=null)curr=curr.next;
                c--;
            }
            c++;
         }
           
           bottom--;
           if(bottom>=top && left<=right){
            r--;
            while(r>=top){
                if(curr!=null){
                    arr[r][c]=curr.val;
                }
                else{
                    arr[r][c]=-1;
                }
                 if(curr!=null)curr=curr.next;
                r--; 
            }
            r++;
           }
           left++;
           if(left<=right)
           c++;
           
        }

        return arr;
    }
}