//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        //Make a loop of r 
        //in each loop replace 0 by 01 and 1 by 10 by using replace
        //now you do this for r times
        //and find the number on nth index
        
        // for (int i = 0; i < r; i++){
        //     s = s.replaceAll("0", "01").replaceAll("1", "10"); 
        // }
        // return s.charAt(n);
        //This solution is exceeding time limit
        
        String str = "";
        for (int i = 0; i < r; i++) {
            
            for (int j = 0; j < n+1; j++) {
                
                if (s.charAt(j) == '1') {
                    str += "10";
                } 
                else {
                    str += "01";
                }
            } 
            s = str;
            
            if (i + 1 != r) {
                str = "";
            }
        }
        return str.charAt(n);
    }
}