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
    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> ans=new ArrayList<>();
        PrintRight(root,ans,0);

        return ans;
        
    }
    public void PrintRight(TreeNode root, ArrayList<Integer> ans, int level){
        if(root==null){
            return;
        }
        if(level>=ans.size()){
       ans.add(level,root.val);}
       else{
        ans.set(level,root.val);
       }
        PrintRight(root.left,ans,level+1);
        PrintRight(root.right,ans,level+1);
    }
}