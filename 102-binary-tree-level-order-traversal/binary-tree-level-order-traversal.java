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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if(root==null){
            return ans;
        }
        else{
            q.add(root);
            q.add(null);
            
        }
        List<Integer> inner=new ArrayList<>();

        while(!q.isEmpty()){

            TreeNode node= q.remove();

            if(node==null){
              ans.add(inner);

              if(!q.isEmpty()){
               q.add(null);
               inner=new ArrayList<>();
              }
    
            }
            else{

               inner.add(node.val);
               
               if(node.left!=null){
                q.add(node.left);
               }
               if(node.right!=null){
                q.add(node.right);
               }
            }
        }

        return ans;
    }
}