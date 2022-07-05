class Solution {
    public int longestConsecutive(int[] nums) {
    
         HashSet<Integer>A=new HashSet<>();
        for(int i=0;i<nums.length;++i){
            A.add(nums[i]);
        }
        int max=0;

        for(int i=0;i<nums.length;++i){
            int temp=nums[i];
            int ans=0;
           if(!A.contains(temp-1)){
            while(A.contains(temp)){
            ++ans;
            ++temp;
            }
            max=Math.max(ans,max);
            }
        }
        return max;
    }
}