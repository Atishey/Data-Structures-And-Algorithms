/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    int sum,limit;
    boolean ans = false;
    public void solveUtil(TreeNode root,TreeNode parent,boolean left,boolean right){
        if(root == null){
            return;
        }    
        sum += root.val;
        if(sum >= limit){
            sum -= root.val;
            return;
        }    
        solveUtil(root.left,root,true,false);
        solveUtil(root.right,root,false,true);
        if(root.left == null && root.right == null && sum < limit){
            if(parent == null){
                ans = true;
                return; 
            }    
            if(left)
                parent.left = null ;
            if(right)
                parent.right = null;
        }    
            
        sum -= root.val;
    }
    public TreeNode solve(TreeNode root, int k) {
        
        limit = k;
        sum = 0;
        solveUtil(root,null,false,false);
        if(ans)
            return null;
        return root;
    }
}
