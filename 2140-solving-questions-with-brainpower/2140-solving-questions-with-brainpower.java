class Solution {
    public long ans(int index,int questions[][],long dp[]){
        if(index>=questions.length){
            //Cannot able to solve;
            return 0;
        }
        //There are two choices
        if(dp[index]!=-1){
         return dp[index];   
        }
        long first=questions[index][0]+ans(index+questions[index][1]+1,questions,dp);
       
        long second=ans(index+1,questions,dp);
        
        dp[index]=Math.max(first,second);
        return Math.max(first,second) ;
    
      
    }
    public long mostPoints(int[][] questions) {
        long dp[]=new long[questions.length];
        Arrays.fill(dp,-1);
        return ans(0,questions,dp);
    }
}