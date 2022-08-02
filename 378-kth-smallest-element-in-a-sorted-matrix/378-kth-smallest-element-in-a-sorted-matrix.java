class Solution {
    
    public int countSmallestElement(int matrix[][],int element){
        
    //Find the smallest number present in the matrix that are smaller than the current number 
        
        int count=0;
        
        int i=matrix.length-1;
        
        int j=0;
        
        while(i>=0&&j<matrix.length){
            
            if(matrix[i][j]>=element){
                
                --i;
            }
            else{
                
                count+=(i+1);
                
                 ++j;
            }
            
        }
        
      return count;
        
    }
    public int kthSmallest(int[][] matrix, int k) {
       
        int start=matrix[0][0];
        
        int end= matrix[matrix.length-1][matrix.length-1];
        
        int answer=0;
        
        while(start<=end){
            
            int mid=(start+end)>>1;
            
           int count=countSmallestElement(matrix,mid);
            
            if(count<k){
                
                answer=mid;
                
                start=mid+1;
            }
            else{
                
                end=mid-1;
            }
        }
        
        //This is the case when the value of the k is out of the limit 
        
        return answer;
    }
}