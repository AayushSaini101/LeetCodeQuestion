class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int n = nums.length;
        int[] nNums = new int[21];
        for(int t: nums){
            nNums[t+10]++;
        }
        backtrack(n, res, new LinkedList(), nNums);
        return res;
    }
    
    private void backtrack(int l, List<List<Integer>> res, LinkedList<Integer> temp, int[] nNums) {
        if(l == 0) {
            res.add(new LinkedList(temp));
        }   
        for(int i = 0; i < 21;i++) {
            if(nNums[i] > 0) {
                temp.add(i-10);
                nNums[i]--;
                backtrack(l-1, res, temp, nNums);
                nNums[i]++;
                temp.removeLast();
            }
        }   
    }   
}