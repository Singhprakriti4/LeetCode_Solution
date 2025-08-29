
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer, ArrayList<Integer>>> outer=new TreeMap<>();
        helper(outer, 0, 0, root);

        //traverse on the set and fill in the values
        for(Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> e: outer.entrySet()){
            int col=e.getKey();
            List<Integer> inner=new ArrayList<>();
            for(Map.Entry<Integer, ArrayList<Integer>> in: e.getValue().entrySet() ){
                int row=in.getKey();
                ArrayList<Integer> values=in.getValue();
                Collections.sort(values);
                for(int i=0;i<values.size();i++){
                    inner.add(values.get(i));
                }
            }
            ans.add(inner);
        }

        return ans;

    }
    public void helper( TreeMap<Integer,TreeMap<Integer, ArrayList<Integer>>> outer
    ,int row, int col, TreeNode root ){

        if(root==null){
            return;
        }

        if(!outer.containsKey(col)){
           TreeMap<Integer, ArrayList<Integer>> inner=new TreeMap<>();
           outer.put(col, inner);
        }
        if(!outer.get(col).containsKey(row)){
            outer.get(col).put(row,new ArrayList<>());
        }

        outer.get(col).get(row).add(root.val);

        helper(outer, row+1, col-1, root.left);
        helper(outer, row+1, col+1, root.right);
        
    }
}