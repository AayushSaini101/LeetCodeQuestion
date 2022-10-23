class Solution {
    public int[] findErrorNums(int[] nums) {
     
     int dp[]=new int[nums.length+1];
        
     int number=0;
        
     for(int i=0;i<nums.length;++i){
         
         dp[nums[i]]++;
         
         if(dp[nums[i]]==2){
             
             number=nums[i];
         }
     }
        
        for(int i=1;i<=nums.length;++i){
            
            if(dp[i]==0){
                
                return new int[]{number,i};
            }
        }
        return new int[2];
    }
}