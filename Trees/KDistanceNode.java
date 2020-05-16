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
    class Pair{
        TreeNode node;
        int dist;
        Pair(TreeNode node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    
    HashMap<TreeNode,TreeNode> h;
    TreeNode src;
    void connectKNodes(TreeNode root,TreeNode parent,int source){
        if(root == null)
            return;
        // System.out.println(">>>"+root.val);    
        if(root.val == source)
            src = root;
        h.put(root,parent);
        connectKNodes(root.left,root,source);
        connectKNodes(root.right,root,source);
    }
    
    public ArrayList<Integer> solve(TreeNode root, int source, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        h = new HashMap<TreeNode,TreeNode>();
        connectKNodes(root,null,source);
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(src,0));
        HashMap<TreeNode,Integer> vis = new HashMap<TreeNode,Integer>();
        while(!q.isEmpty()){
            Pair temp = q.poll();
            vis.put(temp.node,1);
            if(temp.dist == k){
                res.add(temp.node.val);
            }
            if(temp.node.left != null && !vis.containsKey(temp.node.left)) {
                q.add(new Pair(temp.node.left,temp.dist+1));
            }
            if(temp.node.right != null && !vis.containsKey(temp.node.right))
                q.add(new Pair(temp.node.right,temp.dist+1));
            
            if(temp.node != null && h.containsKey(temp.node) && h.get(temp.node) != null && !vis.containsKey(h.get(temp.node)))
                q.add(new Pair(h.get(temp.node),temp.dist+1));
        }
        
        return res;
        
        
    }
}
