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
    List<ArrayList<Integer>> ans=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        paths(root,list);
        //change in list

        ArrayList<String> solution=new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            StringBuilder str=new StringBuilder();
            boolean isfirst=true;
            for(int j=0;j<ans.get(i).size();j++){
                if(!isfirst){
                    str.append("->");
                }
                str.append(ans.get(i).get(j));
                isfirst=false;
            }
            solution.add(str.toString());
        }
        return solution;

        
    }
    public void paths(TreeNode node,ArrayList<Integer> list){
    
        list.add(node.val);

        //base case
        if(node.left==null && node.right==null){
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

       
         //left call
         if(node.left!=null)
         paths(node.left,list);
         //right call
         if(node.right!=null)
         paths(node.right,list);

        //backtracking and delete jab tak len 0 na ho jaye
        list.remove(list.size()-1);
        return;
         
    }

}