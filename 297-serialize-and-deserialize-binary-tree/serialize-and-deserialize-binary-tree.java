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
    StringBuilder sb=new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root){
        serial(root);
        return sb.toString();
    }
    public void serial(TreeNode root) {
        if(root==null){
            sb.append('n');
            sb.append(' ');
            return;
        }
        if(root.left==null && root.right==null){
            sb.append(root.val);
            sb.append(' ');
            sb.append('n');
            sb.append(' ');
            sb.append('n');
            sb.append(' ');
            return;
        }
        //root
        sb.append(root.val);
        sb.append(' ');
        serial(root.left);
        serial(root.right);
    }


    // Decodes your encoded data to tree.
    int idx=-1;
    public TreeNode deserialize(String data) {
        String[] arr=data.split(" ");
        // for(String s: arr){
        //     System.out.print(s+" ");
        // }
        // return null;
        return deserial(arr);
    }
    public TreeNode deserial(String[] arr){
        idx+=1;
        if(arr[idx].equals("n")){
            return null;
        }

        TreeNode n=new TreeNode(Integer.valueOf(arr[idx]));
        n.left=deserial(arr);
        n.right=deserial(arr);
        return n;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));