class Solution {
    public boolean check(int arr[],long mid,long k){
        long count=0;
        for(int elements:arr){
            count+=elements/mid;
        }
        if(count>=k){
            return true;
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        long start=1;
        long end=0;
        long answer=0;
        for(int elements:candies){
            end+=elements;
        }
        while(start<=end){
            long mid=(start+end)>>1;
            
            if(check(candies,mid,k)){
                answer=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return (int)(answer);
    }
}