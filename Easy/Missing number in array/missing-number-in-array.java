//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(array, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int missingNumber(int array[], int n) {
        //Aproach
        //First sort the array 
        //Then initiate a loop where if the number is not equal to index + 1 then it is missing
        
        //  Arrays.sort(array); // Sort the array

        // int missingCount = 0;
        // for (int i = 0; i < n - 1; i++) {
        //     if (array[i] != i + 1) {
        //         missingCount++; // Count the number of missing elements
        //     }
        // }

        // int[] missingNumbers = new int[missingCount];
        // int index = 0;
        // for (int i = 0; i < n - 1; i++) {
        //     if (array[i] != i + 1) {
        //         missingNumbers[index] = i + 1; // Store the missing numbers in the array
        //         index++;
        //     }
        // }

        // return Arrays.copyOf(missingNumbers, missingCount);
        
        Arrays.sort(array);
        int x=1;
        for(int i =0;i<array.length;i++){
            if(array[i]!=x){
                return x;
            }
            x++;
        }
        return n;
    }
}