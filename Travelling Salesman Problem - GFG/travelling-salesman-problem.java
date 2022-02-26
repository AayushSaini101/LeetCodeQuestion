// { Driver Code Starts
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
            int[][] cost = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    cost[i][j] = Integer.parseInt(S[j]);
            }
            Solution obj = new Solution();
            int ans = obj.total_cost(cost);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long cost(int [][] cost,int index,int mask,int wantMask){
        
        //This is connected graph  
        if(mask==wantMask){
            
            return cost[index][0];
        }
        long min=Long.MAX_VALUE;
         mask=mask|(1<<index);
         
        for(int i=0;i<cost[0].length;++i){
            
            if(cost[index][i]!=0&&(mask&(1<<i))==0){
                //we can jump
                // System.out.println("Checking the value");
                 mask=mask|(1<<i);
                
                 min=Math.min(cost[index][i]+cost(cost,i,mask,wantMask),min);
               
                 mask^=(1<<i);
                
                
                
                
            }
        }
         mask=mask^(1<<index);
       
        
        return min;
    }
    public int total_cost(int[][] cost)
    {
        // Code here 
        //Starting from the node 
        if(cost.length==1){
            return cost[0][0];
        }
        int mask=0;
        
        int wantMask=(1<<cost.length)-1;
        
        
        return (int)cost(cost,0,0,wantMask);
        
        
        
        
    
    }
}