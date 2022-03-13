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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for(int i = 0; i < k; i++){
                String[] s1 = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int mod=(int)1e9+7;
    static int find(int x,int y,int matrix[][],int dp[][]){
        if(x==matrix.length-1&&y==matrix[0].length-1){
            return 1;
        }
        if(x<0||y<0||x>=matrix.length||y>=matrix[0].length||matrix[x][y]==-1){
            return 0;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        
        int first=find(x+1,y,matrix,dp);
        int second=find(x,y+1,matrix,dp);
        return  dp[x][y]=(first+second)%mod;
       
    }
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
        // Code here
        int matrix[][]=new int[n][m];
        int dp[][]=new int[n][m];
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[0].length;++j){
                dp[i][j]=-1;
            }
        }
        
        
        for(int i=0;i<blocked_cells.length;++i){
           int x=blocked_cells[i][0]-1;
           int y=blocked_cells[i][1]-1;
            matrix[x][y]=-1;
        }
        if(matrix[0][0]==-1||matrix[n-1][m-1]==-1){
            return 0;
        }
        return find(0,0,matrix,dp);
      
       
       
    }
}