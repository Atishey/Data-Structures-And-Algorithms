/*
Ath largest element
Problem Description
Given an integer array B of size N. You need to find the Ath largest element in the subarray [1 to i] where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N]. NOTE: If any subarray [1 : i] has less than A elements then output array should be -1 at the ith index.   


Problem Constraints
1 <= N <= 100000
1 <= A <= N
1 <= B[i] <= INT_MAX


Input Format
First argument is an integer A.
Second argument is an integer array B of size N.


Output Format
Return an integer array C, where C[i] (1 <= i <= N) will have the Ath largest element in the subarray [1 : i].


Example Input
Input 1:
 A = 4  
 B = [1 2 3 4 5 6] 
Input 2:
 A = 2
 B = [15, 20, 99, 1]
  


Example Output
Output 1:
 [-1, -1, -1, 1, 2, 3]
Output 2:
 [-1, 15, 20, 20]
*/


public class Solution {
    PriorityQueue<Integer> pq;
    public int[] solve(int k, int[] a) {
        pq = new PriorityQueue<>();
        int n = a.length;
        int ans[] = new int[n];
        for(int i=0;i<k;i++){
            pq.add(a[i]);
            if(i == k-1)
                ans[i] = pq.peek();
            else    
                ans[i] = -1;
        }
        /*
        Since we already have k size heap so for kth largest element we will add the current element that would 
        be (k-1)th largest element so we will remove it
        */
        for(int i=k;i<n;i++){
            pq.add(a[i]);
            pq.poll();
            ans[i] = pq.peek();
        }
        return ans;
    }
}
