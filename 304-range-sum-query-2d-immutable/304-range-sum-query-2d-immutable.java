class NumMatrix {

    private int mat[][];
    public NumMatrix(int[][] matrix) {
     
        this.mat=matrix;
        
        //Using the concept of the prefix sum 
        
        for(int i=0;i<mat.length;++i){
            
            for(int j=0;j<mat[0].length;++j){
                
                if(j!=0){
                    mat[i][j]+=mat[i][j-1];
                }
                
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    
        int minrow=Math.min(row1,row2);
        int maxrow=Math.max(row1,row2);
        
        int mincol=Math.min(col1,col2);
        int maxcol=Math.max(col1,col2);
        
        int sum=0;
        
      //  System.out.println(minrow+" "+maxrow);
        while(minrow<=maxrow){
            if(mincol==0){
                sum+=this.mat[minrow][maxcol];
            }
            else
            sum+=this.mat[minrow][maxcol]-this.mat[minrow][mincol==0?0:mincol-1];
            
            ++minrow;
        }
        return sum;
         
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */