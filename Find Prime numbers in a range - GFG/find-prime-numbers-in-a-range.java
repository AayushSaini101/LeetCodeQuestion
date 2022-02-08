// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.primeRange(M, N);
            for (int i : ans) System.out.print(i + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean prime(int n){
        if(n==1){
            return false;
        }
        if(n==2||n==3||n==5){
            return true;
        }
        else
        if(n%2==0||n%3==0||n%5==0){
            return false;
        }
      // Iterate over the range [6, num]
        for (int i = 5; i * i <= n; i += 6) {
            if (n % (i) == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
        
 
    
    ArrayList<Integer> primeRange(int M, int N) {
        // code herefdsfsdf
         
        ArrayList<Integer>lst=new ArrayList<>();
        
        for(int i=M;i<=N;++i){
            if(prime(i))
            lst.add(i);
        }
        return lst;
        
        
        
    
}}