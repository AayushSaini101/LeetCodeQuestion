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
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.xorCal(k));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int xorCal(int k){
        // code here
        int answer=0;
        int first=1;
        int last=(int)(Math.log(k)/Math.log(2));
        //System.out.println(last);
        while(true){
            if((first^(first+1))==k){
                return first;
            }
        int lastBit=(int)(Math.log(first)/Math.log(2));
        
         if(lastBit>last){
        
            return -1;   
        }
        
            
            first+=1;
           // return first;
        }
      //  return -1;
    }
}