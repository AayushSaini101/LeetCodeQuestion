// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int keys[]= new int[n];
            for(int i = 0; i < n; i++)
                keys[i] = Integer.parseInt(input_line[i]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int freq[]= new int[n];
            for(int i = 0; i < n; i++)
                freq[i] = Integer.parseInt(input_line1[i]);
            Solution ob = new Solution();
            System.out.println(ob.optimalSearchTree(keys, freq, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int optimalSearchTree(int key[], int freq[], int n)
   {
       int store[][][]=new int [n][n][n+1];
       for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
             for(int k=0;k<=n;k++)
               store[i][j][k]=-1;
         }
     }
  return dp(0,n-1,1,key,freq,store);
   }
   
   public static  int dp(int i,int j,int level,int key[],int freq[],int store[][][]){
    if(i==j){
        store[i][j][level]=freq[i]*level;
        return(store[i][j][level]);
    }
    if(i>j)
      return(0);
    
    if(store[i][j][level]!=-1)
     return(store[i][j][level]);
    
    int min=Integer.MAX_VALUE;
    for(int r=i;r<=j;r++){
        int v1=dp(i,r-1,level+1,key,freq,store);
        int v2=dp(r+1,j,level+1,key,freq,store);
        int v3=freq[r]*level;
        int total=v1+v2+v3;
        min=Math.min(total,min);
    }
    store[i][j][level]=min;
    return(min);
}
}
