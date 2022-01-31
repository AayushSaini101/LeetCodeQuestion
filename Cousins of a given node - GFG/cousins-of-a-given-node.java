// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} class GfG {
    public static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    
    public static Node point(Node root, int n)
    {
        if(root == null)
            return null;
            
        if(root.data == n)
            return root;
            
        Node l = point(root.left, n);
        if(l!=null && l.data==n)
            return l;
            
        Node r= point(root.right, n);
        return r;
        
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            Node root = buildTree(s);
            
            Node p = point(root,n);
            
            Solution ob=new Solution();
            ArrayList<Integer> ans= ob.printCousins(root, p);
            
            for(int i=0;i<ans.size();i++)
            {
                    System.out.print(ans.get(i)+" ");
    
            }
            
            System.out.println();
            
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} */

class Solution
{
    static class Pair{
        Node value;
        Node parent;
        Pair(Node value,Node parent){
            this.value=value;
            this.parent=parent;
        }
        
    }
   
    public static ArrayList<Integer> printCousins(Node root, Node node_to_find)
    {
        //code here
        Queue<Pair>Q=new LinkedList<>();
        Q.add(new Pair(root,root));
        ArrayList<Integer>lst1=new ArrayList<>();
        //Siblings should not printed that means there closet parent shoudl not same
        //
        
        Node parent=null;
        
      
        
        while(Q.size()!=0){
            
            int size=Q.size();
            int check=0;
            
            List<Pair>SameLevel=new ArrayList<>();
            
            for(int i=0;i<size;++i){
                
                Pair remove=Q.remove();
                SameLevel.add(remove);
             
                if(remove.value.data==node_to_find.data){
                   parent=remove.parent;
                   check=1;
                }
                
                if(remove.value.left!=null){
                    Q.add(new Pair(remove.value.left,remove.value));
                }
                if(remove.value.right!=null){
                    Q.add(new Pair(remove.value.right,remove.value));
                }
            }
            //The required node prense in the level
            if(check==1){
                //System.out.println("Hello");
                for(Pair elements:SameLevel){
                  
                  // System.out.println(elements.value.data+" "+elements.parent.data+" "+parent.data);
                    if(elements.parent!=parent){
                     //   System.out.println(elements..data);
                        lst1.add(elements.value.data);
                    }
                }
                break;
            }
        }
       // System.out.println(height);
       if(lst1.size()==0){
           lst1.add(-1);
       }
        return lst1;
    }
}