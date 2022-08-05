class Solution {
    
    public int find(int sum,int nums[],int target,int dp[]){
        
        if(sum==target){
            
            return 1;
        }
        if(sum>target){
            
            return 0;
        }
        
        if(dp[sum]!=-1){
            
            return dp[sum];
        }
        
        int answer=0;
        
        for(int i=0;i<nums.length;++i){
            
            answer+=find(sum+nums[i],nums,target,dp);
            
        }
        return dp[sum]=answer;
    }
    public int combinationSum4(int[] nums, int target) {
        
      
        int dp[]=new int[target];
        
        Arrays.fill(dp,-1);
        
        int ways=find(0,nums,target,dp);
        
        return ways;
    }
}