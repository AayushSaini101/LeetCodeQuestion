class Solution {
    public String longestPalindrome(String s) {
    boolean dp[][]=new boolean[s.length()][s.length()];
        int max=0;
        StringBuilder ans=new StringBuilder("");
        for(int i=0;i<s.length();++i){
            for(int j=0;j<=i;++j){
                if(s.charAt(i)==s.charAt(j)){
                    if(i-j<2){
                        dp[j][i]=true;
                    }
                    else{
                        dp[j][i]=dp[j+1][i-1];
                    }
                }
                if(dp[j][i]==true){
                    StringBuilder subs=new StringBuilder(s.substring(j,i+1));
                    if(max<subs.length()){
                        ans=subs;
                        max=subs.length();
                    }
                }
            }
        }
        return ans.toString();
        
    }
}