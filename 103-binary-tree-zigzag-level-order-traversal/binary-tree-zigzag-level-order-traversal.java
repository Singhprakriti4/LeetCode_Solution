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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return ans;
        }
        q.add(root);
        q.add(null);
        int count=0;
        List<Integer> inner=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode n=q.poll();
            if(n!=null){

                inner.add(n.val);
                if(n.left!=null)q.add(n.left);
                if(n.right!=null)q.add(n.right);
            }
            else{
              if(count%2==0){
                ans.add(inner);
              }
              else{
                Collections.reverse(inner);
                ans.add(inner);
              }
              count++;
              if(q.isEmpty())break;
              inner=new ArrayList<>();
              q.add(null);

            }
        }
        return ans;
    }
}