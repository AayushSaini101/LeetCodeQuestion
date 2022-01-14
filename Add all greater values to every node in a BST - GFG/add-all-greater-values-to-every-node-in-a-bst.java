// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            root = T.modify(root);
            inorder(root);
            System.out.println();
            t--;
        }
    }
    
    static void inorder(Node root)
    {
        if(root==null)  return;
    
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    public void inorder(Node root,List<Integer>lst){
        if(root==null){
            return;
        }
        //Move to left part 
        inorder(root.left,lst);
        //
        lst.add(root.data);
        
        inorder(root.right,lst);
    }
    public int index=0;
    public void modify(Node root,int suffix[],int count){
        if(root==null){
            return;
        }
        modify(root.left,suffix,count);
        if(index<suffix.length)
        root.data=suffix[index++];
        modify(root.right,suffix,count);
        
    }
    // modify the BST and return its root
    public Node modify(Node root)
    {
        //Write your code here
        //We can usse the p
        //1 2 4 5 7
        //1 3 7 12 19
        List<Integer>lst=new ArrayList<>();
        
        inorder(root,lst);
        
       int suffix[]=new int[lst.size()];
       
       for(int i=suffix.length-1;i>=0;--i){
           
           if(i==suffix.length-1){
               suffix[i]=lst.get(i);
           }
           else{
               suffix[i]=lst.get(i)+suffix[i+1];
           }
       }
     
      
       //Now update the list 
       modify(root,suffix,0);
      
        index=0;
     return root;
       
        
        
    }
    
}
