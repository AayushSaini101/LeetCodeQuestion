class Solution {
    public boolean validMove(int x,int y,char board[][],int dp[][]){
        if(x<0||x>=board.length||y<0||y>=board[0].length||board[x][y]=='X'||dp[x][y]==1){
            return false;
        }
        return true;
    }
    public void dfs(char board[][],int x,int y,int dp[][]){
        
        int rows[]={0,0,-1,1};
        int cols[]={-1,1,0,0};
        dp[x][y]=1;
        for(int i=0;i<rows.length;++i){
            int nextX=x+rows[i];
            int nextY=y+cols[i];
            if(validMove(nextX,nextY,board,dp)){
               
                dfs(board,nextX,nextY,dp);
                
            }
        }
    }
    public void print(int dp[][]){
        for(int i=0;i<dp.length;++i){
            for(int j=0;j<dp[0].length;++j){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void solve(char[][] board) {
     int dp[][]=new int[board.length][board[0].length];
     
    //Starting from the first row 
    
        for(int i=0;i<board[0].length;++i){
            if(board[0][i]=='O'&&dp[0][i]==0){
                dfs(board,0,i,dp);
               
                
            }
        }
    
        for(int i=0;i<board[0].length;++i){
            if(board[board.length-1][i]=='O'&&dp[dp.length-1][i]==0){
                dfs(board,dp.length-1,i,dp);
               
            }
        }
        
       
         for(int i=0;i<board.length;++i){
            if(board[i][0]=='O'&&dp[i][0]==0){
                dfs(board,i,0,dp);
            }
        }
  
         for(int i=0;i<board.length;++i){
            if(board[i][board[0].length-1]=='O'&&dp[i][board[0].length-1]==0){
               // System.out.println("Sdf");
                dfs(board,i,dp[0].length-1,dp);
                 
            }
        }
           //  print(dp);
       //  print(dp);
        
        //Updating hte values 
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(board[i][j]=='O'){
                    if(dp[i][j]==0){
                        board[i][j]='X';
                    }
                }
            }
        }
        
    
    }
}