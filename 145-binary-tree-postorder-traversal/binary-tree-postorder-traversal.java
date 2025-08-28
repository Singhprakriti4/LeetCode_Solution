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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stk=new Stack<>();

        if(root==null){
            return ans;
        }
        else{
            stk.push(root);
        }

        while(!stk.isEmpty()){

            TreeNode node=stk.peek();
             
             if(node.left==null && node.right==null){
                ans.add(node.val);
                // node=null;
                stk.pop();
            }
            else{
            if(node.right!=null){
                stk.push(node.right);
                node.right=null;
            }
            if(node.left!=null){
                stk.push(node.left);
                node.left=null;
            }

            }
            
        }
        return ans;
    }
}