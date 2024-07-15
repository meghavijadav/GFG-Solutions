//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
        }
    }
    
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        Node root = createBST(nums, 0, nums.length -1);
        int arr[] = new int[nums.length];
        preorder(root, arr, new int[]{0});
        return arr;
        
    }
    
    public static Node createBST(int[] arr, int start, int end){
        if(start > end){
            return null;
        }
        
        int mid = (start + end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, start, mid -1);
        root.right = createBST(arr, mid + 1, end);
        return root;
    }
    
    public static void preorder(Node root, int[] nums, int[] index){
        if(root == null){
            return;
        }
        
        nums[index[0]++] = root.data;
        preorder(root.left, nums, index);
        preorder(root.right, nums, index);
    }
}