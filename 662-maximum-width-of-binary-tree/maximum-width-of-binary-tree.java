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
    public int widthOfBinaryTree(TreeNode root) {
        TreeMap<Integer, ArrayList<Long>> map=new TreeMap<>();
        helper(root, 1, 0, map);
       
        long ans=0;
        for(Map.Entry<Integer, ArrayList<Long>> entry: map.entrySet()){
            ArrayList<Long> list=entry.getValue();
            Collections.sort(list);
            long start=list.get(0);
            long end= list.get(list.size()-1);
            long curr=end-start+1;
            if(curr>ans) ans=curr;
        }

        return (int)ans;
    }
    public void helper(TreeNode root, long idx, int level, TreeMap<Integer,ArrayList<Long>> map){
        if(root==null){
            return;
        }
        //addidx in the map
        if(!map.containsKey(level)){
            ArrayList<Long> list=new ArrayList<>();
            list.add(idx);
            map.put(level,list);
        }
        else{
            map.get(level).add(idx);
        }

        // if(idx==0){
        //     helper(root.left, 1, level+1, map);
        //     helper(root.right, 2, level+1, map);
        // }
        // else{
            helper(root.left, 2*idx, level+1, map);
            helper(root.right, 2*idx+1, level+1, map);
        // }
    }
}