class Solution {
    public int maximum69Number (int num) {
     
        String str=""+num;
        
        String answer="";
        for(int i=0;i<str.length();++i){
            
            if(str.charAt(i)=='6'){
                
                if(i+1<str.length())
                    
                answer+=str.substring(0,i)+"9"+str.substring(i+1);
                
                else{
                       answer+=str.substring(0,i)+"9";
                    
                }
                
              break;
            }
            
        }
        
        if(answer.isEmpty()){
            
            return num;
        }
        
        return new Integer(answer.trim());
    }
}