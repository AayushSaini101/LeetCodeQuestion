class Solution {
    
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        
        int rowMax[] = new int[grid.length] ;
        
        int colMax[] = new int[grid[0].length];
        
        for(int i=0;i<grid[0].length;++i){
            
            int maxValue=Integer.MIN_VALUE;
            
            for(int j=0;j<grid.length;++j){
                
                maxValue=Math.max(maxValue,grid[j][i]);
            }
            
            colMax[i]=maxValue;
        }
        
         for(int i=0;i<grid.length;++i){
            
            int maxValue=Integer.MIN_VALUE;
            
            for(int j=0;j<grid[0].length;++j){
                
                maxValue=Math.max(maxValue,grid[i][j]);
            }
            
            rowMax[i]=maxValue;
         }
        
        
       // int answer[][]=new int[grid.length][grid[0].length];
        
        
        int answer=0;
        
        for(int i=0;i<grid.length;++i){
            
            for(int j=0;j<grid[0].length;++j){
                
               answer+=Math.min(rowMax[i],colMax[j])-grid[i][j];
            }
        }
        
        return answer;
    
        
        
    }
}