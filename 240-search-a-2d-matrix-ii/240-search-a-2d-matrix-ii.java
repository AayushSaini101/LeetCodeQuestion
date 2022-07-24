class Solution {
    public int binary(int matrix[][],int row,int target){
        
        int start=0;
        
        int end=matrix[0].length-1;
        
        while(start<=end){
            
            int mid=(start+end)>>1;
            
            if(matrix[row][mid]==target){
                
                return mid;
            }
            else
                if(matrix[row][mid]>target){
                    
                    end=mid-1;
                }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //Approach using the simple transveral and check whether the element is prsent or not in teh matrix 
        
        //Using the binary search on the rows or columns to find the target element in the matrix 
        
         int i=matrix.length-1;
        
        
        
        while(i>=0){
            
          int index=binary(matrix,i,target);
            
       //   System.out.println(i);
            
          if(index!=-1){
              
              return true;
          }
            --i;
            
        }
        return false;
        
    }
}