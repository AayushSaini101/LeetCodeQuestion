class Solution {
    public int singleNumber(int[] nums) {
        int arr=0;
        for(int elements:nums){
            arr^=elements;
        }
        return arr;
    }
}