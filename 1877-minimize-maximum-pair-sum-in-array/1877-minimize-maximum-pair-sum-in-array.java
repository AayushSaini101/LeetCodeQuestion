class Solution {
    public int minPairSum(int[] nums) {
    
        Arrays.sort(nums);
     
        int left=0;
        
        int right=nums.length-1;
        
        int maxSum=0;
        
        while(left<right){
        
            maxSum=Math.max(nums[left]+nums[right],maxSum);
            
            
            ++left;
            
            --right;
        }
        
        return maxSum;
        
        
    }
    
}