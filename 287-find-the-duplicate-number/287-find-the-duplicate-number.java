class Solution {
    public int findDuplicate(int[] nums) {
      
    
        for(int i=0;i<nums.length;++i){
            int number=Math.abs(nums[i]);
            
            if(nums[number-1]<0){
                return number;
            }
            
            nums[number-1]=-nums[number-1];
            
        }
        return 0;
    }
}