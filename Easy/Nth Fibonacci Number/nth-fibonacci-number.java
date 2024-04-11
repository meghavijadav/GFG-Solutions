//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
        // if (n <= 1)
        //     return n;
        
        // int prev = 0;
        // int current = 1;
        
        // for (int i = 2; i <= n; i++) {
        //     int next = prev + current;
        //     prev = current;
        //     current = next;
        // }
        
        // return prev;
        //here the test cases are failing
        
        
        // if (n <= 1)
        //     return n;
        // return nthFibonacci(n - 1) + nthFibonacci(n - 2);
        //here the time limit is exceeding
        
         int a = 0;
        int b = 1;
        int c = 0;
        
        if (n == 0 || n == 1)
            return n;
        
        for (int i = 2; i <= n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        
        return c % 1000000007;
        
        //1000000007 is a convenient prime number modulo that balances these considerations well. 
        //It's not too small to cause collisions easily and not too large to cause overflow issues with 
        //typical integer types used in programming.
    }
}