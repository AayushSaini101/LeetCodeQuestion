class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        
        for(int i=1;i<=str1.length();++i){
            
            for(int j=1;j<=str2.length();++j){
                
                 if(str1.charAt(i-1)==str2.charAt(j-1)){
                     
                     dp[i][j]=1+dp[i-1][j-1];
                 }
                 else{
                     
                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                 }
            }
        }
        
      
        int i=str1.length();
        
        int j=str2.length();
        
        StringBuffer answer=new StringBuffer("");
        
        while(i>=1&&j>=1){
            
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                
                answer.append(str1.charAt(i-1));
                
                --i;
                
                --j;
            }
            else
                if(dp[i-1][j]>dp[i][j-1]){
                    
                    answer.append(str1.charAt(i-1));
                    
                    --i;
                }
            else{
                
                answer.append(str2.charAt(j-1));
                
                --j;
            }
        }
   
        while(i>=1){
            
            answer.append(str1.charAt(i-1));
            --i;
        }
        while(j>=1){
               answer.append(str2.charAt(j-1));
            --j;
        }
    return answer.reverse().toString();
        
    }
}