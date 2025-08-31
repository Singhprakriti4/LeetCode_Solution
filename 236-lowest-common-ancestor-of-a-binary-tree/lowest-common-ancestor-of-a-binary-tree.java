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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1=new ArrayList<>();
        ArrayList<TreeNode> list2=new ArrayList<>();

        ArrayList<TreeNode> curr1=new ArrayList<>();
        ArrayList<TreeNode> curr2=new ArrayList<>();

        dfs(root,p,curr1,list1);
        dfs(root,q,curr2,list2);

        int idx=0;
        TreeNode ans=root;

        for(int i=0;i< list1.size();i++){
            System.out.print(list1.get(i)+" ");
        }
        System.out.println();
         for(int i=0;i< list2.size();i++){
            System.out.print(list2.get(i)+" ");
        }

        while( idx<list1.size() && idx<list2.size() && list1.get(idx)==list2.get(idx)){
            ans=list1.get(idx);
            idx++;
        }
       
        return ans;
    }
    public void dfs(TreeNode root, TreeNode target, ArrayList<TreeNode> curr,
    ArrayList<TreeNode> path){

        if(root==null){
            return;
        }

        curr.add(root);
        if(root==target){
            // path=new ArrayList<>(curr);
            path.addAll(curr);
            curr.remove(curr.size()-1);
            return;
        }

        dfs(root.left, target, curr, path);
        dfs(root.right, target, curr, path);
        curr.remove(curr.size()-1);
    }
}