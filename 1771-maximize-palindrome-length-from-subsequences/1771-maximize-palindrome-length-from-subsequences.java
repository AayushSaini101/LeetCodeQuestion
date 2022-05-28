class Solution {
    public int max=0;
    
    String first="";
    String second="";
    
    public int find(String s,int i,int mid,int j,int dp[][]){
        
        if(i>j){
            
            return 0;
        }
     
        if(i==j){
            
            return 1;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        
        if(s.charAt(i)==s.charAt(j)){
            
           
          //  System.out.println(i+" "+j);
            int answer= 2+find(s,i+1,mid,j-1,dp);
            
            if(i<=mid&&j>mid){
               
                max=Math.max(max,answer);
              
            }
            return dp[i][j]=answer;
        }
        else{
            //There are two condition either move to the right or move ot the left 
            
            return dp[i][j]=Math.max(find(s,i+1,mid,j,dp),find(s,i,mid,j-1,dp));
        }
    }
    public int longestPalindrome(String word1, String word2) {
      
      
        int dp[][]=new int[2001][2001];
      //Concating the String 
      String answer=word1+word2;
        
      int mid=word1.length()-1;
        
       find(answer,0,mid,answer.length()-1,dp);
        
      
        return max;
    }
}