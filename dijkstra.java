public class Solution {
    public class Node implements Comparable{
        int v;
        int dist;
        
        Node(int v,int dist){
            this.v = v;
            this.dist = dist;
        }
        
        public int compareTo(Object ob){
            return Integer.compare(this.dist,((Node)ob).dist);
        }
        
        
    }

    public int[] solve(int a, int[][] b, int c) {
        int dist[] = new int[a];
        boolean vis[] = new boolean[a];
        
        for(int i=0;i<a;i++)
            dist[i] = Integer.MAX_VALUE;
            
        HashMap<Integer,ArrayList<Node>> h = new HashMap<Integer,ArrayList<Node>>();
        for(int i=0;i<b.length;i++){
            if(h.containsKey(b[i][0]))
                h.get(b[i][0]).add(new Node(b[i][1],b[i][2]));
            else{
                ArrayList<Node> al = new ArrayList<Node>();
                al.add(new Node(b[i][1],b[i][2]));
                h.put(b[i][0],al);
            }
            if(h.containsKey(b[i][1]))
                h.get(b[i][1]).add(new Node(b[i][0],b[i][2]));
            else{
                ArrayList<Node> al = new ArrayList<Node>();
                al.add(new Node(b[i][0],b[i][2]));
                h.put(b[i][1],al);
            } 
        }
        
        PriorityQueue<Node> p = new PriorityQueue<Node>();
        dist[c] = 0;
        p.add(new Node(c,dist[c]));
        while(!p.isEmpty()){
            Node temp = p.poll();
            if(vis[temp.v])
                continue;
            dist[temp.v] = temp.dist;
            vis[temp.v] = true;
            if(h.containsKey(temp.v)){
                ArrayList<Node> adj = h.get(temp.v);
                for(Node n: adj){
                    if(!vis[n.v] && dist[n.v] > dist[temp.v] + n.dist){
                        dist[n.v] = dist[temp.v] + n.dist;
                        p.add(new Node(n.v,dist[n.v]));
                    }
                }
            }
        }
        
        for(int i=0;i<a;i++)
            dist[i] = (dist[i] == Integer.MAX_VALUE) ? -1: dist[i];
        return dist;
        
    }
}
