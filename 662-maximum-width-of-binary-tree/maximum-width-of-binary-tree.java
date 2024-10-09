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
 class Pair<K,V>{
   public K key;
   public V value;

   public Pair(K key,V value){
    this.key=key;
    this.value=value;
   }

   public K getKey(){
    return key;
   }

   public V getValue(){
    return value;
   }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        if( root.left==null && root.right==null)
        return 1;
        int result=0;
        ArrayList<Pair<TreeNode, Integer>> list=new ArrayList<>();
        list.add(new Pair<>(root,0));
        list.add(new Pair<>(null,0));
        
        while(list.size()!=0){
            Pair<TreeNode,Integer> node=list.remove(0);
            TreeNode n=node.getKey();
            int dist=node.getValue();
            if(n!=null){
             if(n.left!=null){
                list.add(new Pair<>(n.left,dist*2));
             }
             if(n.right!=null){
                list.add(new Pair<>(n.right,dist*2+1));
             }

            }
            else{
              if(list.size()!=0){
                list.add(new Pair<>(null,0));
                        
            Pair<TreeNode, Integer> p=list.get(0);
            System.out.println(list.size());
            Pair<TreeNode, Integer> q=list.get(list.size()-2);
            int l=p.getValue();
            int r=q.getValue();

            if(result<r-l+1){
                result=r-l+1;
            }

            }
        }
    }
        return result;
    }
}