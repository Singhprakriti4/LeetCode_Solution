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
    int ans=1;
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, Integer> map=new HashMap<>();
        width(root, 0, 1, map);
        return ans;
    }
    public void width(TreeNode root, int level, int index, 
     HashMap<Integer, Integer> map){
        if(root==null){
            return;
        }
        if(!map.containsKey(level)){
            map.put(level, index);
        }
        else{
            ans=Math.max(ans, index-map.get(level)+1);
        }
        width(root.left, level+1, index*2, map);
        width(root.right, level+1, index*2+1, map);
    }
}