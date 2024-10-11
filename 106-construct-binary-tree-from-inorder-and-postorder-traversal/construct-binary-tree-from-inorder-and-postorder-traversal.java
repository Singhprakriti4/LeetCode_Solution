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
    int postIndex=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex=postorder.length-1;
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            m.put(inorder[i],i);
        }
        return build(m,postorder,0,inorder.length-1);
    }
    public TreeNode build(Map<Integer,Integer> m,int[] postorder,int left,int right){
        if(left>right || postIndex<0){
            return null;
        }
        
        int rootValue=postorder[postIndex];
        int index=m.get(rootValue);
        postIndex--;

        TreeNode root=new TreeNode(rootValue);
        
         root.right= build(m,postorder,index+1,right);
         root.left= build(m,postorder,left,index-1);

        return root;
    }
}