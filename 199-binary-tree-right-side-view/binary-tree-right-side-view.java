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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();

        if(root==null){
            return result;
        }
        else{
            q.add(root);
            q.add(null);
        }
        List<Integer> inner=new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode node=q.poll();
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
                ans.add(inner);
                inner=new ArrayList<>();

                if(!q.isEmpty()){
                    q.add(null);
                }
            }
        }

        for(int i=0;i<ans.size();i++){
            List<Integer> res=ans.get(i);

            result.add(res.get(res.size()-1));
        }

        return result;

    }
}