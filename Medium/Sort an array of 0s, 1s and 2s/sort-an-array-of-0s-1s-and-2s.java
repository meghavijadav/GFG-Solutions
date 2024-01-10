//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        //Aproach 
        // We could simply count the 0s 1s and 2s and place them in an array but it is not efficient 
        // Later I learnt this question can be solved using an aligorith named Dutch National Flag Algorithm
        //We can take three variables right, mid and left 
        //Where we are considering that everything till the left index is sorted
        //And the next assumption is everything after the right index should be two 
        //you do nothing till the mid is pointing to 1 if you find 0 or 2 you swap
        //0 with left pointer and 2 with right pointer
        //with iterations your array will start to get sorted
        
        int left = 0;
        int mid = 0;
        int right = n-1;
        while(mid <= right){
            if(a[mid] == 0){
                int temp = a[left];
                a[left] = a[mid];
                a[mid] = temp;
                left++;
                mid++;
            }
            else if(a[mid] == 1){
                mid++;
            }
            else{
                int temp = a[right];
                a[right] = a[mid];
                a[mid] = temp;
                right--;
            }
        }
        return;
    }
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends