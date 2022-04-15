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
            
            int x=scan.nextInt();
            
            
            Queue<Integer>Q=new LinkedList<>();
            
            for(int i=0;i<n;++i){
                
                Q.add(scan.nextInt());
            }
            
            GFG ob=new GFG();
            
            ob.addElement(Q,x);
            
            while(Q.size()!=0){
            
            System.out.print(Q.remove()+" ");
        }
        
        System.out.println();
            
            
        }
    }
}// } Driver Code Ends


//User function Template for Java

class GFG{
    
    void addElement(Queue<Integer>Q,int X){
        Q.add(X);
    }
}
