class Solution {
    static int count(String first,String second,int length1,int length2,int dp[][]){
    if(length1==0){
        dp[length1][length2]=length2;
        return dp[length1][length2];
    }
    if(length2==0){
    dp[length1][length2]=length1;
    return dp[length1][length2];
    }
    if(dp[length1][length2]!=-1){
        return dp[length1][length2];
    }
    int ans=0;
    if(first.charAt(length1-1)==second.charAt(length2-1)){
ans+=count(first, second, length1-1, length2-1,dp);
    }
    else{
    int first_case=1+count(first, second, length1-1, length2,dp);
    int second_case=1+count(first, second, length1, length2-1,dp);
     return dp[length1][length2]= Math.min(first_case, second_case);
  
    }
    return ans;

}
    public int minDistance(String first, String second) {
        
 int dp[][]=new int[first.length()+1][second.length()+1];
 for(int i=0;i<dp.length;++i){
     for(int j=0;j<dp[0].length;++j){
         dp[i][j]=-1;
     }
 }
return count(first,second,first.length(),second.length(),dp);
       
    }
}