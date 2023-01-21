class Solution {
    
    public boolean valid(String str){
        
        String temp[]=str.split("[.]");
        
        for(int i=0;i<temp.length;++i){
            
            if(temp[i].length()==0||(temp[i].charAt(0)=='0'&&temp[i].length()>1))return false;
            
            long value=Long.parseLong(temp[i]);
            
            
            if(value>=0&&value<=255){
                
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public void generate(int index,String s,String helper,List<String>answer,int count){
        
        if(index==s.length()){
            
            
            if(count==0){
                
              
                
                if(valid(helper)){
                    
                    answer.add(new String(helper));
                    
                }
            }
            
            return;
            
        }
        if(count<0)return;
        
         if(helper.length()==0){
             
             generate(index+1,s,helper+s.charAt(index),answer,count);
         }
         else{
          
               generate(index+1,s,helper+s.charAt(index),answer,count);
                 
               generate(index,s,helper+".",answer,count-1);
         }
        
    }
    public List<String> restoreIpAddresses(String s) {
        
       List<String>answer=new ArrayList<>();
       generate(0,s,"",answer,3);
        
        return answer;
    }
}