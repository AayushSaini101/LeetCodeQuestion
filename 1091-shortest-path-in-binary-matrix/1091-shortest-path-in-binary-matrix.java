class Solution {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    static boolean check(int i,int j,int grid[][],boolean bl[][]){
                  
        if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&bl[i][j]==false&&grid[i][j]==0){
       
            return true;
        }
        return false;
        
    }
    //Always use the main 
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0){
            return -1;
        }
        int dp[][]=new int[grid.length+1][grid[0].length+1];
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        Queue<Pair>Q=new LinkedList<>();
        dp[0][0]=1;
        //Inserting the vertex inside the queue
        Q.add(new Pair(0,0));
        boolean bl[][]=new  boolean[grid.length+1][grid[0].length+1];
            
            
     while(Q.size()!=0){
            
         Pair remove=Q.remove();
         
         bl[remove.first][remove.second]=true;
         
         //we have 8 direction to move the vertex
         int row[]={0,0,1,1,1,-1,-1,-1};
         int cols[]={-1,1,0,-1,1,0,-1,1};
         
         for(int i=0;i<row.length;++i){
            if(check(row[i]+remove.first,cols[i]+remove.second,grid,bl)==true){
                System.out.println(i);
                if(dp[remove.first][remove.second]+1<dp[row[i]+remove.first][cols[i]+remove.second]){
                    
                    dp[row[i]+remove.first][cols[i]+remove.second]=dp[remove.first][remove.second]+1;
                    Q.add(new Pair(row[i]+remove.first,cols[i]+remove.second));
                    
                }
            } 
            
         }
            
       
     }
        
       
        if(dp[grid.length-1][grid[0].length-1]==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dp[grid.length-1][grid[0].length-1];
        }
        
        
        
    }
}