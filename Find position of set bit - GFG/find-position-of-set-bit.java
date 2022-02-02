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

            Solution ob = new Solution();
            System.out.println(ob.findPosition(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findPosition(int N) {
        if(N==0){
            return -1;
        }
        // code here
        if((N&(N-1))!=0){
            return -1;
        }
        else{
            int lastSetBit=(int)(Math.log(N)/Math.log(2));
            return lastSetBit+1;
            
        }
    }
};