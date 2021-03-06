//Problem - Knight On Chess Board
public class Solution {
    class Pair{
        int x;
        int y;
        int dist;
        Pair(int x,int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public boolean isSafe(int x,int y,int a,int b){
        if(x > a || x <= 0 || y > b || y <= 0)
            return false;
        return true;    
    }
    public int knight(int a, int b, int c, int d, int e, int f) {
        Pair src = new Pair(c,d,0);
        // Pair dest = new Pair(e,f);
        boolean vis[][] = new boolean[a+1][b+1];
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(src);
        vis[c][d] = true;
        int dx[] = {-2,-2,2,2,-1,-1,1,1};
        int dy[] = {-1,1,-1,1,2,-2,2,-2};
        while(!q.isEmpty()){
            Pair temp = q.poll();
            // System.out.println("x>>> "+temp.x+" y>>> "+temp.y+" dist>>> "+temp.dist);
            int x = -1,y = -1;
            if(temp.x == e && temp.y == f)
                return temp.dist;
            for(int i=0;i<dx.length;i++){
                x = temp.x + dx[i];
                y = temp.y + dy[i];
                if(isSafe(x,y,a,b) && !vis[x][y]){
                    q.add(new Pair(x,y,temp.dist+1));
                    vis[x][y] = true;
                }
            }    
                
        }
        return -1;
        
    }
}
