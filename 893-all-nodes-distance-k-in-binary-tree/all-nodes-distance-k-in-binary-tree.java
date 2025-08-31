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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //child parent
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        helper(root, null,map );

        //debugging helper
        // for(Map.Entry<TreeNode,TreeNode> e: map.entrySet()){
        //     System.out.println(e.getKey() +" "+ e.getValue());
        //     System.out.println();
        // }

        List<Integer> ans=new ArrayList<>();
        dfs(target, 0, k, map, ans );
        return ans;


    }
    //to fill child-parent map
    public void helper(TreeNode root, TreeNode prev, HashMap<TreeNode,TreeNode> map){
        if(root==null ){
            return;
        }
        map.put(root,prev);

        helper(root.left, root, map);
        helper(root.right, root, map);
    }

    public void dfs(TreeNode root, int currdist, int target,
    HashMap<TreeNode,TreeNode> map, List<Integer> ans){

        if(root==null || root.val==-1 || currdist>target){
            return;
        }

        if(currdist==target){
            ans.add(root.val);
            return;
        }
        //explore all 3 paths
        int previousvalue=root.val;
        root.val=-1;
        if(map.containsKey(root)){
            dfs(map.get(root),currdist+1, target, map, ans);
        }
            dfs(root.left, currdist+1, target, map, ans);
            dfs(root.right, currdist+1, target, map, ans);

        root.val=previousvalue;
    }

}