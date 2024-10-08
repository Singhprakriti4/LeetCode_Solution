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
        Queue<Pair<TreeNode,Pair<Integer,Integer>>> q=new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> m=new TreeMap<>();
        if(root==null){
            return ans;
        }
        q.add(new Pair<>(root,new Pair<>(0,0)));
        while(!q.isEmpty()){
            Pair<TreeNode,Pair<Integer,Integer>> p=q.poll();
            
            TreeNode n=p.getKey();
           
            int row=p.getValue().getKey();
            int col=p.getValue().getValue();
           
            m.computeIfAbsent(col, k -> new TreeMap<>())
             .computeIfAbsent(row, k -> new ArrayList<>())
             .add(n.val);

             if(n.left!=null)
             q.add(new Pair<>(n.left,new Pair<>(row+1,col-1)));
             if(n.right!=null)
             q.add(new Pair<>(n.right,new Pair<>(row+1,col+1)));
        }

    for (TreeMap<Integer, ArrayList<Integer>> innerMap : m.values()) {
    List<Integer> columnList = new ArrayList<>();
    for (ArrayList<Integer> set : innerMap.values()) {
        Collections.sort(set);
        columnList.addAll(set);
    }
    ans.add(columnList);
}

      return ans;
    }
    
}