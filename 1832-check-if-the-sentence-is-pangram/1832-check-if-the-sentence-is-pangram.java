class Solution {
    public boolean checkIfPangram(String sentence) {
        
        int dp[]=new int[26];
        
        for(int i=0;i<sentence.length();++i){
            
            int key=sentence.charAt(i)-'a';
            
            dp[key]++;
        }
        
        for(int element:dp){
            
            if(element==0)return false;
        }
        
        return true;
    }
}