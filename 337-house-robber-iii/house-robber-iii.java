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
    public int rob(TreeNode root) {
        HashMap<TreeNode,int[]> map=new HashMap<>();
        //[]0: true, 1:false
        return robbery(root, true, map);
    }
    public int robbery(TreeNode root, boolean canrob, HashMap<TreeNode,int[]> map){
        if(root==null){
            return 0;
        }
        if(map.containsKey(root)){
            if(canrob && map.get(root)[0]!=-1){
                return map.get(root)[0];
            }
            if(!canrob && map.get(root)[1]!=-1){
                return map.get(root)[1];
            }
        }
        if(canrob){
            //max of robbing and leaving this
            int leave=robbery(root.left,true, map)+robbery(root.right,true, map);
            int robb=robbery(root.left,false, map)+robbery(root.right,false,map)+root.val;
            map.put(root,new int[]{Math.max(leave, robb), -1});
            return Math.max(leave, robb);
        }

        //has toleave cannot do anything
        //so we can rob the next level
        int res= robbery(root.left, true, map)+robbery(root.right, true, map);
        map.put(root, new int[]{-1, res});
        return res;
    }
}