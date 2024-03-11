//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        //start a counter
        //Start the loop to go through every number one by one
        // mat 1= {{1, 5, 6},
        // {8, 10, 11},
        // {15, 16, 18}}
        // mat2 = {{2, 4, 7},
        // {9, 10, 12},
        // {13, 16, 20}}
        //so do 21-1 = 20 now check for 20 in second matrix 
        //then increment the counter
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = x - mat1[i][j];
                int row = n - 1;
                int col = 0;
                
                // Traverse mat2 which is sorted
                while (row >= 0 && col < n) {
                    if (mat2[row][col] == target) {
                        count++;
                        break;
                    } else if (mat2[row][col] > target) {
                        row--;
                    } else {
                        col++;
                    }
                }    
            }
        } 
        return count;
    }
}