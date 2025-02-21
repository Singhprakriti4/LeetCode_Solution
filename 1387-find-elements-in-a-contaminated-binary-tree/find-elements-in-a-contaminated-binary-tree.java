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
class FindElements {
    private TreeNode root;
    public FindElements(TreeNode root) {
        this.root=root;
        //recover the tree
        if(root!=null) root.val=0;
        recover (root);
    }
    
    public void recover(TreeNode root){
      if(root.left!=null){
        root.left.val=root.val*2+1;
        recover(root.left);
      }
      if(root.right!=null){
        root.right.val=root.val*2+2;
        recover(root.right);
      }
    }

    public boolean find(int target) {
       return find1(target,root);
    }

    public boolean find1(int target, TreeNode root){
        if(root==null){
            return false;
        }
        if(root.val==target){
            return true;
        }
        return find1(target,root.left)||find1(target,root.right);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */