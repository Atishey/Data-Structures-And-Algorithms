/*
Given an array of array of integers A of size N x 2 denoting time intervals of different meetings. Where: A[i][0] = start time of the ith meeting. A[i][1] = end time of the ith meeting. find the minimum number of conference rooms required so that all meetings can be done. 
Input Format
The only argument given is the matrix A.
Output Format
Return the minimum number of conference rooms required so that all meetings can be done.
Constraints
1 <= N <= 100000
0 <= A[i][0] < A[i][1] <= 2 * 10^9
For Example
Input 1:
    A = [   [0, 30]
            [5, 10]
            [15, 20] ]    
Output 1:
    2
    Meeting one can be done in conference room 1 form 0 - 30.
    Meeting two can be done in conference room 2 form 5 - 10.
    Meeting one can be done in conference room 2 form 15 - 20 as it is free in this interval.

Input 2:
   A =  [   [1, 18]
            [18, 23]
            [15, 29]
            [4, 15]
            [2, 11]
            [5, 13] ]
Output 2:
    4
    Meeting one can be done in conference room 1 from 1 - 18.
    Meeting five can be done in conference room 2 from 2 - 11.
    Meeting four can be done in conference room 3 from 4 - 15.
    Meeting six can be done in conference room 4 from 5 - 13.
    Meeting three can be done in conference room 2 from 15 - 29 as it is free in this interval.
    Meeting two can be done in conference room 4 from 18 - 23 as it is free in this interval.
*/
public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> al) {
        al.sort((o1,o2)->{return o1.get(0)-o2.get(0);});
        Queue<Integer> q = new PriorityQueue<>();
        q.add(al.get(0).get(1));
        int rooms = 1;
        for(int i=1;i<al.size();i++){
            int startTime = al.get(i).get(0);
            int endTime = al.get(i).get(1);
            if(q.size() >0 && startTime < q.peek())
                rooms++;
            else
                q.poll();
            q.add(endTime);    
        }
        return rooms;
    }
}
