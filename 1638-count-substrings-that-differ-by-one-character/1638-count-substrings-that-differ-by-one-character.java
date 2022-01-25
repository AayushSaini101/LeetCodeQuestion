class Solution {
    public int countSubstrings(String s, String t) {
        //Count the substrings that are equals
        int dp[][]=new int[s.length()+1][t.length()+1];
        //Count all the substrings that are not equal and differn by 1
        int count[][]=new int[s.length()+1][t.length()+1];
        //abad
        //abcd
        int answer=0;
        for(int i=1;i<=s.length();++i){
            for(int j=1;j<=t.length();++j){
                
                 if(s.charAt(i-1)==t.charAt(j-1)){
                    
                      dp[i][j]=1+dp[i-1][j-1];
                      count[i][j]=count[i-1][j-1];
                 }
                 else{
                     
                      count[i][j]=1+dp[i-1][j-1];
                     }
                    
                      answer+=count[i][j];
                 }
                
            
        }
       
        return answer;
    }
}