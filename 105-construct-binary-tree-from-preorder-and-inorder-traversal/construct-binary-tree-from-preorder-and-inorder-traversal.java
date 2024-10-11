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
    int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            m.put(inorder[i],i);
        }
       return tree(preorder,inorder,0,inorder.length-1,m);
    }
    public TreeNode tree(int[] preorder,int[] inorder,int left,int right,Map<Integer,Integer> m){
        if(left>right){
            return null;
        }     

        int root_val=0;
        int index=0;
        
        root_val=preorder[preindex];
        index=m.get(root_val);
        preindex+=1;
        
        
       TreeNode root=new TreeNode(root_val);
        root.left=tree(preorder,inorder,left,index-1,m);
        root.right=tree(preorder,inorder,index+1,right,m);

        return root;
    }

}