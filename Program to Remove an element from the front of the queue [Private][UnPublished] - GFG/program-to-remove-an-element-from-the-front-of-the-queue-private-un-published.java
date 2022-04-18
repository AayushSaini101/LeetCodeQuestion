// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class Solution{
    
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        
        while(t-->0){
            
            int n=scan.nextInt();
            
            
            Queue<Integer>Q=new LinkedList<>();
            
            for(int i=0;i<n;++i){
                
                Q.add(scan.nextInt());
            }
            
            GFG ob=new GFG();
            
            ob.removefrontElement(Q);
            
            while(Q.size()!=0){
            
            System.out.print(Q.remove()+" ");
        }
        
        System.out.println();
            
            
        }
    }
}// } Driver Code Ends


//User function Template for Java

class GFG{
    void removefrontElement(Queue<Integer>Q){
        int first=0;
        Stack<Integer>St=new Stack<>();
          while(Q.size()!=0){
            if(first==0){
                ++first;
                Q.remove();
                continue;
            }  
            St.add(Q.remove());
        }
       
      //REverse teh stack 
      Stack<Integer>rev=new Stack<>();
      
      while(St.size()!=0){
          rev.add(St.pop());
      }
        
        while(rev.size()!=0){
        
            Q.add(rev.pop());
        }
        
    }
}