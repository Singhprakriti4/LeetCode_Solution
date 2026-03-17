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
        TreeMap<Integer, Integer> map=new TreeMap<>();
        sideview(root, 0, map);
        List<Integer> list=new ArrayList<>();

        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            list.add(e.getValue());
        }

        return list;
    }
    public void sideview(TreeNode root, int vd,
    TreeMap<Integer, Integer> map){
        if(root==null){
            return;
        }
        map.put(vd, root.val);
        sideview(root.left, vd+1, map);
        sideview(root.right, vd+1, map);
    }
}