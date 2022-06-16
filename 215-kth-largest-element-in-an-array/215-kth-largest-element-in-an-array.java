class Solution {
    //Using the quick sort algorithm
    public int point(int start,int end,int nums[]){
        
      int pivot=nums[end];
      int index=start-1;
        
      for(int i=start;i<end;++i){
          
           if(nums[i]>=pivot){
               //Swapping the number in the array
               
               ++index;
               
               int temp=nums[index];
               
               nums[index]=nums[i];
               
               nums[i]=temp;
               
           }
      }
        
       ++index;
       
        int temp=nums[index];
               
        nums[index]=pivot;
               
        nums[end]=temp;
        
        //This is the parition point 
        
      
        return index;
        
        
    }
    public int largestElement=0;
    
    public void kthlargest(int start,int end,int nums[],int k){
        if(start>=end){
            if(k==start){
                largestElement=nums[start];
            }
            return;
        }
        int partitionPoint=point(start,end,nums);
        
      
        
    
        if(partitionPoint==k){
            
            largestElement=nums[partitionPoint];
            
            return ;
        }
        else
            if(partitionPoint>k){
                
                end=partitionPoint-1;
                
                kthlargest(start,end,nums,k);
                
                
            }
        else{
              start=partitionPoint+1;
            
              kthlargest(start,end,nums,k);
                
            
            
        }
        
       
        
        
    }
    public int findKthLargest(int[] nums, int k) {
        
        kthlargest(0,nums.length-1,nums,k-1);
        
        return this.largestElement;
        
    }
}