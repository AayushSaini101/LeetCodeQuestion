class Solution {
    private int walk(int[] nums, int start, int rem,Integer dp[][]) { 
	    // base case
        if (rem == 0 && start == nums.length) {
            return 0;
        }
        if (rem == 0 || start == nums.length) {
		    // if we reach the end and have not used up all patitions
			// or have used up all partitions and have not reached the end,
			// we do not want to count the current way of partitioning.
			// Return MAX_VALUE so that we don't contribute to the return value.
            return Integer.MAX_VALUE;
        }
        if(dp[start][rem]!=null){
            return dp[start][rem];
        }
        
        int n = nums.length;
        int ret = Integer.MAX_VALUE;
        int curSum = 0;
        
       
      
		// try all positions to end the current partition.
        for (int i = start; i < n; i++) {
            curSum += nums[i];
            
			// answer for partitioning the subarray to the right of the current partition,
			// with one less partition number allowance, because we already used one
			// for the current partition. i.e. (rem - 1).
            int futureSum = walk(nums, i + 1, rem - 1,dp);

            // we want to minimum of the largest sum of the partitions.
            ret = Math.min(ret, Math.max(curSum, futureSum));
        }
        
      return dp[start][rem]=ret;
    }
    public int splitArray(int[] nums, int m) {
         Integer dp[][]=new Integer[nums.length+1][m+1];
        return walk(nums,0,m,dp);
    }
}