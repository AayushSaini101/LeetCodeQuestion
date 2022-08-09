class Solution {
    public boolean check(int index,int nums[],int dp[]){

    
       
        if(index>=nums.length){
            
            return true;
        }
        
        if(dp[index]!=0){
            
            if(dp[index]==1){
                
                return true;
            }
        
            return false;
        }
         boolean answer=false;
        
        if(index+1<nums.length&&nums[index]==nums[index+1]){
            
            answer|=check(index+2,nums,dp);
            
            if(index+2<nums.length){
                
                if(nums[index+2]==nums[index]){
                    
                    answer|=check(index+3,nums,dp);
                }
            }
        }
        
       else
           
           if(index+2<nums.length&&(nums[index+1]-nums[index])==1&&(nums[index+2]-nums[index+1])==1){
               
             
               answer|=check(index+3,nums,dp);
           }
        
         dp[index]=(answer==true?1:2);
        
        
         return answer;
        
        
        
        
    }
    public boolean validPartition(int[] nums) {
    
        int dp[]=new int[nums.length];

        
        return check(0,nums,dp);
    }
}