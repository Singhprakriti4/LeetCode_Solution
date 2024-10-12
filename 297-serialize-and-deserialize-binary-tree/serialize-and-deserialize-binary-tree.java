/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s="";
        if(root==null){
            return s;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode n=q.poll();
            if(n!=null){
              if(n.left!=null){
                q.offer(n.left);
              }
              else{
                q.offer(null);
              }
              if(n.right!=null){
                q.offer(n.right);
              }
              else{
                q.offer(null);
              }
              s+= n.val+" ";
            }
            else{
                s+="n ";
            }
         
        }
        int i=s.length()-1;
        while(i>=0){
            if(s.charAt(i)=='n' || s.charAt(i)==' '){
             i--;
            }
            else{
                break;
            }}

         System.out.println(s.substring(0,i+1));
          return s.substring(0,i+1);  

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
        return null;
      
        String[] arr=data.split(" ");
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.valueOf(arr[0]));
        q.add(root);
        for(int i=1;i<arr.length;i++){
            TreeNode n=q.poll();
            if(!arr[i].equals("n")){
                n.left=new TreeNode(Integer.valueOf(arr[i]));
                q.add(n.left);
            }
            if( i+1<arr.length && !arr[++i].equals("n")){
                n.right=new TreeNode(Integer.valueOf(arr[i]));
                q.add(n.right);
            }
        }
        return root;
    }
        
    }


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));