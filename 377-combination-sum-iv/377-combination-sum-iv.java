class Solution {
    
    //This is problem according the top down approach
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
        
      
     //Let's understand the bootom app approach to find 
        
      int dp[]=new int[1001];
        
    //This will be O(nums.length) approach 
    
      for(int elements:nums){
          
          dp[elements]=1;
      }
        
      for(int i=1;i<=target;++i){
          
          for(int j=0;j<nums.length;++j){
              
              if(nums[j]<i){
                  
                  dp[i]+=dp[i-nums[j]];
              }
          }
      }
        
   // System.out.println(Arrays.toString(dp));
        
    return dp[target];
        
    }
}