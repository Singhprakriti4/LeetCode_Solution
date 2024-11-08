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
   
    public void recoverTree(TreeNode root) {
        TreeNode one=null;
        TreeNode two=null;
         List<TreeNode> list=new ArrayList<>();

        inorder(root,list);
        int[] arr=new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i).val;
        }

        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=list.get(i).val){
                if(one==null){
                    one=list.get(i);
                }
                else{
                    two=list.get(i);
                }
            }
        }

        int temp=one.val;
        one.val=two.val;
        two.val=temp;
        
    }
    public void inorder(TreeNode root, List<TreeNode> list){
        if(root==null)
        return;

        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
}