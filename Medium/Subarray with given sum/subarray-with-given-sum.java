//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // int left = 0, right = 0;
        // int currentSum = 0;

        // while (right < n) {
        //     currentSum += arr[right];

        //     while (currentSum > s) {
        //         currentSum -= arr[left];
        //         left++;
        //     }

        //     if (currentSum == s) {
        //         // Adding 1 to convert from 0-based indexing to 1-based indexing
        //         return new ArrayList<>(List.of(left + 1, right + 1));
        //     }

        //     right++;
        // }

        // // If no subarray is found
        // return new ArrayList<>(List.of(-1));
        
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;
        int left = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            while(sum > s && i > left && left < n){
                sum -= arr[left];
                left++;
            }
            if(s == sum){
            ans.add(left+1);
            ans.add(i+1);
            break;
            }
        }
        if(s != sum){
            ans.add(-1);
        }
        
        
        return ans;
    }
}