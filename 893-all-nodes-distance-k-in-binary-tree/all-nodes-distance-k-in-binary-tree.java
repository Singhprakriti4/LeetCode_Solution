/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans=new ArrayList<>();
    Map<TreeNode,TreeNode> m=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      parent(root);
      dist(root,target,target,0,k);
      return ans;
    }
    public void parent(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            m.put(root.left,root);
        }
        if(root.right!=null){
            m.put(root.right,root);
        }
        parent(root.left);
        parent(root.right);
    }
   
    public void dist(TreeNode root,TreeNode target,TreeNode fixed,int curr_count,int req_count){
        if(target==null){
            return;
        }
       if(curr_count==req_count ){
        ans.add(target.val);
        return;
       }


    if(m.containsKey(target)){
        TreeNode p=m.get(target);
       if( p!=null && p!=fixed ){
       dist(root,p,target,curr_count +1, req_count);
       }
    }
       
       if(target.left!=fixed && target.left!=null ){
       dist(root,target.left,target,curr_count+1,req_count);
       }
       
       if(target.right!=fixed && target.right!=null){
       dist(root,target.right,target,curr_count+1,req_count);
       }
    }
}