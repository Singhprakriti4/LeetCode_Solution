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
    public int maxLevelSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans=1;
        int maxsum=Integer.MIN_VALUE;
        int currsum=0;
        int currlevel=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode currnode=q.poll();
            if(currnode!=null){
                // continuation of curr level
                currsum+=currnode.val;
                if(currnode.left!=null){
                    q.add(currnode.left);
                }
                if(currnode.right!=null){
                    q.add(currnode.right);
                }
            }
            else{
                //beginning of a new level
                if(currsum>maxsum){
                    maxsum=currsum;
                    ans=currlevel;
                }
                currsum=0;
                currlevel+=1;
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
        }
        return ans;
    }
}