class Solution {
    public int mod=(int)(1e9+7);
    public int find(int m,int n,int maxMove,int x,int y,int dp[][][]){
        //These are base cases 
        if(maxMove==-1){
            return 0;
        }
        if(x<0||x>=m||y<0||y>=n){
            return 1;
        }
        if(dp[x][y][maxMove]!=-1){
            return dp[x][y][maxMove];
        }
        int row[]={0,0,-1,1};
        int col[]={-1,1,0,0};
        
        int answer=0;
        
        for(int i=0;i<row.length;++i){
        
            answer=(answer%mod+find(m,n,maxMove-1,x-row[i],y-col[i],dp)%mod)%mod;
        }
        return dp[x][y][maxMove]= answer;
        
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int dp[][][]=new int[m][n][maxMove+1];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                for(int k=0;k<=maxMove;++k){
                   dp[i][j][k]=-1;
                    
                }
            }
        }
        
        return find(m,n,maxMove,startRow,startColumn,dp);
    }
}