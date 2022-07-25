class Solution {
    public int binarySearch(int nums[],int target,int status){
        
        int start=0;
        
        int end=nums.length-1;
        
        int answer=nums.length;
        
        if(status==0){
            
          while(start<=end){
            
            int mid=(start+end)>>1;
        
           
            if(nums[mid]==target){
                
                //We want lower index value 
            
                
                if(mid==0){
                    
                    return mid;
                }
                
                else{
                    
                    answer=Math.min(answer,mid);
                    
                    end=mid-1;
                }
            }
            else
            
            if(nums[mid]>target){
                
                end=mid-1;
            }
            else{
                
                start=mid+1;
            }
         }
            
            return answer;
        }
        
        else{
            
         answer=-1;
            
         while(start<=end){
            
            int mid=(start+end)>>1;
              
            if(nums[mid]==target){
                
                //We want lower index value 
                
                if(mid==nums.length-1){
                    
                    return mid;
                }
                
                else{
                    
                    answer=Math.max(answer,mid);
                    
                    start=mid+1;
                }
            }
            else
            if(nums[mid]>target){
                
                end=mid-1;
            }
            else{
                
                start=mid+1;
            }
         }
            
        return answer;
            
        }
    }
    public int[] searchRange(int[] nums, int target) {
        
        int lower=binarySearch(nums,target,0);
        
        int higher=binarySearch(nums,target,1);
            
        if(lower==nums.length){
            
            lower=-1;
        }
        
        return new int[]{lower,higher};
    }
}