class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
     
     
        int count=0;
        
        long sum=1;
        
        int answer=0;
        
        int index=0;
        
        int extra=0;
        
        
        for(int i=0;i<nums.length;++i){
        
            sum=sum*nums[i];
            
              while(index<nums.length&&sum>=k){
                     
                   sum=sum/nums[index++];
              }
                
            
            answer+=i-index+1;
            
        }
     
 
        if(answer<=0)return 0;
        
        return answer;
      
    }
}