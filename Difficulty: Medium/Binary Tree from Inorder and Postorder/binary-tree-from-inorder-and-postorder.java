//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(n, inorder, postorder);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/

class GfG {
    // Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int n, int in[], int post[]) {
        // Your code here
        int[] postIndex = new int[]{post.length -1};
        return buildTreeRec(in, post, 0, n-1, postIndex);
    }
    
    Node buildTreeRec(int[] inorder, int[] postorder, int inStart, int inEnd, int[] postIndex){
        if(inStart > inEnd){
            return null;
        }
        
        Node node = new Node(postorder[postIndex[0]--]);
        if(inStart == inEnd){
            return node;
        }
        
        int inIndex = findInIndex(inorder, postorder,inStart, inEnd, node.data);
        node.right = buildTreeRec(inorder, postorder, inIndex + 1, inEnd, postIndex);
        node.left = buildTreeRec(inorder, postorder, inStart, inIndex-1, postIndex);
        return node;
    }
    
    int findInIndex(int[] inorder, int[] postorder, int start, int end, int value){
        for(int i = start; i <= end; i++){
            if(inorder[i] == value){
                return i;
            }
        }
        return -1;
    }
}
