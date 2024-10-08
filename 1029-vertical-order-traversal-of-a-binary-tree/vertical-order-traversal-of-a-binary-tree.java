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
            //the node is the key for our outer pair
            TreeNode n=p.getKey();
            //the inner pair stores the row and the col of our node 'n'
            int row=p.getValue().getKey();
            int col=p.getValue().getValue();
            //map me add krna properly
           
            if(m.containsKey(col)){
                if(m.get(col).containsKey(row)){
                  m.get(col).get(row).add(n.val);
                }
                else{
                 m.get(col).put(row,new ArrayList<>(Arrays.asList(n.val)));
                }
            }
            else{
                TreeMap<Integer,ArrayList<Integer>> inner=new TreeMap<>();
                inner.put(row, new ArrayList<>(Arrays.asList(n.val)));
               m.put(col,inner);
            }
             if(n.left!=null)
             q.add(new Pair<>(n.left,new Pair<>(row+1,col-1)));
             if(n.right!=null)
             q.add(new Pair<>(n.right,new Pair<>(row+1,col+1)));
        }

        for(Integer col: m.keySet()){
         List<Integer> inner=new ArrayList<>();
            for(Integer row : m.get(col).keySet()){
               ArrayList<Integer> set=m.get(col).get(row);
               Collections.sort(set);
               inner.addAll(set);
            }
            ans.add(inner);
        }
      return ans;
    }
    
}