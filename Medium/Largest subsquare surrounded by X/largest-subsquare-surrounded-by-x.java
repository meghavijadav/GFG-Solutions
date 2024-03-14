//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            char A[][] = new char[N][N];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) A[i][j] = S[j].charAt(0);
            }
            Solution ob = new Solution();
            System.out.println(ob.largestSubsquare(N, A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int largestSubsquare(int n, char a[][]) {
        //Approach
        // Initialize arrays to store the lengths of continuous 'X's from the top and left directions
        // create Array to store lengths from top
        // create Array to store lengths from left
        // make counter Variable to store the maximum subsquare length
        // Iterate through the grid using two loops
        // If the current cell contains 'X'
        // Calculate the length of 'X's from the top
        // Increment the length from the top if not in the first row
        // Set length to 1 if in the first row
        // Calculate the length of 'X's from the left
        // Increment the length from the left if not in the first column
        // Set length to 1 if in the first column
        // Check for the largest subsquare starting at current position
        // Check if the subsquare can be formed from the current position
        // Update maximum subsquare length if found
        // Exit the loop as the largest subsquare is found
        //return the value of the counter
        
        int[][] top = new int[n][n];
        int[][] left = new int[n][n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'X') {
                    if (i > 0) {
                        top[i][j] = top[i - 1][j] + 1;
                    } else {
                        top[i][j] = 1;
                    }
                    if (j > 0) {
                        left[i][j] = left[i][j - 1] + 1;
                    } else {
                        left[i][j] = 1;
                    }
                    for (int k = Math.min(top[i][j], left[i][j]); k > count; k--) {
                        if (top[i][j - k + 1] >= k && left[i - k + 1][j] >= k) {
                            count = Math.max(count, k);
                            break;
                        }
                    }
                }
            }
        }
        
        return count;
    }
};