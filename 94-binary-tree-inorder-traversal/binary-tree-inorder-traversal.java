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
    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stk=new Stack<>();
        List<Integer> res=new ArrayList<>();

        if(root!=null){
            stk.push(root);
        }

        while(!stk.isEmpty()){
            
            TreeNode node=stk.pop();

            if((node.left==null || node.left.val==-1000) && (node.right==null
             || node.right.val==-1000)){
                //all have been done
                res.add(node.val);
                node.val=-1000;
                continue;
            }
            if((node.left==null || node.left.val==-1000) &&
             (!stk.isEmpty() && stk.peek()==node.right)){
                //right is already pushed
                res.add(node.val);
                node.val=-1000;
                continue;
            }

            if(node.right!=null && node.right.val!=-1000){
                stk.push(node.right);
            }
            stk.push(node);
            if(node.left!=null && node.left.val!=-1000){
                stk.push(node.left);
            }
        }
        return res;
    }
}