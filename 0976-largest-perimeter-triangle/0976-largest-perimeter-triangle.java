class Solution {
    public int largestPerimeter(int[] nums) {
     
        
        if(nums.length<3)return 0;
        
        
        int max=0;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;++i){
            
            if(nums[i]+nums[i+1]>nums[i+2]){
                
                max=Math.max(max,nums[i]+nums[i+1]+nums[i+2]);
            }
            
        }
        
        return max;
        
        
    }
}