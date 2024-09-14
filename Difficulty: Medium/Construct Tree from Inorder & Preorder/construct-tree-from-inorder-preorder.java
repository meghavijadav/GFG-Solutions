//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }
        
        Node root = buildTree(preorder, 0 , n-1, inorder, 0, n-1, map);
        
        return root;
    }
    
    public static Node buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map){
        if(pStart > pEnd || iStart > iEnd){
            return null;
        }
        
        Node root = new Node(preorder[pStart]);
        
        int iRoot = map.get(root.data);
        int numsLeft = iRoot - iStart;
        
        root.left = buildTree(preorder, pStart + 1, pStart + numsLeft, inorder, iStart, iRoot -1 , map);
        root.right = buildTree(preorder, pStart + numsLeft + 1, pEnd, inorder, iRoot + 1, iEnd, map);
        
        return root;
    }
}
