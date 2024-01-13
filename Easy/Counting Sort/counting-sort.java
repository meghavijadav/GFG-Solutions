//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            String arr = "";
            arr = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.countSort(arr));
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    public static String countSort(String arr)
    {
        //Approach
        //You are given a Number N 
        //You need to select the first N letters from the array arr ir till index N-1
        //Then you need to sort the selected first N letters

        int n = arr.length();
        char[] output = new char[n];
        int[] count = new int[26]; // Assuming only lowercase English letters are present

        // Count occurrences of each character
        for (int i = 0; i < n; i++) {
            count[arr.charAt(i) - 'a']++;
        }

        // Modify the count array to store the position of each character in the output array
        for (int i = 1; i < 26; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr.charAt(i) - 'a'] - 1] = arr.charAt(i);
            count[arr.charAt(i) - 'a']--;
        }

        // Convert the char array to a string
        return new String(output);
    }
    
}