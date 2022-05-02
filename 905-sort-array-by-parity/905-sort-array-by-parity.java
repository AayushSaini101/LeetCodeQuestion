class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int index=-1;
        for(int i=0;i<nums.length;++i){
            if(nums[i]%2==0){
                ++index;
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
            }
        }
        return nums;
    }
}