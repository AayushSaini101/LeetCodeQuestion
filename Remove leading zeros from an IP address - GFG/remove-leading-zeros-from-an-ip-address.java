// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.newIPAdd(s));
                }
        }
}// } Driver Code Ends


//User function Template for Java
//import java.math.BigInteger; 
class Solution
{
    public String newIPAdd(String S)
    {
        // your code here
        //Split the String using taking the dot 
        String temp[]=S.split("[.]");
        //Reason
        StringBuffer ans=new StringBuffer("");
        int index=0;
        for(String elements:temp){
            if(index==temp.length-1){
            ans.append(new java.math.BigInteger(""+elements));
                
            }
            else{
                  ans.append(new java.math.BigInteger(elements));
                 ans.append(".");
            }
           
            ++index;
        }
      return ans.toString();
    }
}