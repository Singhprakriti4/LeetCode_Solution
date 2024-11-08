/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list=new ArrayList<>();
    public void recoverTree(TreeNode root) {
       inorder(root);
       int a=Integer.MIN_VALUE,b=Integer.MIN_VALUE;
       
       int[] arr=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);  
        }

        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=list.get(i)){
                if(a==Integer.MIN_VALUE)
                 a=list.get(i);
                else
                 b=list.get(i);
            }
        }
      System.out.println(a+" "+b);
      reorder(root,a,b);
    }
     public void reorder(TreeNode root,int a, int b){
        if(root==null){
            return;
        }

        if(root.val==a){
            root.val=b;
        }
        else if(root.val==b){
            root.val=a;
        }
        reorder(root.left,a,b);
        reorder(root.right,a,b);
       }
    public void inorder(TreeNode root){
        if(root==null)
        return;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

}