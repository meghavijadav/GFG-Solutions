//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int N){
        //code here
        // int dp[] = new int[N+1];
        // arr[0] = 1;
        // for(int i = 1; i <= N; i++){
        //     if(i == 1){
        //         arr[i] = dp[i-1] + 0;
        //     }
        // }
        
        int dp[] = new int[N];
        Arrays.fill(dp, -1);
        return rec(N-1, arr, dp);
    }
    
    public static int rec(int idx, int arr[], int[] dp){
        //This solution is using Memoization
        //DP solution
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        if(idx == 0){
            return 0;
        }
        
        int left = rec(idx-1, arr, dp) + Math.abs(arr[idx] - arr[idx-1]);
        int right = Integer.MAX_VALUE;
        if(idx > 1){
            right = rec(idx-2, arr, dp) + Math.abs(arr[idx] - arr[idx -2]);
        }
        
        return dp[idx] = Math.min(left, right);
    }
}