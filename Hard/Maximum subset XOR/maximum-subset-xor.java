//{ Driver Code Starts
import java.util.*;

import java.io.*;
class XOR
{	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0)
		{
		  int n = Integer.parseInt(br.readLine().trim());
		  String s[] = br.readLine().trim().split(" ");
		  int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i]=Integer.parseInt(s[i]);
		  Solution g = new Solution();
		  System.out.println(g.maxSubsetXOR(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    public static int maxSubsetXOR(int arr[], int n)
    {
        //add code here.
        int index = 0;
        int INT_BITS = 32;
        
        for(int i = INT_BITS -1; i >= 0; i--){
            int maxInd = index;
            int maxEle = Integer.MIN_VALUE;
            for(int j = index; j < n; j++){
                if((arr[j] & (1 << i)) !=0 && arr[j] > maxEle){
                    maxEle = arr[j];
                    maxInd = j;
                }
            }
            
            if(maxEle == -2147483648){
                continue;
            }
            
            int temp = arr[index];
            arr[index] = arr[maxInd];
            arr[maxInd] = temp;
            
            maxInd = index;
            
            for(int j = 0; j < n; j++){
                if(j != maxInd && (arr[j] & (1 << i)) !=0){
                    arr[j] = arr[j] ^ arr[maxInd];
                }
            }
            index++;
        }
        
        int res = 0;
        for(int i = 0; i < n; i++){
            res ^= arr[i];
        }
        return res;
    }
}