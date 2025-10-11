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
    List<List<Integer>> outer=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> inner=new ArrayList<>();
        func(root,targetSum,0,inner);
        return outer;

    }
    public void func(TreeNode root, int target, int currsum,List<Integer> inner){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            inner.add(root.val);
             if(currsum+root.val==target){
                outer.add(new ArrayList<>(inner));
            }
            inner.remove(inner.size()-1);
            return;

        }

        
        inner.add(root.val);
        func(root.left,target,currsum+root.val,inner);
        func(root.right,target,currsum+root.val,inner);
        inner.remove(inner.size()-1);
    }
    
}