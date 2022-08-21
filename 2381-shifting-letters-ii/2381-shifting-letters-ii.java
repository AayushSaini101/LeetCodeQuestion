class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
      int dp[]=new int[s.length()+1];
        
        for(int i=0;i<shifts.length;++i){
            
            int first=shifts[i][0];
            
            int second=shifts[i][1];
            
            int direction=shifts[i][2];
            
            
            if(direction==1){
                
                dp[first]+=1;
                
                dp[second+1]--;
            }
            else{
                
                dp[first]--;
                
                dp[second+1]++;
            }
        }
        
        for(int i=1;i<dp.length;++i){
            
            dp[i]+=dp[i-1];
        }
        
        String answer="";
     
     //   System.out.println(Arrays.toString(dp));
        
        for(int i=0;i<s.length();++i){

        
            int ch=s.charAt(i)-'a';
            
            int value=dp[i];
            
            if(value==0){
                
                answer+=s.charAt(i);
            }
            
            if(value>0){
                
                ch+=value;
                
                ch=ch%26;
                
                
                answer+=((char)('a'+ch));
            }
            else
                if(value<0){
                    
                   value=value*-1;
                    
                   value=value%26;
                    
                   if(value<=ch){
                       
                       answer+=((char)(s.charAt(i)-value));
                   }
                   else{
                       
                       value-=ch;
                       
                       answer+=((char)('z'-value+1));
                   }
                    
                    
                }
            
        }
        
        return answer;
        
    }
}