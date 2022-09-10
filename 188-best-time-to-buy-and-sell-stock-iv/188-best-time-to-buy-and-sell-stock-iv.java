class Solution {
        static int find(int prices[],int index,int k,boolean bl,int dp[][][]){
        if(index>=prices.length){
            return 0;
        }
        if(k==0){
            return 0;
        }
        if(bl==false){
            if(dp[index][k][1]!=-1){
                return dp[index][k][1];
            }
            //Not pick the stock 
            dp[index][k][1]=Math.max(-prices[index]+find(prices,index+1,k,!bl,dp),find(prices,index+1,k,bl,dp));
            return dp[index][k][1];
        }
        else{
            if(dp[index][k][2]!=-1){
                return dp[index][k][2];
            }
            //we want to sell the valuel
            int first=prices[index]+find(prices,index+1,k-1,!bl,dp);
            int second=find(prices,index+1,k,bl,dp);
            dp[index][k][2]=Math.max(first,second);
            return dp[index][k][2];
        }
    }
    public int maxProfit(int k, int[] prices) {
        int dp[][][]=new int[prices.length+1][k+1][3];
        for(int i=0;i<dp.length;++i){
            for(int j=0;j<=k;++j){
                for(int kk=0;kk<=2;++kk){
                    dp[i][j][kk]=-1;
                }
            }
        }
        return find(prices,0,k,false,dp);
        
    }
}