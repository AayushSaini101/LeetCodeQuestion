class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0;
        for(int arr[]:accounts){
            int sum=0;
            for(int i=0;i<arr.length;++i){
                sum+=arr[i];
               
            }
             max=Math.max(sum,max);
        }
        return  max;
    }
}