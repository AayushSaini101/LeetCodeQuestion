class Solution {
    public int find(int row,int index,int grid[][],int cost[][],int col,int dp[][]){
        
        //Move int the next row 
        if(row==grid.length-1){
            
            return grid[row][col];
        }
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        int answer=10000;
        
        for(int i=0;i<grid[0].length;++i){
             
             answer=Math.min(cost[grid[row][col]][i]+grid[row][col]+find(row+1,grid[row+1][i],grid,cost,i,dp),answer);
            
          
        }
        return dp[row][col]=answer;                        
                    
    }
    public int minPathCost(int[][] grid, int[][] moveCost) {
        
        int min=Integer.MAX_VALUE;
        
        int dp[][]=new int[grid.length][grid[0].length];
        
        for(int i=0;i<grid[0].length;++i){
            //Starting from the first row 
            
            int answer=find(0,grid[0][i],grid,moveCost,i,dp);
            
            min=Math.min(answer,min);
        }
        return min;
    }
}