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
    public TreeNode buildTree(int[] preorder1, int[] inorder) {

        ArrayList<Integer> inset=new ArrayList<>();
        for(int i=0;i<inorder.length;i++){
            inset.add(inorder[i]);
        }

        ArrayList<Integer> preorder=new ArrayList<>();
        for(int i=0;i<preorder1.length;i++){
            preorder.add(preorder1[i]);
        }

        return helper(preorder,inset);

    }
    public TreeNode helper(ArrayList<Integer> preorder, ArrayList<Integer> inset){

        if(inset.size()==0 || preorder.size()==0){
            return null;
        }

        //create the root
        TreeNode root=new TreeNode(preorder.get(0));

        //split the set & create the left and right
        int partition=-1;
        for(int i=0;i<inset.size();i++){
            if(inset.get(i).equals(preorder.get(0))){
                partition=i;
                break;
            }
        }
        ArrayList<Integer> leftset=new ArrayList<>();
        ArrayList<Integer> rightset=new ArrayList<>();
        if(partition!=0){
          leftset=new ArrayList<>(inset.subList(0,partition));
        }
        if(partition!=inset.size()-1){
           rightset=new ArrayList<>(inset.subList(partition+1,inset.size()));
        }

        inset.remove(partition);
        preorder.remove(0);

        root.left=helper(preorder,leftset);
        if(root.left==null){
             root.right=helper(preorder, rightset);
        }
        else{
        root.right=helper(preorder, rightset);
        }

        //return root
        return root;
    }
}