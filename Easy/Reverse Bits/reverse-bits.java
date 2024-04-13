//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static Long reversedBits(Long x) {
        String b = Long.toBinaryString(x);
        StringBuilder sb = new StringBuilder(b);
        sb.reverse();
        while (sb.length() < 32) {
            sb.append('0');
        }
        String paddedBinary = sb.toString();
        return Long.parseLong(paddedBinary, 2);
    }
};