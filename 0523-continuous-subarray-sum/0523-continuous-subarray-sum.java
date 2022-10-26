class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       
        if(nums.length==1)return false;
     
  
        int dp[]=new int[nums.length];
        
        Arrays.fill(dp,-1);
        
        for(int i=0;i<nums.length;++i){
            
            int value=nums[i]%k;
           
            dp[i]=value;
            
            if(i!=0){
                
                if(dp[i-1]==dp[i]&&dp[i]==0){
                    
               
                    return true;
                }
                
            }
            
            
        }
        
      //  System.out.println(Arrays.toString(dp));
        
        
        HashSet<Integer>H=new HashSet<>();
        
        int sum=0;
        
        for(int i=0;i<dp.length;++i){
            
            if(dp[i]==0){
                
                continue;
            }
            
            sum+=dp[i];
            
            if(H.contains(sum%k)||sum%k==0){
                
              //  System.out.println(i);
                
                return true;
            }
            
            
            H.add((sum)%k);
        }
        
        return false;
    }
}