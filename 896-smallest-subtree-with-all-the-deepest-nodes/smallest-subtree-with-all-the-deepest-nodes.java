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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // bfs and get leftmost and rightmost nodes
        // get their lca as an answer
        // int lastlevel=0;
        // TreeNode left=null;
        // TreeNode right=null;
        List<List<TreeNode>> outer=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        List<TreeNode> inner=new ArrayList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node!=null){
                inner.add(node);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            else{
                if(outer.size()>0){
                    outer.remove(0);
                }
                outer.add(inner);
                if(!q.isEmpty()){
                    q.add(null);
                }
                inner=new ArrayList<>();
            }
        }
        List<TreeNode> list=outer.get(0);
        TreeNode p=list.get(0);
        TreeNode qu=list.get(list.size()-1);

        if(p==qu) return p;

        return lca(root,p,qu);
    }
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode left=lca(root.left,p,q);
        TreeNode right=lca(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        if(left==null && right==null){
            return null;
        }
        if(left!=null && right==null){
            return left;
        }
        return right;
    }
}