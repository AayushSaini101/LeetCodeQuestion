class Solution {
    public boolean find(int row,int matrix[][],int target){
        
        int start=0;
        int end=matrix[0].length-1;
        
        while(start<=end){
            
            int mid=(start+end)>>1;
            
            if(matrix[row][mid]==target){
                
                return true;
                
            }
            else
                if(matrix[row][mid]<target){
                    
                    start=mid+1;
                }
            else{
                
                end=mid-1;
                
            }
        }
        
        return false;
        
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        for(int i=0;i<matrix.length;++i){
            
            if(matrix[i][0]<=target&&target<=matrix[i][matrix[0].length-1]){
                
              
                
                if(find(i,matrix,target)){
                    
                    return true;
                }
            }
        }
        return false;
        
    }
}