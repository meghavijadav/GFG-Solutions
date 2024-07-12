//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
            //Scanner sc = new Scanner(System.in);
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
        	    String X = br.readLine();
        	    String arr[] = X.split(" ");
        	    int x , y;
			    x = Integer.parseInt(arr[0]);
			    y = Integer.parseInt(arr[1]);
			    ArrayList<Integer> res = new ArrayList<Integer>();
			    res = g.printNearNodes(root,x,y);
			    for(int i = 0;i<res.size();i++)
			        System.out.print(res.get(i) + " " );
			    System.out.println();
                t--;
            
        }
    }
  
}


// } Driver Code Endshttps://media.geeksforgeeks.org/img-practice/FabIconlong-desktop-1720176804.svg


//User function Template for Java

class Solution
{   
    //Function to return a list of BST elements in a given range.https://media.geeksforgeeks.org/img-practice/FabIconlong-desktop-1720176804.svg
	public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
        ArrayList<Integer> ans = new ArrayList<>();
        print(root, low, high, ans);
        return ans;
        
    }
    
    public static void print(Node root,int low,int high, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        
        if(root.data > low){
            print(root.left, low, high, ans);
        }
        
        if(root.data >= low && root.data <= high){
            // print(root.left, low, high, ans);
            ans.add(root.data);
            // print(root.right, low, high, ans);
        }
        
        if(root.data < high){
            print(root.right, low, high, ans);
        }
    }
}