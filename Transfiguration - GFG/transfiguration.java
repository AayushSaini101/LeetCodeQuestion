// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transfigure (A, B));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transfigure (String A, String B)
    {
    	
    	if(A.length()!=B.length()){
    	    
    	    return -1;
    	}
    	int dp[]=new int[1000];
    	for(int i=0;i<A.length();++i){
    	    dp[A.charAt(i)-'A']++;
    	    dp[B.charAt(i)-'A']--;
    	}
    	
    	for(int i=0;i<dp.length;++i){
    	    if(dp[i]!=0){
    	        return -1;
    	    }
    	}
    	//ABC
    	//CBA
    	//We can change the characters 
    	//Start from the last characteres
    	int length1=A.length()-1;
    	int length2=B.length()-1;
    	int count=0;
    	
    	while(length1>=0&&length2>=0){
    	    
    	    if(A.charAt(length1)==B.charAt(length2)){
    	        --length1;
    	        --length2;
    	    }
    	    
    	    else{
    	        ++count;
    	        --length1;
    	        
    	    }
    	    
    	}
    	return count;
    	
    }
    
}