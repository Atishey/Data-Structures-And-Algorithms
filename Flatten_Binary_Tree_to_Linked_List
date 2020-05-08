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
    TreeNode getRightMost(TreeNode root){
        if(root == null)
            return root;
        while(root.right != null)
            root = root.right;
        return root;  
    }
    
    TreeNode flatten(TreeNode root,TreeNode parent){
        if(root == null)
  	    return root;
        TreeNode temp_right = root.right;
        root.right = flatten(root.left,root);
        TreeNode rightmost = getRightMost(root.left);
        root.left = null;
        if(rightmost != null){
            rightmost.left = null;
            rightmost.right = flatten(temp_right,root);
        }    
        else{
            root.left = null;
            root.right = flatten(temp_right,root);
        }    
      return root;  
    }
    
    public void flatten(TreeNode root) {
        flatten(root,null);
    }
}





//Shorter and cleaner solution

class Solution {
    TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
   public void flattenTree(TreeNode root) {
       if(root == null)
           return;
       TreeNode left = root.left;
       TreeNode right = root.right;
       if(prev != null){
           prev.right = root;
           prev.left = null;
       }
       prev = root;
       flattenTree(left);
       flattenTree(right);
   }
} 
