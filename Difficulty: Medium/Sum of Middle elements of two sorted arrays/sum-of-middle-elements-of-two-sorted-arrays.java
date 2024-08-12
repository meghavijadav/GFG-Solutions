//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int n = arr1.length;
        int idx1 = 0, idx2=0;
        int sum = 0; 
        int x = 0;
        int[] arr = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
            
            while(idx1 <=n && idx2 <= n && x <= n)    {
               if(arr1[idx1] <= arr2[idx2])    {
                    arr[x++] = arr1[idx1++];
                }
                else    {
                    arr[x++] = arr2[idx2++];
                }
            }
        }
        
        return arr[n-1]+arr[n];
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends