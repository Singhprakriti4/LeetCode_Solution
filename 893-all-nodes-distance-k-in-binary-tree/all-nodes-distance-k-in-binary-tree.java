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
        List<Integer> array=new ArrayList<>();
        parent(root);
        array.add(target.val);
      dist(root,target,target,0,k,array);
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
   
    public void dist(TreeNode root,TreeNode target,TreeNode fixed,int curr_count,int req_count,List<Integer> array){
        if(target==null){
            return;
        }
       if(curr_count==req_count ){
        ans.add(target.val);
        return;
       }


    if(m.containsKey(target)){
        TreeNode p=m.get(target);
       if( p!=null && p!=fixed && !array.contains(p.val) ){
         array.add(p.val);
       dist(root,p,fixed,curr_count +1, req_count,array);
        array.remove(Integer.valueOf(p.val));
       }
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