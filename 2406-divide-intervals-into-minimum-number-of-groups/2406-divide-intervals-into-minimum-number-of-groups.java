class Solution {
    public int minGroups(int[][] intervals) {
        
       int dp[]=new int[1000002];
        
       for(int i=0;i<intervals.length;++i){
           
           dp[intervals[i][0]]++;
           
           dp[intervals[i][1]+1]--;
       }
        int max=0;
        
        
        for(int i=0;i<dp.length;++i){
            
           if(i!=0){
               
               dp[i]=dp[i]+dp[i-1];
           }
            
            max=Math.max(dp[i],max);
        }
        
        
        
        return max;
    }
}