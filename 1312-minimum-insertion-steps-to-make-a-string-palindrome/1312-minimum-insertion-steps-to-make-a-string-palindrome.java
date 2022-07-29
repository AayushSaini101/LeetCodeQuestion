class Solution {
    public int find(int length1,int length2,String first,String second){
        
       if(length1==0||length2==0){
           return 0;
       }
      
        int answer=0;
        
        if(first.charAt(length1-1)==second.charAt(length2-1)){
            
            answer=1+find(length1-1,length2-1,first,second);
            
        }
        else{
            answer=Math.max(find(length1-1,length2,first,second),find(length1,length2-1,first,second));
        }
        
        return answer;
    }
    public int minInsertions(String s) {
     
        
       String second=new StringBuffer(s).reverse().toString();
        
       int dp[][]=new int[s.length()+1][s.length()+1];
        
       for(int i=1;i<=s.length();++i){
           
           for(int j=1;j<=s.length();++j){
               
               if(s.charAt(i-1)==second.charAt(j-1)){
                   
                   dp[i][j]=1+dp[i-1][j-1];
               }
               else{
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
           }
       }
        
        return s.length()-dp[dp.length-1][dp.length-1];
    }
}