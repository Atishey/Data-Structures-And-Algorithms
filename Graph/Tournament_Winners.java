//Using dfs considering each knight as source and checking whether we can visit all the other knights or not.
/*
Tournament Winners
There are N knights numbered [1, 2, .., N]. A tournament is organized among these knights. This tournament will have N-1 matches and at every match, the winner stays in and the looser moves out. There are no draws in the match. At the end of the tournament, there is only one knight left- the winner. The spymaster has some information about who would win in a one-to-one match between two players, i.e., for some pairs of knights, he know who would win in a one-to-one match between them. Now he wants to know if a scheduling of matches can help someone to win the tournament. That is for some knight x, whether it is possible to play only the matches where he will win. He wants you to find out that for how many knights, such kind of schedule is possible. Constraints: 1 <= N <= 1000 Input format:
int A: A number N as described above (no. of knights)
vector<vector<int> > B (2-D array of size N*N):  Entry at [i,j] is 1 if knight (i+1) beats knight (j+1). Else it is 0.

Note: 
1. If B[i][j] is 1 then B[j][i] is 0.
2. B[i][i] is 0.
3. There can be cases where B[i][j] and B[j][i] are both 0 (As the spymaster has partial information)

See example below
Output format:
Return a single integer which is number of knights for whom it is surely possible to fix the schedule such that they will win the tournament. 
Example:
Input: 
A = 4
B = [ [0, 1, 1, 0], [ 0, 0, 0, 0],  [0, 0, 0, 1],  [0, 0, 0, 0] ]

Output:
1

Explanation:
Spymaster has the following information: 
1 wins against 2 and 3.
3 wins against 4.

From this information, schedule (1,2) --> (3,4) --> (1,3) will let 1 win the tournament.
(1,2) means a match between 1 and 2.
*/
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
