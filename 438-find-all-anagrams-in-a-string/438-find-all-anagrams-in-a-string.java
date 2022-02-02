class Solution {
    public boolean compare(int dp[],int dp2[]){
        for(int i=0;i<dp.length;++i){
            if(dp[i]!=dp2[i]&&dp[i]!=0){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()){
            return new LinkedList<>();
        }
        int dp[]=new int[26];
        
        for(int i=0;i<p.length();++i){
            //This is sorted form 
            dp[p.charAt(i)-'a']++;
        }
        
        int dp1[]=new int[26];
        
        for(int i=0;i<p.length();++i){
           
            dp1[s.charAt(i)-'a']++;
            
        }
        
        List<Integer>indexes=new LinkedList<>();
        
        if(compare(dp,dp1)){
            indexes.add(0);
        }
        
        for(int i=p.length();i<s.length();++i){
            
            dp1[s.charAt(i-p.length())-'a']--;
            
            dp1[s.charAt(i)-'a']++;
            
            if(compare(dp,dp1)){
                indexes.add(i-p.length()+1);
            }
        }
        return indexes;
        
        
        
        
        
    }
}