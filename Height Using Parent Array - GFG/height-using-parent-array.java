// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.findHeight(N, arr));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int height(int arr[],int root,int dp[]){
      
        int max=1;
        for(int i=0;i<arr.length;++i){
            if(arr[i]==root){
              if(dp[i]!=-1){
                  return dp[i];
              }
              int connected=1+height(arr,i,dp);
              
              max=Math.max(connected,max);
              dp[i]=max;
             // System.out.println(max+" "+connected+" "+i);
            }
        }
   
        return max;
    }
    static int findHeight(int N, int arr[]){
         int h=1,i=-1;
        int ele=arr[arr.length-1];
        while(ele!=-1){
            i=ele;
            h++;
            ele=arr[i];
        }
        return h;
    }
}