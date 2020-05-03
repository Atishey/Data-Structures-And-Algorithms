//Using dfs considering each knight as source and checking whether we can visit all the other knights or not.
public class Solution {
    int matrix[][];
    boolean vis[];
    int count,n,ans = 0;
    
    public void dfs(int i){
        if(count == n){
            ans++;
            return;
        }    
        for(int j=0;j<n;j++){
            if(j != i && matrix[i][j] == 1 && !vis[j]){
                vis[j] = true;
                count++;
                dfs(j);
            }
        }
    }
    
    public int solve(int num, int[][] mat) {
        n = num;
        matrix = mat;
        for(int i=0;i<n;i++){
            vis = new boolean[n+1];
            vis[i] = true;
            count = 1;
            dfs(i);
        }
        return ans;
    }
    
}
