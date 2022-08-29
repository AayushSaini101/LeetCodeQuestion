class Solution {
    public boolean check(int x,int y,char [][] grid){
        
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]=='0')return false;
        
        return true;
    }
    public void bfs(int x,int y,char [][]grid){
        
        if(grid[x][y]=='0'){
            
            return ;
        }
        
        grid[x][y]='0';
        
       
        int row[]={0,0,-1,1};
        int cols[]={-1,1,0,0};
        
        for(int i=0;i<row.length;++i){
            
            int nextX = x + row[i];
            
            int nextY = y + cols[i];
            
            if(check(nextX,nextY,grid)){
                
                bfs(nextX,nextY,grid);
            }
        }
        
        
    }
    public int numIslands(char[][] grid) {
        
        int count=0;
        
        for(int i=0;i<grid.length;++i){
            
            for(int j=0;j<grid[0].length;++j){
                
                if(grid[i][j]=='1'){
                    
                 //   System.out.println(i+" "+j);
                    
                    ++count;
                    
                    bfs(i,j,grid);
                }
            }
        }
        return count;
    }
}