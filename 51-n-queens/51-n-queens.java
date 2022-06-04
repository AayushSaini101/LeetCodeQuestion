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
    public void find(int start,int dp[][],List<List<String>>Lst){
        
        if(start==dp.length){
            
        List<String>lst=new ArrayList<>();
            
        for(int i=0;i<dp.length;++i){
            
            String stat="";
            for(int j=0;j<dp[0].length;++j){
                
                if(dp[i][j]==0){
                    stat+=".";
                }
                else{
                    stat+="Q";
                }
               
            }
            lst.add(stat);
            
           
        }
        Lst.add(lst);
            
           
            return ;
        }
        for(int i=0;i<dp[0].length;++i){
            
            //For any position there are two choices either 
            // we place the queen or not place the queen 
            if(checkValid(start,i,dp)){
                
                dp[start][i]=1;
                
                //Move to the next row of the matrix 
                
                find(start+1,dp,Lst);
                
                dp[start][i]=0;
                
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
     //No queens attack to other queen 
        
        int dp[][]=new int[n][n];
        
        List<List<String>>lst=new ArrayList<>();
        
        find(0,dp,lst);
    
        return lst;
    }
    
}