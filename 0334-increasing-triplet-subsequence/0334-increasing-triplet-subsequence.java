class Solution {
    public boolean increasingTriplet(int[] nums) {
     
    
       if(nums.length<3){
           
           return false;
       }
       int dp[]=new int[3];
        
       dp[0]=nums[0];
        
       int index=0;
        
       for(int i=1;i<nums.length;++i){
           
           if(index==2)return true;
           
           if(dp[index]<nums[i]){
               
               ++index;
               
               dp[index]=nums[i];
           }
           else{
               
             
               for(int j=0;j<=2;++j){
                   
                   if(dp[j]>=nums[i]){
                       
                       dp[j]=nums[i];
                       
                       break;
                   }
               }
           }
           
        
           System.out.println(Arrays.toString(dp));
           
       }
        
       return index==2;
           
        
        
    }
}