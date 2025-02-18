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
    //outer list
    List<List<Integer>> outer =new ArrayList<>();
    if(root==null){
        return outer;
    }
    ArrayList<Integer> inner=new ArrayList<>();
    Queue<TreeNode> q=new LinkedList<>();
    q.add(root);
    q.add(null);

    while(!q.isEmpty()){
       TreeNode n=q.poll();
       if(n!=null){
          inner.add(n.val);
          if(n.left!=null){
            q.add(n.left);
          }
          if(n.right!=null){
            q.add(n.right);
          }
       }
       else{
        outer.add(inner);
         if(!q.isEmpty()){
            q.add(null);
            inner=new ArrayList<>();
         }
       }
    }
    return outer;
    }
}