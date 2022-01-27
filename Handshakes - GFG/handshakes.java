// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int catalannumber(int n){
        if(n<=1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<n;++i){
            ans+=catalannumber(i)*catalannumber(n-i-1);
        }
        return ans;
    }
    static int count(int N) 
    { 
        // code here
        //1 1 2 
        return catalannumber(N/2);
    }
};