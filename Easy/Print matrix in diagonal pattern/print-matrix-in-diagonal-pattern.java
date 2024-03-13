//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int[] ans = new int[n * n];
        int k = 0;
        int i = 0, j = 0;
        while (i < n && i >= 0 && j >= 0 && j < n) {
            while (i >= 0 && j < n) {
                ans[k] = mat[i][j];
                i--;
                j++;
                k++;
            }
            if (j == n) {
                i += 2;
                j--;
            } else {
                i = 0;
            }
            while (i < n && j >= 0) {
                ans[k] = mat[i][j];
                i++;
                j--;
                k++;
            }
            if (i == n) {
                j += 2;
                i--;
            } else {
                j = 0;
            }
        }
        return ans;
        
    }
}