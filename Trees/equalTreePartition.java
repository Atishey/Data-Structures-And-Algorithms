/* To check whether removing an edge can divide the tree in two sum having equal sum*/
/*
  Calculate sum till leaf node for each node and store in HashMap. If the sum is odd then we will not have two equal sum trees 
  and if we have a node with sum as not equal to half of total sum of tree. partitioning is not possible 
*/
public class Solution {
    
    int sum;
    HashMap<Integer,Integer> h;
    
    public int sumTillNode(TreeNode root){
        if(root == null)
            return 0;
        int left = sumTillNode(root.left);
        int right = sumTillNode(root.right);
        int sum = root.val + left + right;
        if(h.containsKey(sum))
            h.put(sum,h.get(sum)+1);
        else
            h.put(sum,1);
        return sum;
    }

    public int solve(TreeNode root) {
        h = new HashMap<>();
        if(root == null)
            return 1;
        sum = sumTillNode(root);
        if(sum%2 != 0)
            return 0;
        if(sum == 0){
            return (h.get(0) > 1) ? 1 : 0;
        }    
        if(h.containsKey(sum/2))
            return 1;
        return 0;    
          
    }
}
