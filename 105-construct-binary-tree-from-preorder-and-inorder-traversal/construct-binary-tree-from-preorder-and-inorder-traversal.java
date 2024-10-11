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

        for(int i=0;i<preorder.length;i++){
            if(m.containsKey(preorder[i]) && (m.get(preorder[i])<=right && m.get(preorder[i])>=left)){
                root_val=preorder[i];
                index=m.get(preorder[i]);
                break;
            }
        }
        
       TreeNode root=new TreeNode(root_val);
        root.left=tree(preorder,inorder,left,index-1,m);
        root.right=tree(preorder,inorder,index+1,right,m);

        return root;
    }

}