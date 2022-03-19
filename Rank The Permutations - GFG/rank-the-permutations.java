// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution obj = new Solution();
            long ans = obj.findRank(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static long fact(long n){
	if(n==0){
		return 1;
	}
	long ans=fact(n-1);
	return n*ans;
}
    public long findRank(String m)
    {
        // Code here
        int dp[]=new int[26];
		for(int i=0;i<m.length();++i){
			dp[m.charAt(i)-'a']++;
		}
		long answer=0;
		for(int i=0;i<m.length();++i){
			//Find the character that are smaller
			int count=0;
			 dp[m.charAt(i)-'a']--;
			for(int j=0;j<m.charAt(i)-'a';++j){
				count+=dp[j];
			}

			answer+=count*fact(m.length()-1-i);

		}
		return answer+1;
    }
}