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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> array=new ArrayList<>();
        array.add(target.val);
      dist(root,target,target,0,k,array);
      return ans;
    }
    public TreeNode parent(TreeNode root,TreeNode target){
        if(root==null){
            return null;
        }
        if(root.left==target || root.right==target){
            return root;
        }
       
        TreeNode leftparent=  parent(root.left,target);
        TreeNode rightparent=parent(root.right,target);
        if(leftparent!=null){
            return leftparent;
          }
        return rightparent;
    }
    public void dist(TreeNode root,TreeNode target,TreeNode fixed,int curr_count,int req_count,List<Integer> array){
        if(target==null){
            return;
        }
       if(curr_count==req_count ){
        ans.add(target.val);
        return;
       }

       TreeNode p=parent(root,target);
       if( p!=null && p!=fixed && !array.contains(p.val) ){
         array.add(p.val);
       dist(root,p,fixed,curr_count +1, req_count,array);
        array.remove(Integer.valueOf(p.val));
       }
       if(target.left!=fixed && target.left!=null && !array.contains(target.left.val)){
        array.add(target.left.val);
       dist(root,target.left,fixed,curr_count+1,req_count,array);
        array.remove(Integer.valueOf(target.left.val));
       }
       
       if(target.right!=fixed && target.right!=null && !array.contains(target.right.val)){
        array.add(target.right.val);
       dist(root,target.right,fixed,curr_count+1,req_count,array);
       array.remove(Integer.valueOf(target.right.val));
       }
    }
}