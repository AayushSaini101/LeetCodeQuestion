class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //This problem is similar to the merget intervals the merge capcity should be less than and          //equal ot the capacity
     int dp[]=new int[1001];
     for(int i=0;i<trips.length;++i){
         dp[trips[i][1]]+=trips[i][0];
         dp[trips[i][2]]-=trips[i][0];
     }
     for(int i=0;i<dp.length;++i){
         if(i!=0)
         dp[i]=dp[i-1]+dp[i];
         if(dp[i]>capacity){
             return false;
         }
     }
       
        return true;
        
    }
}