//Check if given Preorder, Inorder and Postorder traversals are of same tree
public class Solution {
    int n,index;
    HashMap<Integer,Integer> h;
    int pre[],in[],post[],ans[];
    class TreeNode{
        int data;
        TreeNode left,right;
        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
  
    TreeNode buildTree(int start,int end){
        if(start > end || index >= n)
            return null;
        TreeNode t = new TreeNode(pre[index]);
        int inIndex = h.get(pre[index++]);
        if(start == end)
            return t;

        t.left = buildTree(start,inIndex-1);
        t.right = buildTree(inIndex+1,end);
        return t;
    }
    
    
    public void postOrderTraversal(TreeNode t){
        
        if(index >= n || t == null)
            return;
        postOrderTraversal(t.left);
        postOrderTraversal(t.right);
        ans[index++] = t.data;
    }    

    public int solve(int[] a, int[] b, int[] c) {
        pre = a;
        in = b;
        post = c;
        index = 0;
        n = in.length;
        ans = new int[n];
        
        h = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
            h.put(in[i],i);
        TreeNode t = buildTree(0,n-1);
        index = 0;
        
        postOrderTraversal(t);
            
        for(int i=0;i<n;i++)
            if(post[i] != ans[i])
                return 0;
            
        
        return 1;
        

    }
}
