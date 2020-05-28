
    
public int[] preorderTraversal(TreeNode root) {
      int preorder[] = new int[100000];
      int i=0;
      Stack<TreeNode> s = new Stack<>();
      TreeNode temp = root;
      s.push(temp);

      while(!s.isEmpty()){
          temp = s.pop();
          preorder[i++] = temp.val;
          if(temp.right != null)
              s.push(temp.right);
          if(temp.left != null)
              s.push(temp.left);
      }
      int n = i;
      int ans[] = new int[n];
      for(int j=0;j<n;j++)
          ans[j] = preorder[j];
      return ans;    
}
    
