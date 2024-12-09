//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            int h[] = new int[2];
            h[0] = sc.nextInt();
            h[1] = sc.nextInt();
            Solution obj = new Solution();
            ArrayList<int[]> ans = obj.insertInterval(a, h);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[");
                System.out.print(ans.get(i)[0] + "," + ans.get(i)[1]);
                System.out.print("]");
                if (i != ans.size() - 1) System.out.print(",");
            }
            System.out.println("]");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        ArrayList<int[]>  ans = new ArrayList<>();
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)-> a[0]-b[0]); 
         
         
         for(int[] interval : intervals){
             pq.offer(interval);
            }
         pq.offer(newInterval);
         
         int[] curr= pq.poll();
         
         while(!pq.isEmpty()){
             
             int [] next =pq.poll();
             
             if(curr[1]>=next[0]){
                 curr[1] =Math.max(curr[1],next[1]);
             }
             else{
                 ans.add(curr);
                 curr= next;
             }
         }
         
         ans.add(curr);
         return ans ;
    }
}
