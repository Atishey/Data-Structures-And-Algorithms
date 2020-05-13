/*
Job Sequencing
Given two integer arrays A and B of size N.
There are N jobs every job has a deadline and associated profit if the job is finished before the deadline.
A[i] denotes the deadline of the ith job and B[i] denotes the associated profit with ith job.
Every job takes single unit of time, so the minimum possible deadline for any job is 1.
Your task is to schedule jobs such that maximum profit is achieved if only one job can be scheduled at a time.
*/
public class Solution {
    class Pair implements Comparable{
        int profit;
        int time;
        Pair(int time,int profit){
            this.profit = profit;
            this.time = time;
        }
        
        public int compareTo(Object ob){
            return -Integer.compare(this.profit,((Pair)ob).profit);
        }
    }
    public int solve(int[] time, int[] profit) {
        int n = time.length;
        HashSet<Integer> slot = new HashSet<>();
        Pair p[] = new Pair[n];
        int max_time = 0;
        for(int i=0;i<n;i++){
            p[i] = new Pair(time[i],profit[i]);
            max_time = Math.max(time[i],max_time);
        }
        
        Arrays.sort(p);
        // Arrays.sort(time);
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=p[i].time-1;j>=0;j--){
                if(!slot.contains(j)){
                    ans+=p[i].profit;
                    slot.add(j); 
                    break;
                }
            }
            
        }
        return ans;
    }
}


/*
Better solution using disjoint set algorithm.
Just keep parent of a given deadline to the latest slot available
*/

public class Solution {
    int parent[];
    class Job implements Comparable{
        int time;
        int profit;
        Job(int time,int profit){
            this.time= time;
            this.profit = profit;
        }
        
        public int compareTo(Object j){
            return -Integer.compare(this.profit,((Job)j).profit);
        }
    } 
    
    public int find(int t){
        int temp = t;
        while(temp != parent[temp])
            temp = parent[temp];
        return temp;    
    }
    
    public void union(int u,int v){
        parent[u] = v;
    }
    
    public int solve(int[] time, int[] profit) {
        int n = time.length;
        int max_time = 0;
        Job jobs[] = new Job[n];
        for(int i=0;i<n;i++){
            max_time = Math.max(time[i],max_time);
            jobs[i] = new Job(time[i],profit[i]);
        }
        parent = new int[max_time+1];
        Arrays.sort(jobs);
        for(int i=0;i<=max_time;i++){
            parent[i] = i;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int slot = find(jobs[i].time);
            if(slot >= 1){
                union(slot,slot-1);
                ans += jobs[i].profit;
            }    
        }
        return ans;
        
    }
}

