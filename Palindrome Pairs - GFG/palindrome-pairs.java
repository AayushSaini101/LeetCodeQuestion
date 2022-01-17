// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = new String[N];
            
            for(int i=0; i<N; i++)
                arr[i] = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.palindromepair(N,arr));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean check(String str){
       
        StringBuffer tempStr=new StringBuffer(str);
        tempStr.reverse();
        if(str.equals(tempStr.toString())){
          
         
            return true;
        }
        return false;
    }
    static int palindromepair(int N, String arr[]) {
        // code here
        //Let's start t
        int count=0;
        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);
        for(int i=0;i<arr.length;++i){
            for(int j=i+1;j<arr.length;++j){
                if(check(new StringBuffer(arr[i]).append(arr[j]).toString())||check(new StringBuffer(arr[j]).append(arr[i]).toString())){
                  return 1;
                }
            }
        }
        return count;
    }
};