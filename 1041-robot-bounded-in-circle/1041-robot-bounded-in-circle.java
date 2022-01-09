class Solution {
    public boolean isRobotBounded(String instructions) {
           int dp[][]={{0,1},{1,0},{0,-1},{-1,0}};
                     //North  //East //south  //west
          int x=0;
          int y=0;
          int starting=0;
        
         for(int i=0;i<instructions.length();++i){
                if(instructions.charAt(i)=='G'){
                    x+=dp[starting][0];
                    y+=dp[starting][1];
                }
                else 
                    if(instructions.charAt(i)=='L'){
                        //At first it will  move to the west direction //the south //the east //then north       
                        starting=(starting+3)%4;
                    }
             else{
                 starting=(starting+1)%4;
             }
             
             
         }
        if(x==0&&y==0||starting!=0){
            return true;
        }
        return false;
        
    }
}