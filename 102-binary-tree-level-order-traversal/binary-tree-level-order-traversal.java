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
       List<List<Integer>> outer=new ArrayList<>();
       Queue<TreeNode> q=new LinkedList<>();

       if(root==null)return outer;

       q.add(root);
       q.add(null);
        List<Integer> inner=new ArrayList<>();

       while(!q.isEmpty()){
         if(q.element()!=null){
        
            TreeNode n=q.poll();
            
            inner.add(n.val);
            if(n.left!=null)q.add(n.left);
            if(n.right!=null)q.add(n.right);
            
         }
         else{
            outer.add(inner);
            q.poll();
            if(q.isEmpty())break;
            inner=new ArrayList<>();
            q.add(null);
         }
       }
       return outer;
    }
}