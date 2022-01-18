class Solution {
    public int minimumMountainRemovals(int[] nums) {
        //This is the variation of the longest increasing subsequnce
        int left[]=new int[nums.length];
        int right[]=new int[nums.length];
       Arrays.fill(left,1);
        Arrays.fill(right,1);
    
        for(int i=0;i<nums.length;++i){
            for(int j=0;j<=i;++j){
                if(nums[j]<nums[i]){
                    //This means the previous number is smaller than the number 
                    left[i]=Math.max(left[j]+1,left[i]);
                }
            }
        }
         //We need to find the longest decreasing sequence
        // Increasing sequence from the end 
        for(int i=nums.length-1;i>=0;--i){
            for(int j=i;j<=nums.length-1;++j){
                if(nums[j]<nums[i]){ 
                   right[i]=Math.max(right[j]+1,right[i]);
                }
            }
        }
         int max=0;
        for(int i=1;i<nums.length-1;++i){
          // System.out.println(left[i]+" "+right[i]);
            if(left[i]!=1&&right[i]!=1)
            max=Math.max(max,(right[i]+left[i])-1);
        }
        
        
        return nums.length-max;
    }
}