class Solution {
    public boolean count(int arr[],int windowSize){
      //window size;
      int count=arr[windowSize-1];
        
      if(windowSize-count==count){
          
          return true;
      }
        
      for(int i=windowSize;i<arr.length;++i){
          
          int remaining=arr[i]-arr[i-windowSize];
          
          if(windowSize-remaining==remaining){
              
              return true;
          }
      }
        return false;
        
    }
    
    public int findMaxLength(int[] nums) {
        
        int startingLength=0;
        
        for(int i=1;i<nums.length;++i){
             
             if(nums[i]==1){
                 nums[i]=nums[i-1]+1;
             }
             else{
                 nums[i]=nums[i-1];
             }
        }
       
        if(nums.length%2==0){
            startingLength=nums.length;
        }
        else{
            startingLength=nums.length-1;
        }
        
        for(int i=startingLength;i>0;i-=2){
             if(count(nums,i)){
                 return i;
             }
        }
        return 0;
        
        
    }
}