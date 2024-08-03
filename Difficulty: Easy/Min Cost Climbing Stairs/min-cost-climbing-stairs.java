//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost , int N) {
        //Write your code here
        int dp[] = new int[N];
        dp[0] = cost[0];
        
        if(N > 1){
            dp[1] = cost[1];
        }
            
        for(int i = 2; i < N; i++){
            int jump1 = dp[i-1] + cost[i];
            int jump2 = cost[i] + dp[i-2];
            dp[i] = Math.min(jump1, jump2);
            
        }
        int ans = Math.min(dp[N-1], dp[N-2]);
        return ans;
    }
};