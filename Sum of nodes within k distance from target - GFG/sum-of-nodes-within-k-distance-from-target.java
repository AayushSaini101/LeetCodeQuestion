// { Driver Code Starts
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
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int target = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            solver x = new solver();
            System.out.println( x.sum_at_distK(root, target, k) );
            t--;
        }
    }
}

// } Driver Code Ends


/*
// node structure:

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

*/

class solver{
    
  static int sum_at_distK(Node root, int target, int k){
        // code here
        
        HashMap<Node,List<Node>>H=new HashMap<>();
        
        Queue<Node>Q=new LinkedList<>();
        
        Q.add(root);
        
        Node tar=null;
        
        while(Q.size()!=0){
            
            int size=Q.size();
            
            for(int i=0;i<size;++i){
                  
                  Node remove=Q.remove();
                  
                  if(remove.data==target){
                      //Storting the refernce  of the target nod e
                      tar=remove;
                      
                  }
                  
                  if(remove.left!=null){
                      
                      H.computeIfAbsent(remove.left,kk->new ArrayList<>()).add(remove);
                      H.computeIfAbsent(remove,kk->new ArrayList<>()).add(remove.left);
                      
                      Q.add(remove.left);
                  }
                  if(remove.right!=null){
                      H.computeIfAbsent(remove.right,kk->new ArrayList<>()).add(remove);
                      H.computeIfAbsent(remove,kk->new ArrayList<>()).add(remove.right);
                      
                      Q.add(remove.right);
                  }
                  
                  
            }
        }
        
        Q.add(tar);
        
        int sum=0;
        
        Set<Node>S=new HashSet<>();
        
        
        while(Q.size()!=0&&k-->=0){
             
             int size=Q.size();
             
             for(int i=0;i<size;++i){
                 
                 Node remove=Q.remove();
                 
                 sum+=remove.data;
                 
                 S.add(remove);
                 
                 for(Node connected:H.get(remove)){
                     
                     if(S.contains(connected)==false){
                         
                         Q.add(connected);
                         
                     }
                 }
                 
             }
        }
       
       return sum;
      
    }
}

