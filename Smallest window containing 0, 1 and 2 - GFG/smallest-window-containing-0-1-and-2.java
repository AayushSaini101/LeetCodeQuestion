// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        //Smallest substring containing zero and one 
        int dp[]=new int[3];
        Arrays.fill(dp,-1);
        int answer=Integer.MAX_VALUE;
        for(int i=0;i<S.length();++i){
             dp[S.charAt(i)-48]=i;
             
             int min=Integer.MAX_VALUE;
             
             int flag=0;
             
             for(int j=0;j<3;++j){
                 if(j!=S.charAt(i)-48){
                    if(dp[j]==-1){
                        flag=1;
                        break;
                    }
                    else{
                        min=Math.min(min,dp[j]);
                    }
                     
                 }
             }
             if(flag==0)
             answer=Math.min(answer,i-min+1);
             
        }
        if(answer==Integer.MAX_VALUE)return -1;
        return answer;
    }
};
