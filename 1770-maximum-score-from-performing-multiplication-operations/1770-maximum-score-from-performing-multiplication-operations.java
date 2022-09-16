class Solution {
    int dp(int[][] memo, int[] nums, int[] multipliers, int op, int left) {
        // For Right Pointer
        int n = nums.length;
        if (op == multipliers.length) {
            return 0;
        }
        
        // If already computed, return
        if (memo[op][left] != Integer.MAX_VALUE) {
            return memo[op][left];
        }
        
        int l = nums[left] * multipliers[op] + dp(memo, nums, multipliers, op + 1, left + 1);
        int r = nums[(n - 1) - (op - left)] * multipliers[op] + dp(memo, nums, multipliers, op + 1, left);
        
        return memo[op][left] = Math.max(l, r);
    }
    
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] memo = new int[nums.length + 1][multipliers.length + 1];
        
        for(int i=0;i<memo.length;++i){
            
            Arrays.fill(memo[i],Integer.MAX_VALUE);
        }
        // Zero operation done in the beginning
        return dp(memo, nums, multipliers, 0, 0);
    }
}