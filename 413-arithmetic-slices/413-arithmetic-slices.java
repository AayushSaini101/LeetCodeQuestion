class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
       if(nums.length<=2){
           return 0;
       }
        int count=0;
        int answer=0;
        for(int i=1;i<nums.length-1;++i){
            if(nums[i]-nums[i-1]==nums[i+1]-nums[i]){
                ++count;
            }
            else{
                answer+=count*(count+1)/2;
                count=0;
            }
        }
        if(count!=0){
            answer+=count*(count+1)/2;
        }
        return answer;
    }
}