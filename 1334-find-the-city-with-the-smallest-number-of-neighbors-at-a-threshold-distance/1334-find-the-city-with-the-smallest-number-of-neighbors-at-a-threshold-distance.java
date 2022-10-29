class Solution {
    public int findTheCity(int n, int[][] edges, int th) {
     
        int dp[][]=new int[n][n];
        
        for(int i=0;i<dp.length;++i){
            
            for(int j=0;j<dp.length;++j){
                
                if(i!=j)
                    
                 dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<edges.length;++i){
            
            int u=edges[i][0];
            
            int v=edges[i][1];
            
            int distance=edges[i][2];
            
            dp[u][v]=distance;
            
            dp[v][u]=distance;
        }
        
        for(int i=0;i<n;++i){
            
            for(int j=0;j<n;++j){
                
                for(int k=0;k<n;++k){
                    
                    if(dp[j][i]!=Integer.MAX_VALUE&&dp[i][k]!=Integer.MAX_VALUE&&dp[j][k]>dp[j][i]+dp[i][k]){
                        
                        dp[j][k]=dp[j][i]+dp[i][k];
                        
                 
                    }
                }
            }
        }
        
      
       int min=Integer.MAX_VALUE;
        
       int index=0;
        
       for(int i=dp.length-1;i>=0;--i){
           
           
           
           int count=0;
           
           for(int j=0;j<dp.length;++j){
               
               if(dp[i][j]<=th){
                   
                   ++count;
                   
               }
           }
           
           if(min>count){
               
               index=i;
               
               min=count;
           }
       }
        
        return index;
        
        
        
        
        
        
    }
}