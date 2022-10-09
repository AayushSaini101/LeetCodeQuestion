class Solution {
    
    int mod=1000000007;
    
    public int find(int x,int y,int grid[][],int sum,int k,int dp[][][]){
        
        if(x<0||x>=grid.length||y<0||y>=grid[0].length)return 0;
        
        
        if(x==grid.length-1&&y==grid[0].length-1){
            
            sum+=grid[x][y];
                
            if(sum%k==0)
            
                return 1;
            
            return 0;
        }
        
        if(dp[x][y][sum%k]!=0){
            
            return dp[x][y][sum%k];
        }
        
        int first=find(x+1,y,grid,sum+grid[x][y],k,dp);
        
        int second=find(x,y+1,grid,sum+grid[x][y],k,dp);
        
        return dp[x][y][sum%k]=(first+second)%mod;
        
    }
    public int numberOfPaths(int[][] grid, int k) {
        
        
        int dp[][][]=new int[grid.length+1][grid[0].length+1][k+1];
        
        return find(0,0,grid,0,k,dp);
    }
}