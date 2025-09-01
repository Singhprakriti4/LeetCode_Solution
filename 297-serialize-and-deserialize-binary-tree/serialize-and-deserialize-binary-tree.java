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

       StringBuilder sb=new StringBuilder();
       helper(root,sb);
       sb.deleteCharAt(sb.length()-1);
    //    System.out.println(sb.toString());
       return sb.toString();

    }
    public void helper(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("$.");
            return;
        }

        sb.append(root.val+".");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] parts = data.split("\\.");
        return helperdfs(parts);

    }
    int idx=0;
    public TreeNode helperdfs(String[] parts){
        if(idx>=parts.length){
            return null;
        }
        if( parts[idx].equals("$")){
            idx+=1;
            return null;
        }
        
        TreeNode root=new TreeNode(Integer.parseInt(parts[idx]));
        idx+=1;

        root.left=helperdfs(parts);
        root.right=helperdfs(parts);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));