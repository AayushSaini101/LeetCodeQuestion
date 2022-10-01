class Solution {
    public int ways(String s,int index,int dp[]){
        
        if(index==s.length()){
            
            return 1;
        }
        
        if(s.charAt(index)=='0')return 0;
        
         int second=0;
        
         if(dp[index]!=-1)return dp[index];
        
         int first=ways(s,index+1,dp);
        
          if(index+1<s.length()){
           
              int number=(s.charAt(index)-'0')*10+(s.charAt(index+1)-'0');
              
              if(number<=26){
                  
                  second=ways(s,index+2,dp);
              }
            
          }
        
        return dp[index]=first+second;
       
    }
    public int numDecodings(String s) {
     
      int dp[]=new int[s.length()];
        
      Arrays.fill(dp,-1);
        
      if(s.charAt(0)=='0')return 0;
        
        return ways(s,0,dp);
   
    }
}