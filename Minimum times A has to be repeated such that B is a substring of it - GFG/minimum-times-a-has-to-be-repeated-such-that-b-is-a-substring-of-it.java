// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.minRepeats(A,B));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        // code here
           int count=1;
        String K=A;
        
        while(A.length()<=2*B.length())
        {
            int z=A.length();
            int z1=A.replace(B,"").length();
            if(z1!=z)
            return count;
            
            count++;
            A+=K;
        }
        return -1;
    }
};