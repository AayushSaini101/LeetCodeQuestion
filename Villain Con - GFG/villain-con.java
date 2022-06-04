// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int M = Integer.parseInt(a[1]);
            int mat[][] = new int[M][2];
            for(int i = 0;i < M;i++){
                String a1[] = in.readLine().trim().split("\\s+");
                mat[i][0] = Integer.parseInt(a1[0]);
                mat[i][1] = Integer.parseInt(a1[1]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.minColour(N, M, mat));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minColour(int N, int M, int mat[][]) {
        // code here
        List<List<Integer>>lst=new ArrayList<>();
        
        int indegree[]=new int[N+1];
        
        for(int i=0;i<=N+1;++i){
            
            lst.add(new ArrayList<>());
        }
        
        for(int i=0;i<mat.length;++i){
            
            lst.get(mat[i][0]).add(mat[i][1]);
            
            indegree[mat[i][1]]++;
        }
        
        int count=0;
        
        Queue<Integer>Q=new LinkedList<>();
        
        for(int i=1;i<=N;++i){
            
            if(indegree[i]==0){
                
                Q.add(i);
            }
        }
        
        
        
        while(Q.size()!=0){
            
            int size=Q.size();
            
            for(int i=0;i<size;++i){
                
                int remove=Q.remove();
                
                for(int elements:lst.get(remove)){
                    
                    //decreasing the indegree
                    
                    indegree[elements]--;
                    
                    if(indegree[elements]==0){
                        
                        
                        
                        Q.add(elements);
                    }
                }
               
            }
             ++count;
        }
        
        return count;
        
    
        
        
    }
}