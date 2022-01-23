// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.arrangeString(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String arrangeString(String s)
        {
                int sum=0;
          StringBuffer sorted=new StringBuffer("");
           for(int i=0;i<s.length();++i){
               if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                   sorted.append(s.charAt(i));
               }
               else{
                   sum+=s.charAt(i)-48;
               }
           }
           char ch[]=sorted.toString().toCharArray();
           Arrays.sort(ch);
          return new String(ch)+""+sum;
        }
}
