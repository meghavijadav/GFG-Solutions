//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        long maxArea = 0;
        long[] nsr = new long[(int)n];
        long[] nsl = new long[(int)n];
        Stack<Long> s = new Stack<>();
        
        for(long i = n-1; i >= 0; i--){
            while(!s.isEmpty() && hist[s.peek().intValue()] >= hist[(int)i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[(int)i] = n;
            }else{
                nsr[(int)i] = s.peek();
            }
            s.push(i);
        }
        
        s = new Stack<>();
        
        for(long i = 0; i < n; i++){
            while(!s.isEmpty() && hist[s.peek().intValue()] >= hist[(int)i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[(int)i] = -1;
            }else{
                nsl[(int)i] = s.peek();
            }
            s.push(i);
        }
        for(long i = 0; i < n; i++){
            long height = hist[(int)i];
            long width = nsr[(int)i] - nsl[(int)i] -1;
            long currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }
        
}



