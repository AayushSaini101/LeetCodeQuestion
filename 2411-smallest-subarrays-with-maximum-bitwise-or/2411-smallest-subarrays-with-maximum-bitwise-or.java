class Solution {
    public int[] smallestSubarrays(int[] nums) {
        
        int answer[]=new int[32];
        
        Arrays.fill(answer,Integer.MAX_VALUE);
        
        int dp[]=new int[nums.length];
        
        for(int i=nums.length-1;i>=0;--i){
            
         
            int number=nums[i];
            
            int maxIndex=0;
            
            for(int j=0;j<32;++j){
            
                
                if((number&(1<<j))!=0){
                    
                    answer[j]=Math.min(answer[j],i);
                }
                
                if(answer[j]!=Integer.MAX_VALUE){
                    
                    maxIndex=Math.max(maxIndex,answer[j]);
                    
                }
                
            }
            
            if(maxIndex!=0){
                
                dp[i]=maxIndex-i+1;
            }
            else{
                
                dp[i]=1;
            }
            
            
        }
        return dp;
    }
    
}