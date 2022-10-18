class Solution {
    public String countAndSay(int n) {
        
        String answer="1";
        
        for(int i=2;i<=n;++i){
        
            int index=0;
            
            int left=0;
            
            int count=0;
            
            String temp="";
            
            while(index<answer.length()){
                
                if(answer.charAt(left)==answer.charAt(index)){
                    
                    ++count;
                }
                else{
                    
                    temp+=count+""+answer.charAt(left);
                    
                    count=1;
                    
                    left=index;
                }
                
                ++index;
            }
            
              temp+=count+""+answer.charAt(left);
                    
              count=1;
                    
              left=index;
            
          //  System.out.println(temp);
            
            answer=temp;
        }
        
        return answer;
    }
}