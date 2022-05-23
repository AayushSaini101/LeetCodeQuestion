class Solution {
    public int find(int index,int dp[][], String str[],int m,int n,int dp1[][][]){
        
        if(index>=dp.length){
            
         return 0;
            
        }
        
        if(dp[index][0]>m||dp[index][1]>n){
            
            return find(index+1,dp,str,m,n,dp1);
        }
        else{
            if(dp1[index][m][n]!=0){
                
                return dp1[index][m][n];
            }
            //Use that string or not use that string 
            int first=0;
            int second=0;
            
             if(m-dp[index][0]>=0&&n-dp[index][1]>=0){
                 
                 first=1+find(index+1,dp,str,m-dp[index][0],n-dp[index][1],dp1);
             }
             
             second=find(index+1,dp,str,m,n,dp1);
            
        dp1[index][m][n]= Math.max(first,second);
            
            return dp1[index][m][n];
            
            
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        
        //We want the sum to be maximum 
        
        int dp[][]=new int[strs.length][2];
        
        for(int i=0;i<strs.length;++i){
            
            int countZero=0;
            
            int countOne=0;
            
            for(int j=0;j<strs[i].length();++j){
                
                if(strs[i].charAt(j)=='0'){
                    
                    ++countZero;
                }
                
                else{
                    
                    ++countOne;
                }
            }
            
            dp[i][0]=countZero;
            dp[i][1]=countOne;
        
        
        }
        
        int dp1[][][]=new int[strs.length+1][m+1][n+1];
        
        return find(0,dp,strs,m,n,dp1);
        
      
        
    }
}