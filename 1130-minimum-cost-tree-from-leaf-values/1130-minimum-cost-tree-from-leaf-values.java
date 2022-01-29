class Solution {
    int sum1=0;
    int min1=Integer.MAX_VALUE;
    public int max(int start,int end,int arr[]){
        int  max=0;
        for(int i=start;i<=end;++i){
            max=Math.max(arr[i],max);
        }
        return max;
    }
    public int find(int start,int end,int arr[],Integer dp[][]){
        //Only one element is present that is the leaf node
        if(end-start==1){
            return arr[start]*arr[end];
        }
        if(start==end){
           return 0;
        }
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        int min=Integer.MAX_VALUE;
        for(int i=start;i<end;++i){
             int left=find(start,i,arr,dp);
             int right=find(i+1,end,arr,dp);
           //We are finding the maximum value before teh number 
            //if we want to maximum value 
            int rangeleft=max(start,i,arr);
            
            int rangeRight=max(i+1,end,arr);
            
            
            min=Math.min(min,left+right+rangeleft*rangeRight);
            
        }
       
        dp[start][end]=min;
        return min;
    }
    public int mctFromLeafValues(int[] arr) {
     int start=0;
     int end=arr.length-1;
     Integer dp[][]=new Integer[arr.length][arr.length];
     return find(start,end,arr,dp);
    }
}