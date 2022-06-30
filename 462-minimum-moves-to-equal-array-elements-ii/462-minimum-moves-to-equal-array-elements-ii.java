class Solution {
    public int minMoves2(int[] nums) {
        
        if(nums.length==1){
            
            return 0;
        }
        Arrays.sort(nums);
        
        int sum=0;
        
        int median=nums[nums.length/2];
    
        for(int i=0;i<nums.length;++i){
            sum+=Math.abs(median-nums[i]);
        }
        return sum;
    }
}