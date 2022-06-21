class Solution {
    public int longestSubsequence(String s, int k) {
        
        int dp[]=new int[s.length()];
        
        int count=0;
        
        for(int i=0;i<s.length();++i){
            
            if(s.charAt(i)=='0'){
                
                dp[i]=0;
                
                ++count;
            }
            else{
                
                dp[i]=-1;
            }
        }
        
        long number=0l;
        int index=0;
        for(int i=s.length()-1;i>=0;--i){
            
            if(s.charAt(i)=='1'){
                //Can we put the number 
                
                long temp=number;
                
                temp|=(1l<<index);
                
                
                if(temp<=k){
                    
                    number=temp;
                    
                    ++count;
                }
                
                else{
                    
                    break;
                }
            }
            
            ++index;
        }
        
        return count;
    }
}