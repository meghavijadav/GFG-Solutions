//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int i = 1; 
        int j = arr.length;
        int dp[][] = new int[N][N];
        for(int a = 0; a < N; a++){
            Arrays.fill(dp[a], -1);
        }
        return mcmMem(arr, 1, N-1, dp);
    }
    
    public static int mcmMem(int arr[], int i, int j, int[][] dp){
        if(i == j){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int cost1= mcmMem(arr, i, k, dp);
            int cost2 = mcmMem(arr, k+1, j, dp);
            int cost3 = arr[i-1]* arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return dp[i][j] = ans;
    }
}