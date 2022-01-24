class Solution {
    public int countVowelStrings(int n) {
        
        if(n==1){
            return 5;
            
        }
        else{
            int dp[][]=new int[n+1][6];
             int sum=0;
            for(int i=1;i<=5;++i){
                dp[1][i]=5-(i-1);
                
            }
            if(n==2){
                return 15;
            }
            //Starting filling the table from 2 length
           
            for(int i=2;i<=n;++i){
                for(int j=5;j>=0;--j){
                    if(j==5){
                        dp[i][j]=dp[i-1][j];
                    }
                    else{
                        dp[i][j]=dp[i-1][j]+dp[i][j+1];
                    }
                    
                  
                }
            }
            for(int i=1;i<=5;++i){
                sum+=dp[n-1][i];
            }
            return sum;
            
        }
        
    }
}