// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {
        //code here
        //Counting pairs that are divisibly the 
         long dp[]=new long[k];
         
         for(int i=0;i<arr.length;++i){
             
             dp[arr[i]%k]++;
             
         }
         long answer=0;
         
         int left=1;
         int right=k-1;
         
         if(dp[0]>1){
             
             long answer1=dp[0]-1;
             
             answer+=(answer1)*(answer1+1)/2;
         }
         while(left<=right){
             
             if(left==right){
                 
                 long value=dp[left]-1;
                 
                 answer+=(value)*(value+1)/2;
             }
             else{
             answer+=dp[left]*dp[right];
             }
          
             ++left;
             --right;
         }
         
         return answer;
    }
}