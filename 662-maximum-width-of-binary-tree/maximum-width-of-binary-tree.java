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
 //start indexing from 1 always;
class Solution {
    int maxwidth=1;
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        ArrayList<Integer> list=new ArrayList<>();
        helper(root, list, 1, 0);
        return maxwidth;

    }
    public void helper(TreeNode root, ArrayList<Integer> list, int idx, int level){
        if(root==null){
            return;
        }

        if(level>= list.size()){
            //not exists
            list.add(idx);
        }
        else{
            //contains first index
            int curr= idx-list.get(level)+1;
            if(curr>maxwidth) maxwidth=curr;
        }

        helper(root.left, list, 2*idx, level+1);
        helper(root.right, list, 2*idx+1, level+1);
    }
}