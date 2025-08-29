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
        boolean flag=false;
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();

        if(root==null){
            return list;
        }
        else{
            q.add(root);
            q.add(null);
        }

        List<Integer> inner=new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode node=q.remove();
            if(node!=null){
                inner.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            else{
               if(flag){
                Collections.reverse(inner);
               }
               flag=!flag;//flag change
               list.add(inner);

               if(!q.isEmpty()){
                inner=new ArrayList<>();
                q.add(null);
               }
            }
        }
        return list;
    }
}