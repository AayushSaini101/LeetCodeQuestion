class Solution {
    public boolean checkValid(int i,int j,int dp[][]){
    //left diagonal 
    //Right diagonal 
    //In the vertical direction 
    int x=i;
    int y=j;
    
    while(x>=0&&y>=0){
        
        if(dp[x][y]==1){
            return false;
        }
        --x;
        --y;
    }
    x=i;
    y=j;
    
    while(x>=0&&y<dp[0].length){
        
        if(dp[x][y]==1){
            
            return false;
        }
        
        --x;
        ++y;
    }    
        
    x=i;
    y=j;
        
    while(x>=0){
        
        if(dp[x][y]==1){
            
            return false;
        }
        --x;
    }
        return true;
    }
    
    int count=0;
    
    public void find(int start,int dp[][]){
        
        if(start==dp.length){
            
        this.count=this.count+1;
            
         return ;
        }
        for(int i=0;i<dp[0].length;++i){
            
            //For any position there are two choices either 
            // we place the queen or not place the queen 
            if(checkValid(start,i,dp)){
                
                dp[start][i]=1;
                
                //Move to the next row of the matrix 
                
                find(start+1,dp);
                
                dp[start][i]=0;
                
            }
        }
    }
    public int totalNQueens(int n) {
     
      int dp[][]=new int[n][n];
      find(0,dp);
      return count;
    }
}