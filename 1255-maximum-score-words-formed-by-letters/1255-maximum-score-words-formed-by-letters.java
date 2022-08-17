class Solution {
    public int findScore(int index,String words[],int dp[],int score[],int status[]){
        
        if(index>=words.length){
            
            return 0;
        }
        
        int maxScore=0;
        
        
        for(int i=0;i<words.length;++i){
            
            //Use the word and move to th nex t
            
            if(status[i]==1){
                
                continue;
            }
            String str=words[i];
            
            int sum=0;
            
            int check=0;
    
            for(int j=0;j<str.length();++j){
                
               int ch=str.charAt(j)-'a';
                
                if(dp[ch]!=0){
                    
                    sum+=score[ch];
                    
                    dp[ch]--;
                }
                else{
                    
                    for(int k=0;k<j;++k){
                        
                        dp[str.charAt(k)-'a']++;
                        
                    }
                    
                    check=1;
                    
                    break;
                }
                
            }
            
            if(check==0){
                
                status[i]=1;
                
                maxScore=Math.max(maxScore,sum+findScore(index+1,words,dp,score,status));
                
                 for(int k=0;k<str.length();++k){
                        
                        dp[str.charAt(k)-'a']++;
                        
                 }
                status[i]=0;
                
            }
        }
        
        return maxScore;
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
     
       
        int freq[]=new int[26];
        
        for(Character ch:letters){
            
            freq[ch-'a']++;
        }
        
        int status[]=new int[words.length];
        
      //  System.out.println(Arrays.toString(freq));
        
        int maxScore=findScore(0,words,freq,score,status);
        
        
        return maxScore;
    }
}