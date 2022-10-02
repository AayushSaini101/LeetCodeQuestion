class Solution {
  
    
    long mod= (long)(10e9 + 7);
    
    Solution(){
          System.out.println(mod);
    }
  
     //1000000007 
    public long turns(int index,int n,int k,int target,long dp[][]){
        
        if(index>n&&target==0)return 1;
        
        if(index>n||target<0)return 0;
        
        if(dp[index][target]!=-1)return dp[index][target];
        
        long answer=0;
        
        
              for(int j=1;j<=k;++j){
                
                 
                  answer=(answer% 1000000007 +turns(index+1,n,k,target-j,dp)% 1000000007 )% 1000000007 ;
                
            }
        
        
       // return answer;
        return dp[index][target]=answer;
    }
    public int numRollsToTarget(int n, int k, int target) {

        long dp[][]=new long[n+1][target+1];
        
        for(int i=0;i<dp.length;++i){
            
            for(int j=0;j<dp[0].length;++j){
                
                dp[i][j]=-1;
            }
        }
        
        return (int) (turns(1,n,k,target,dp)%mod);
        
        
    }
}