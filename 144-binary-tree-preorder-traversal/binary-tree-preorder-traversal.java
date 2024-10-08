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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stk=new Stack<>();
        if(root==null){
            return ans;
        }
        stk.push(root);
        while(!stk.isEmpty()){
           TreeNode n=stk.pop();
           ans.add(n.val);
           if(n.right!=null)
           stk.push(n.right);
           if(n.left!=null)
           stk.push(n.left);
        }
        return ans;
    }
}