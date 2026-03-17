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
    List<Integer> ans;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent=new HashMap<>();
        parentrelation(root, parent);
        ans=new ArrayList<>();
        distance(target, k, parent);
        return ans;
    }
    public void distance(TreeNode root, int dist, HashMap<TreeNode, TreeNode> parent){
        if(dist==0){
            ans.add(root.val);
            return;
        }
        int value=root.val;
        root.val=-1;
        if(root.left!=null && root.left.val!=-1){
            distance(root.left, dist-1, parent);
        }
        if(root.right!=null && root.right.val!=-1){
            distance(root.right, dist-1, parent);
        }
        if(parent.containsKey(root) && parent.get(root).val!=-1){
            distance(parent.get(root), dist-1, parent);
        }
        root.val=value;
    }
    public void parentrelation(TreeNode root, HashMap<TreeNode, TreeNode> map){
        if(root==null){
            return;
        }
        if(root.left!=null){
            map.put(root.left, root);
        }
        if(root.right!=null){
            map.put(root.right, root);
        }
        parentrelation(root.left, map);
        parentrelation(root.right, map);
    }
}