// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java

class Solution{
    static class Pair{
        char ch;
        int index;
        Pair(char ch,int index){
            this.ch=ch;
            this.index=index;
        }
    }
    public static String moveRobots(String s1, String s2){
      if (s1.length() != s2.length()) return "No";
        int a1 = 0, b2 = 0;
        for(int i = 0; i < s1.length(); i++)
        {
            if (s1.charAt(i) == 'A') a1++;
            if (s2.charAt(i) == 'A') a1--; 
            if (s1.charAt(i) == 'B') b2--;
            if (s2.charAt(i) == 'B') b2++;
            if (a1 > 0 || b2 > 0 || (b2 < 0 && a1 < 0)) return "No";
        }
        return "Yes";
    }
}


// { Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s1=read.readLine();
            String s2=read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.moveRobots(s1, s2));
        }
    }
}  // } Driver Code Ends