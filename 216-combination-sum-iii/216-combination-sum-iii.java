class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        bt(1 , 9 , new ArrayList() , res , k , n);
        return res;
    }
    void bt(int start , int end , List<Integer> curr , List<List<Integer>> res , int k , int total){
        if(total == 0 && curr.size() == k){
            res.add(new ArrayList (curr));
            return;
        }
        for(int i = start ; i <= end ; i++){
            curr.add(i);
            bt(i + 1 , end , curr , res , k , total - i);
            curr.remove(curr.size() - 1);
        }
    }
}