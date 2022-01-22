// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String str = read.readLine().trim(); 
            Solution obj = new Solution();
            int ans = obj.palindromeSubStrs(str);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    int palindromeSubStrs(String str) { 
        // code here     
        //Pallindrom substring using the dynamic programming 
        int dp[][]=new int[str.length()][str.length()];
        
        TreeSet<String>set=new TreeSet<>();
        
        for(int i=0;i<dp.length;++i){
            for(int j=0;j<dp.length;++j){
                if(i==j){
                    dp[i][j]=1;
                }
            }
        }
        
        for(int i=0;i<dp.length;++i){
            for(int j=0;j<=i;++j){
                if(str.charAt(i)==str.charAt(j)){
                  if(i-j==1){
                      dp[j][i]=1;
                      continue;
                  }
                  if(i==j){
                      continue;
                  }
                  else{
                      if(dp[j+1][i-1]==1){
                          dp[j][i]=1;
                      }
                  }
                   
                }
            }
        }
        
        for(int i=0;i<dp.length;++i){
            for(int j=0;j<dp.length;++j){
              if(dp[i][j]==1){
                 
                  set.add(str.substring(i,j+1));
              }
            }
           
            }
        return set.size();
        
    }
} 