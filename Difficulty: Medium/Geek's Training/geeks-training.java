//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][], int N) {
        // code here
        //This is a Tabulation code for this question
        
        int dp[][] = new int[N][4];
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][1], arr[0][0]);
        dp[0][3] = Math.max(arr[0][1], Math.max(arr[0][2], arr[0][1]));
        
        for(int day = 1; day < N; day++){
            for(int last = 0; last < 4; last++){
                dp[day][last] = 0;
                
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        int points = arr[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], points);
                    }
                }
            }
        }
        
        return dp[N-1][3];
    }
}