class Solution {
    public boolean check(String s1,String s2, String s3,int index1,int index2,int index3,int dp[][]){
        
        if(index1==s1.length()&&index2==s2.length()){
           
            if(index3==s3.length())return true;
            return false;
        }
        boolean answer=false;
        if(index1<s1.length()&&index2<s2.length()){
            if(dp[index1][index2]==1){
                return true;
            }
            else
                if(dp[index1][index2]==2){
                return false;
            }
            
        }
        if(index1<s1.length()&&s3.charAt(index3)==s1.charAt(index1)){
            
            answer|=check(s1,s2,s3,index1+1,index2,index3+1,dp);
        }
        if(index2<s2.length()&&s3.charAt(index3)==s2.charAt(index2)){
            answer|=check(s1,s2,s3,index1,index2+1,index3+1,dp);
        }
        
        if(answer==true){
            if(index1<s1.length()&&index2<s2.length()){
                dp[index1][index2]=1;
            }
        }
        else{
            if(index1<s1.length()&&index2<s2.length()){
                dp[index1][index2]=2;
            }
        }
        return answer;
        
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        
    if(s1.length()+s2.length()!=s3.length()){
        return false;
    }
     
     if(s3.isEmpty()==true&&s1.isEmpty()==true&&s2.isEmpty()==true){
         
         return true;
     }
        
     int dp[][]=new int[201][201];
  
     return check(s1,s2,s3,0,0,0,dp);  
    }
}