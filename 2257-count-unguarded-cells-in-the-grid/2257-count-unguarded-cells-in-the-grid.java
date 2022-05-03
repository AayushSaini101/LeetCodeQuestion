class Solution {
    public int countUnguarded(int m, int n, int[][] gaurds, int[][] walls) {
         int matrix[][]=new int[m][n];
        
        for(int i=0;i<walls.length;++i){
            for(int j=0;j<walls[0].length;++j){
                matrix[walls[i][0]][walls[i][1]]=3;
            }
        }
        
       for(int i=0;i<gaurds.length;++i){
            for(int j=0;j<gaurds[0].length;++j){
                int x=gaurds[i][0];
                int y=gaurds[i][1];
                
                matrix[x][y]=1;
               
                int temp=x-1;
                
                while(temp>=0&&matrix[temp][y]!=3&&matrix[temp][y]!=1&&matrix[temp][y]!=2){
                    matrix[temp][y]=2;
                    --temp;
                }
                
                temp=x+1;
                
                while(temp<matrix.length&&matrix[temp][y]!=3&&matrix[temp][y]!=1&&matrix[temp][y]!=12){
                    matrix[temp][y]=12;
                    
                    ++temp;
                    
                }
                
                temp=y-1;
                
                while(temp>=0&&matrix[x][temp]!=3&&matrix[x][temp]!=1&&matrix[x][temp]!=21){
                    matrix[x][temp]=21;
                    --temp;
                    
                }
                
                temp=y+1;
                
                while(temp<matrix[0].length&&matrix[x][temp]!=3&&matrix[x][temp]!=1&&matrix[x][temp]!=32){
                    matrix[x][temp]=32;
                    ++temp;
                        
                    
                }
                  
                
            } 
        }
        int count=0;
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[0].length;++j){
               
                if(matrix[i][j]==0){
                    ++count;
                }
            }
          
        }
        return count;
        
    }
}