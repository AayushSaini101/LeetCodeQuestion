class Solution {
    
    public long mod=(long)1e9+7;
    
    public long power(int n){
        
        long power=1;
        
        long answer=2;
        
        while(n!=0){
            
            if((n&(1))!=0){
                
                power = (power * answer) % mod;
            }
            answer=(answer*answer)%mod;
            
            
            n/=2;
            
        }
    
        
        return power;
    }
    
    public long count(int nums[],int index,int sum,int k,long dp[][]){
        
        if(index==nums.length){
            
            return 1;
        }
        
        if(dp[index][sum]!=-1){
            
            return dp[index][sum];
        }
        
        int ways = 0;
    
        long skip = count(nums,index+1,sum,k, dp );
        
        long contains=0;
        
        if(sum+nums[index] < k){
            
            contains = count(nums,index+1,sum+nums[index],k,dp);
        }
        return dp[index][sum] = (skip%mod + contains%mod)%mod;
    }
    public int countPartitions(int[] nums, int k) {
        
        long sum = 0;
        
        for(int elements:nums){
            
            sum+=elements;
        }
        
        if(sum/2<k)return 0;
        
        
        long dp[][]=new long[nums.length][k+1];
        
        for(int i=0;i<dp.length;++i){
            
            Arrays.fill(dp[i],-1);
        }
     
        long answer = (power(nums.length)-(2*count(nums,0,0,k,dp))+mod)%mod;
        
      
        
        return (int)answer;
        
        

    }
}