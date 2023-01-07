class Solution {
    public int numberOfSubstrings(String s) {
     
   
        //Substring contains only three characters a,b and c in the given substring 
        
        
        int dp[]=new int[3];
        
        int answer=0;
        
        int count=0;
        
        int left=0;
        
        for(int i=0;i<s.length();++i){
            
            int ch=s.charAt(i)-'a';
            
            dp[ch]++;
            
            while(dp[0]>0&&dp[1]>0&&dp[2]>0){
                
                int temp=s.charAt(count)-'a';
                
                dp[temp]--;
                
                ++count;
                
                
            }
            
            answer+=count;
        }
        
        return answer;
    }
        
        
}