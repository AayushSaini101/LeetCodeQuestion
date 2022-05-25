class Solution {
    public int lengthOfLIS(int[] nums) {
        
     int dp[]=new int[nums.length];
        
     Arrays.fill(dp,Integer.MAX_VALUE);
        
     dp[0]=nums[0];
        
     int count=1;
        
     for(int i=1;i<nums.length;++i){
         
         if(dp[i-1]<nums[i]){
             
             dp[count++]=nums[i];
         }
         else{
             //Find the position 
             int position=Arrays.binarySearch(dp,nums[i]);
             
             if(position<=0){
                 
                 position=(-1*position)-1;
                
                 position=Math.min(Math.max(0,position),nums.length-1);
                 
                 dp[position]=nums[i];
                 
             }
             else{
                 continue;
             }
             
         }
         
      
     }
        
      for(int i=0;i<dp.length;++i){
          System.out.print(dp[i]+" ");
          if(dp[i]==Integer.MAX_VALUE)
              return  i;
      }
        return dp.length;
    }
}